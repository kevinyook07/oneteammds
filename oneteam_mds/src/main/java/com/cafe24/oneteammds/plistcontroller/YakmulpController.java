package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.YakmulService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;
import com.cafe24.oneteammds.plistservice.YakmulpService;

@Controller
public class YakmulpController {

	@Autowired
	private YakmulpService yakmulpService;

	

	// MDS p - 약물처방내역 리스트
	@RequestMapping("/yakmulpList")
	public String getYakmulpList(Model model) {

		model.addAttribute("yakmulpList", yakmulpService.getYakmulpList());

		return "/yakmul/yakmul/yakmulpList";
	}

	// MDS p - 약물처방내역 검색
	@PostMapping("/yakmulpList")
	public String getYakmulpList(
								 @RequestParam(value = "start_date") String start_date
								 ,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Yakmul> list = yakmulpService.getYakmulpSearchList(start_date, finish_date);
		model.addAttribute("yakmulpList", list);

		return "/yakmul/yakmul/yakmulpList";

	}

	

}
