package com.cafe24.oneteammds.listcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.SusulService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Susulh;

@Controller
public class SusulController {

	@Autowired
	private SusulService susulService;

	// 병원

	// 병원DB - 수술내역

	// 병원 권한 로그인시 입력되는 ID값 받아서 수술내역 리스트 출력 처리
	@RequestMapping("/susulhList")
	public String getSusulList(@RequestParam(value = "hospitalId") String hospitalId, Model model) {

		model.addAttribute("susulhList", susulService.getSusulhList(hospitalId));

		return "/susul/susulh/susulhList";
	}

	// 병원DB - 수술내역 --> 수술내역 regist form
	@RequestMapping("/susulRegist")
	public String getSusulhById(@RequestParam(value = "patientId") String patientId, Model model) {

		model.addAttribute("susulh", susulService.getSusulhById(patientId));

		return "susul/susulRegist/susulRegist";
	}

	// 병원DB - 수술내역 검색
	@PostMapping("/susulhList")
	public String getSusulList(@RequestParam(value = "hospitalId") String hospitalId,
			@RequestParam(value = "sk") String sk, @RequestParam(value = "sv") String sv, Model model) {
		List<Susulh> list = susulService.getSusulSearchList(hospitalId, sk, sv);
		model.addAttribute("susulhList", list);

		return "/susul/susulh/susulhList";
	}

	// 시스템DB

	// 수술내역 regist complete --> MDS DB - 수술내역
	@RequestMapping("/susulComplete")
	public String getSusulRegist(Susul susul) {

		susulService.getSusulRegist(susul);

		return "/susul/susulRegist/susulComplete";
	}

	// MDS DB - 수술내역 리스트
	@RequestMapping("/susuldbList")
	public String getSusuldbList(Model model) {

		model.addAttribute("susuldbList", susulService.getSusuldbList());

		return "/susul/susul/susuldbList";
	}

	// MDS DB - 수술내역 검색
	@PostMapping("/susuldbList")
	public String getSusuldbList(@RequestParam(value = "sk") String sk, @RequestParam(value = "sv") String sv,
			Model model) {
		List<Susul> list = susulService.getSusuldbSearchList(sk, sv);
		model.addAttribute("susuldbList", list);

		return "/susul/susul/susuldbList";
	}

	// MDS DB - 수술내역 삭제
	@GetMapping("/delSusul")
	public String delSusul(@RequestParam(value = "sbCode") String sbCode, Model model) {
		model.addAttribute("sbCode", sbCode);

		return "susul/sdelete/delSusul";
	}

	@PostMapping("/delSusul")
	public String delSusul(@RequestParam(value = "sbCode") String sbCode,
			@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
			Model model) {
		int result = susulService.delSusul(sbCode, hospitalId, patientId);
		if (result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다..");
			model.addAttribute("sbCode", sbCode);
			return "/susul/sdelete/delSusul";
		}
		return "redirect:/susuldbList";
	}

}
