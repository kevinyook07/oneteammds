package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.plistservice.ByungripService;



@Controller
public class ByungripController {

	@Autowired
	private ByungripService byungripService;


		
	@RequestMapping("/byungripList")
	public String getByungripList(Model model) {
		
		model.addAttribute("byungripList", byungripService.getByungripList());
		
		return "/byungri/byungri/byungripList";
	}
	
	// MDS p - 병리검사결과 검색
	@PostMapping("/byungripList")
	public String getByungripList(
								  @RequestParam(value = "start_date") String start_date
								  ,@RequestParam(value = "finish_date") String finish_date,							
			Model model) { 
		List<Byungri> list = byungripService.getByungripSearchList(start_date, finish_date);
		model.addAttribute("byungripList", list);

		return "/byungri/byungri/byungripList";
	}
}

	