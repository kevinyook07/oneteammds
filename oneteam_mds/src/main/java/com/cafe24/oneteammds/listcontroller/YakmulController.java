package com.cafe24.oneteammds.listcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.YakmulService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;

@Controller
public class YakmulController {

	@Autowired
	private YakmulService yakmulService;

	// 병원

	// 병원DB - 약물처방내역

	// 병원 권한 로그인시 입력되는 ID값 받아서 약물처방내역 리스트 출력 처리
	@RequestMapping("/yakmulhList")
	public String getYakmulList(@RequestParam(value = "hospitalId") String hospitalId, Model model) {

		model.addAttribute("yakmulhList", yakmulService.getYakmulhList(hospitalId));

		return "/yakmul/yakmulh/yakmulhList";
	}

	// 병원DB - 약물처방내역 --> 약물처방내역 regist form
	@RequestMapping("/yakmulRegist")
	public String getYakmulhById(@RequestParam(value = "patientId") String patientId, Model model) {

		model.addAttribute("yakmulh", yakmulService.getYakmulhById(patientId));

		return "yakmul/yakmulRegist/yakmulRegist";
	}

	// 병원DB - 약물처방내역 검색
	@PostMapping("/yakmulhList")
	public String getYakmulList(@RequestParam(value = "hospitalId") String hospitalId,
								@RequestParam(value = "sk") String sk
							   ,@RequestParam(value = "sv") String sv
							   ,@RequestParam(value = "start_date") String start_date
							   ,@RequestParam(value = "finish_date") String finish_date							   
							   , Model model) {
		List<Yakmulh> list = yakmulService.getYakmulSearchList(hospitalId, sk, sv, start_date, finish_date);
		model.addAttribute("yakmulhList", list);

		return "/yakmul/yakmulh/yakmulhList";

	}

	// 시스템DB

	// 약물처방내역 regist complete --> MDS DB - 약물처방내역
	@RequestMapping("/yakmulComplete")
	public String getYakmulRegist(Yakmul yakmul) {

		yakmulService.getYakmulRegist(yakmul);

		return "/yakmul/yakmulRegist/yakmulComplete";
	}

	// MDS DB - 약물처방내역 리스트
	@RequestMapping("/yakmuldbList")
	public String getYakmuldbList(Model model) {

		model.addAttribute("yakmuldbList", yakmulService.getYakmuldbList());

		return "/yakmul/yakmul/yakmuldbList";
	}

	// MDS DB - 약물처방내역 검색
	@PostMapping("/yakmuldbList")
	public String getYakmuldbList(@RequestParam(value = "sk1") String sk1
							     ,@RequestParam(value = "sk2") String sk2
						   	     ,@RequestParam(value = "sv1") String sv1
						   	     ,@RequestParam(value = "sv2") String sv2
								 ,@RequestParam(value = "start_date") String start_date
								 ,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Yakmul> list = yakmulService.getYakmuldbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);
		model.addAttribute("yakmuldbList", list);

		return "/yakmul/yakmul/yakmuldbList";

	}

	// MDS DB - 약물처방내역 삭제
	@GetMapping("/delYakmul")
	public String delYakmul(@RequestParam(value = "mbCode") String mbCode, Model model) {
		model.addAttribute("mbCode", mbCode);

		return "/yakmul/ydelete/delYakmul";
	}

	@PostMapping("/delYakmul")
	public String delYakmul(@RequestParam(value = "mbCode") String mbCode,
			@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
			Model model) {
		int result = yakmulService.delYakmul(mbCode, hospitalId, patientId);
		if (result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("mbCode", mbCode);
			return "/yakmul/ydelete/delYakmul";
		}
		return "redirect:/yakmuldbList";
	}

}
