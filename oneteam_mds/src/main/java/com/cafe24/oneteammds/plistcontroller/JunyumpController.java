package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.JunyumService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Junyumh;
import com.cafe24.oneteammds.plistservice.JunyumpService;

@Controller
public class JunyumpController {

	@Autowired
	private JunyumpService junyumpService;

	// 환자 - 법정 전염성 감염병 리스트
	@RequestMapping("/junyumpList")
	public String getJunyumpList(Model model) {

		model.addAttribute("junyumpList", junyumpService.getJunyumpList());

		return "/junyum/junyum/junyumpList";
	}

	// 환자 - 법정 전염성 감염병 검색
	@PostMapping("/junyumpList")
	public String getJunyumpList(@RequestParam(value = "start_date") String start_date,
			@RequestParam(value = "finish_date") String finish_date, Model model) {
		List<Junyum> list = junyumpService.getJunyumpSearchList(start_date, finish_date);
		model.addAttribute("junyumpList", list);

		return "/junyum/junyum/junyumpList";
	}

}
