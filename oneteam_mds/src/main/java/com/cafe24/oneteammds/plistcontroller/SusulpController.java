package com.cafe24.oneteammds.plistcontroller;

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
import com.cafe24.oneteammds.plistservice.SusulpService;

@Controller
public class SusulpController {

	@Autowired
	private SusulpService susulpService;

	// 환자 - 수술내역 리스트
	@RequestMapping("/susulpList")
	public String getSusulpList(Model model) {

		model.addAttribute("susulpList", susulpService.getSusulpList());

		return "/susul/susul/susulpList";
	}

	// 환자 - 수술내역 검색
	@PostMapping("/susulpList")
	public String getSusulpList(@RequestParam(value = "start_date") String start_date,
			@RequestParam(value = "finish_date") String finish_date, Model model) {
		List<Susul> list = susulpService.getSusulpSearchList(start_date, finish_date);
		model.addAttribute("susulpList", list);

		return "/susul/susul/susulpList";
	}

}
