package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.plistservice.JindanpService;

@Controller
public class JindanpController {

	@Autowired
	private JindanpService jindanpService;

	// 환자 - 진단내역 리스트
	@GetMapping("/jindanpList")
	public String getJindanpList(Model model) {

		model.addAttribute("jindanpList", jindanpService.getJindanpList());

		return "/jindan/jindan/jindanpList";
	}

	// 환자 - 진단내역 검색
	@PostMapping("/jindanpList")
	public String getJindanpSearchList(@RequestParam(value = "start_date") String start_date,
			@RequestParam(value = "finish_date") String finish_date, Model model) {
		List<Jindan> list = jindanpService.getJindanpSearchList(start_date, finish_date);
		model.addAttribute("jindanpList", list);

		return "/jindan/jindan/jindanpList";
	}

}