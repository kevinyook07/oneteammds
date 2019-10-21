package com.cafe24.oneteammds.plistcontroller;

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
import com.cafe24.oneteammds.plistservice.AllergypService;

@Controller
public class AllergypController {

	@Autowired
	private AllergypService allergypService;

	
	

	

	@RequestMapping("/allergypList")
	public String getAllergypList(Model model) {

		model.addAttribute("allergypList", allergypService.getAllergypList());

		return "/allergy/allergy/allergypList";
	}

	// MDS p - 알러지 및 부작용 검색
	@PostMapping("/allergypList")
	public String getAllergypSearchList(
										@RequestParam(value = "start_date") String start_date
										,@RequestParam(value = "finish_date") String finish_date,						
			Model model) {
		List<Allergy> list = allergypService.getAllergypSearchList(start_date, finish_date);
		model.addAttribute("allergypList", list);

		return "/allergy/allergy/allergypList";
	}

}