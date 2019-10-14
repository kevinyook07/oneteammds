package com.cafe24.oneteammds.listcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.SmokingService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Smoking;
import com.cafe24.oneteammds.listvo.Smokingh;

@Controller
public class SmokingController {

	@Autowired
	private SmokingService smokingService;

	// 병원

	// 병원DB - 흡연상태

	// 병원 권한 로그인시 입력되는 ID값 받아서 흡연상태 리스트 출력 처리
	@RequestMapping("/smokinghList")
	public String getSmokingList(@RequestParam(value = "hospitalId") String hospitalId, Model model) {

		model.addAttribute("smokinghList", smokingService.getSmokinghList(hospitalId));

		return "/smoking/smokingh/smokinghList";
	}

	// 병원DB - 흡연상태 --> 흡연상태 regist form
	@RequestMapping("/smokingRegist")
	public String getSmokinghById(@RequestParam(value = "patientId") String patientId, Model model) {

		model.addAttribute("smokingh", smokingService.getSmokinghById(patientId));

		return "smoking/smokingRegist/smokingRegist";
	}

	// 병원DB - 흡연상태 검색
	@PostMapping("/smokinghList")
	public String getSmokingList(@RequestParam(value = "hospitalId") String hospitalId
								,@RequestParam(value = "sk") String sk
								,@RequestParam(value = "sv") String sv
								,@RequestParam(value = "start_date") String start_date
								,@RequestParam(value = "finish_date") String finish_date
								, Model model) {
		List<Smokingh> list = smokingService.getSmokringSearchList(hospitalId, sk, sv, start_date, finish_date);
		model.addAttribute("smokinghList", list);

		return "/smoking/smokingh/smokinghList";
	}

	// 시스템DB

	// 흡연상태 regist complete --> MDS DB - 흡연상태
	@RequestMapping("/smokingComplete")
	public String getSmokingRegist(Smoking smoking) {

		smokingService.getSmokingRegist(smoking);

		return "/smoking/smokingRegist/smokingComplete";
	}

	// MDS DB - 흡연상태 리스트
	@RequestMapping("/smokingdbList")
	public String getSmokingdbList(Model model) {

		model.addAttribute("smokingdbList", smokingService.getSmokingdbList());

		return "/smoking/smoking/smokingdbList";
	}

	// MDS DB - 흡연상태 검색
	@PostMapping("/smokingdbList")
	public String getSmokingdbList(@RequestParam(value = "sk1") String sk1
							      ,@RequestParam(value = "sk2") String sk2
						   	      ,@RequestParam(value = "sv1") String sv1
						   	      ,@RequestParam(value = "sv2") String sv2
								  ,@RequestParam(value = "start_date") String start_date
								  ,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Smoking> list = smokingService.getSmokringdbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);
		model.addAttribute("smokingdbList", list);

		return "/smoking/smoking/smokingdbList";
	}

	// 흡연상태 삭제
	@GetMapping("/delSmoking")
	public String delSmoking(@RequestParam(value = "scCode") String scCode, Model model) {
		model.addAttribute("scCode", scCode);

		return "smoking/sdelete/delSmoking";
	}

	@PostMapping("/delSmoking")
	public String delSmoking(@RequestParam(value = "scCode") String scCode,
			@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
			Model model) {
		int result = smokingService.delSmoking(scCode, hospitalId, patientId);
		if (result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다..");
			model.addAttribute("scCode", scCode);
			return "/smoking/sdelete/delSmoking";
		}
		return "redirect:/smokingdbList";

	}

}
