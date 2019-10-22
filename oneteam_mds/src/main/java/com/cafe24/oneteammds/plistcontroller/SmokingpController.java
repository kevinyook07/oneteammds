package com.cafe24.oneteammds.plistcontroller;

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
import com.cafe24.oneteammds.plistservice.SmokingpService;

@Controller
public class SmokingpController {

	@Autowired
	private SmokingpService smokingpService;

	// 환자 - 흡연상태 리스트
	@RequestMapping("/smokingpList")
	public String getSmokingpList(Model model) {

		model.addAttribute("smokingpList", smokingpService.getSmokingpList());

		return "/smoking/smoking/smokingpList";
	}

	// 환자 - 흡연상태 검색
	@PostMapping("/smokingpList")
	public String getSmokingpList(@RequestParam(value = "start_date") String start_date,
			@RequestParam(value = "finish_date") String finish_date, Model model) {
		List<Smoking> list = smokingpService.getSmokringpSearchList(start_date, finish_date);
		model.addAttribute("smokingpList", list);

		return "/smoking/smoking/smokingpList";
	}

}
