package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.GumcheService;
import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Gumcheh;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.plistservice.GumchepService;

@Controller
public class GumchepController {

	@Autowired
	private GumchepService gumchepService;

	// 환자 - 검체검사결과 리스트
	@RequestMapping("/gumchepList")
	public String getGumchepList(Model model) {

		model.addAttribute("gumchepList", gumchepService.getGumchepList());

		return "/gumche/gumche/gumchepList";
	}

	// 환자 - 검체검사결과 검색
	@PostMapping("/gumchepList")
	public String getGumchepList(@RequestParam(value = "start_date") String start_date,
			@RequestParam(value = "finish_date") String finish_date, Model model) {
		List<Gumche> list = gumchepService.getGumchepSearchList(start_date, finish_date);
		model.addAttribute("gumchepList", list);

		return "/gumche/gumche/gumchepList";

	}

}
