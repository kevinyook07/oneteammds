package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.PandogService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;
import com.cafe24.oneteammds.plistservice.PandogpService;

@Controller
public class PandogpController {

	@Autowired
	private PandogpService pandogpService;

	

	// MDS p - 영상판독정보 리스트
	@RequestMapping("/pandogpList")
	public String getPandogpList(Model model) {

		model.addAttribute("pandogpList", pandogpService.getPandogpList());

		return "/pandog/pandog/pandogpList";
	}

	// MDS p - 영상판독정보 검색
	@PostMapping("/pandogpList")
	public String getPandogpList(
								 @RequestParam(value = "start_date") String start_date
								 ,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Pandog> list = pandogpService.getPandogpSearchList(start_date, finish_date);
		model.addAttribute("pandogpList", list);

		return "/pandog/pandog/pandogpList";
	}

}
