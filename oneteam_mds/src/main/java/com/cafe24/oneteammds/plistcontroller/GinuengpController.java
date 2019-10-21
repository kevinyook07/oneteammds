package com.cafe24.oneteammds.plistcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.GinuengService;
import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.plistservice.GinuengpService;

@Controller
public class GinuengpController {

	@Autowired
	private GinuengpService ginuengpService;
	
	
		@RequestMapping("/ginuengpList")
		public String getGinuengpList(Model model) {
			
			model.addAttribute("ginuengpList", ginuengpService.getGinuengpList());
			
			return "/ginueng/ginueng/ginuengpList";
		}
	
	// MDS p - 기능검사결과 검색
	@PostMapping("/ginuengpList")
	public String getGinuengpList(
								  @RequestParam(value = "start_date") String start_date
								  ,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Ginueng> list = ginuengpService.getGinuengpSearchList(start_date, finish_date);
		model.addAttribute("ginuengpList", list);

		return "/ginueng/ginueng/ginuengpList";
	}
	
	
	
}
