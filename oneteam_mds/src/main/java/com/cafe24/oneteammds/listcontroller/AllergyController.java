package com.cafe24.oneteammds.listcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.AllergyService;
import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.listvo.Allergyh;
import com.cafe24.oneteammds.listvo.Jindan;

@Controller
public class AllergyController {

	@Autowired
	private AllergyService allergyService;

	// 병원

	// 병원DB - 알러지 및 부작용

	// 병원 권한 로그인시 입력되는 ID값 받아서 알러지 및 부작용 리스트 출력 처리
	@RequestMapping("/allergyhList")
	public String getAllergyList(@RequestParam(value = "hospitalId") String hospitalId, Model model) {

		model.addAttribute("allergyhList", allergyService.getAllergyhList(hospitalId));

		return "/allergy/allergyh/allergyhList";
	}

	// 병원DB - 알러지 및 부작용 --> 알러지 및 부작용 regist form
	@RequestMapping("/allergyRegist")
	public String getAllergyhById(@RequestParam(value = "patientId") String patientId, Model model) {

		model.addAttribute("allergyh", allergyService.getAllergyhById(patientId));

		return "allergy/allergyRegist/allergyRegist";
	}

	// 병원DB - 알러지 및 부작용 검색
	@PostMapping("/allergyhList")
	public String getAllergyList(@RequestParam(value = "hospitalId") String hospitalId
								,@RequestParam(value = "sk1") String sk1
							    ,@RequestParam(value = "sk2") String sk2
						   	    ,@RequestParam(value = "sv1") String sv1
						   	    ,@RequestParam(value = "sv2") String sv2
								,@RequestParam(value = "start_date") String start_date
								,@RequestParam(value = "finish_date") String finish_date
			, Model model) {
		List<Allergyh> list = allergyService.getAllergySearchList(hospitalId, sk1, sk2, sv1, sv2, start_date, finish_date);
		model.addAttribute("allergyhList", list);

		return "/allergy/allergyh/allergyhList";

	}

	// 시스템DB

	// 알러지 및 부작용 regist complete --> MDS DB - 알러지 및 부작용
	@RequestMapping("/allergyComplete")
	public String getAllergyRegist(Allergy allergy) {

		allergyService.getAllergyRegist(allergy);

		return "/allergy/allergyRegist/allergyComplete";
	}

	@RequestMapping("/allergydbList")
	public String getAllergydbList(Model model) {

		model.addAttribute("allergydbList", allergyService.getAllergydbList());

		return "/allergy/allergy/allergydbList";
	}

	// MDS DB - 알러지 및 부작용 검색
	@PostMapping("/allergydbList")
	public String getAllergydbSearchList(@RequestParam(value = "sk1") String sk1
									    ,@RequestParam(value = "sk2") String sk2
									    ,@RequestParam(value = "sk3") String sk3
									   	,@RequestParam(value = "sv1") String sv1
									   	,@RequestParam(value = "sv2") String sv2
									   	,@RequestParam(value = "sv3") String sv3
										,@RequestParam(value = "start_date") String start_date
										,@RequestParam(value = "finish_date") String finish_date,						
			Model model) {
		List<Allergy> list = allergyService.getAllergydbSearchList(sk1, sk2, sk3, sv1, sv2, sv3, start_date, finish_date);
		model.addAttribute("allergydbList", list);

		return "/allergy/allergy/allergydbList";
	}

	// MDS DB - 알러지 및 부작용 삭제
	@GetMapping("/delAllergy")
	public String delAllergy(@RequestParam(value = "aseCode") String aseCode, Model model) {
		model.addAttribute("aseCode", aseCode);

		return "/allergy/adelete/delAllergy";
	}

	@PostMapping("/delAllergy")
	public String delYakmul(@RequestParam(value = "aseCode") String aseCode,
			@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
			Model model) {
		int result = allergyService.delAllergy(aseCode, hospitalId, patientId);
		if (result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("aseCode", aseCode);
			return "/allergy/adelete/delAllergy";
		}
		return "redirect:/allergydbList";
	}

}
