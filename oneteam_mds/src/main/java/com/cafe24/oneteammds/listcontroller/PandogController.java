package com.cafe24.oneteammds.listcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.PandogService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;

@Controller
public class PandogController {

	@Autowired
	private PandogService pandogService;

	// 병원

	// 병원DB - 영상판독정보

	// 병원 권한 로그인시 입력되는 ID값 받아서 영상판독정보 리스트 출력 처리
	@RequestMapping("/pandoghList")
	public String getPandogList(@RequestParam(value = "hospitalId") String hospitalId, Model model) {

		model.addAttribute("pandoghList", pandogService.getPandoghList(hospitalId));

		return "/pandog/pandogh/pandoghList";
	}

	// 병원DB - 영상판독정보 --> 영상판독정보 regist form
	@RequestMapping("/pandogRegist")
	public String getPandoghById(@RequestParam(value = "patientId") String patientId, Model model) {

		model.addAttribute("pandogh", pandogService.getPandoghById(patientId));

		return "pandog/pandogRegist/pandogRegist";
	}

	// 병원DB - 영상판독정보 검색
	@PostMapping("/pandoghList")
	public String getPandogList(@RequestParam(value = "hospitalId") String hospitalId
							   ,@RequestParam(value = "sk1") String sk1
							   ,@RequestParam(value = "sk2") String sk2
						   	   ,@RequestParam(value = "sv1") String sv1
						   	   ,@RequestParam(value = "sv2") String sv2
							   ,@RequestParam(value = "start_date") String start_date
							   ,@RequestParam(value = "finish_date") String finish_date
							   , Model model) {
		List<Pandogh> list = pandogService.getPandogSearchList(hospitalId, sk1, sk2, sv1, sv2, start_date, finish_date);
		model.addAttribute("pandoghList", list);

		return "/pandog/pandogh/pandoghList";
	}

	// 시스템DB

	// 음주상태 regist complete --> MDS DB - 영상판독정보
	@RequestMapping("/pandogComplete")
	public String getPandogRegist(Pandog pandog) {

		pandogService.getPandogRegist(pandog);

		return "/pandog/pandogRegist/pandogComplete";
	}

	// MDS DB - 영상판독정보 리스트
	@RequestMapping("/pandogdbList")
	public String getPandogdbList(Model model) {

		model.addAttribute("pandogdbList", pandogService.getPandogdbList());

		return "/pandog/pandog/pandogdbList";
	}

	// MDS DB - 영상판독정보 검색
	@PostMapping("/pandogdbList")
	public String getPandogdbList(@RequestParam(value = "sk1") String sk1
								 ,@RequestParam(value = "sk2") String sk2
								 ,@RequestParam(value = "sk3") String sk3
								 ,@RequestParam(value = "sv1") String sv1
								 ,@RequestParam(value = "sv2") String sv2
								 ,@RequestParam(value = "sv3") String sv3
								 ,@RequestParam(value = "start_date") String start_date
								 ,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Pandog> list = pandogService.getPandogdbSearchList(sk1, sk2, sk3, sv1, sv2, sv3, start_date, finish_date);
		model.addAttribute("pandogdbList", list);

		return "/pandog/pandog/pandogdbList";
	}

	// MDS DB - 영상판독정보 삭제
	@GetMapping("/delPandog")
	public String delPandog(@RequestParam(value = "iidCode") String iidCode, Model model) {
		model.addAttribute("iidCode", iidCode);

		return "pandog/pdelete/delPandog";
	}

	@PostMapping("/delPandog")
	public String delPandog(@RequestParam(value = "iidCode") String iidCode,
			@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
			Model model) {
		int result = pandogService.delPandog(iidCode, hospitalId, patientId);
		if (result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다..");
			model.addAttribute("iidCode", iidCode);
			return "/pandog/pdelete/delPandog";
		}
		return "redirect:/pandogdbList";
	}
}
