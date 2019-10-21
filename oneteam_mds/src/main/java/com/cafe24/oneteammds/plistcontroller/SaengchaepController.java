package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.SaengchaeService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Saengchaeh;
import com.cafe24.oneteammds.plistservice.SaengchaepService;

@Controller
public class SaengchaepController {

	@Autowired
	private SaengchaepService saengchaepService;

	

	// MDS p - 생체신호 및 상태 리스트
	@RequestMapping("/saengchaepList")
	public String getSaengchaepList(Model model) {

		model.addAttribute("saengchaepList", saengchaepService.getSaengchaepList());

		return "/saengchae/saengchae/saengchaepList";
	}

	// MDS p - 생체신호 및 상태 검색
	@PostMapping("/saengchaepList")
	public String getSaengchaepList(
									@RequestParam(value = "start_date") String start_date
									,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Saengchae> list = saengchaepService.getSaengchaepSearchList(start_date, finish_date);
		model.addAttribute("saengchaepList", list);

		return "/saengchae/saengchae/saengchaepList";
	}

	
}
