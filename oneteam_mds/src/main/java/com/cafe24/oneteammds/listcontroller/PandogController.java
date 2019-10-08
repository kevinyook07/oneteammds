package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.PandogService;
import com.cafe24.oneteammds.listvo.Pandog;

@Controller
public class PandogController {

	@Autowired
	private PandogService pandogService;
	
	// 병원
	
	// 병원DB - 영상판독정보
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 영상판독정보 리스트  출력 처리
	@RequestMapping("/pandoghList")
	public String getPandogList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("pandoghList", pandogService.getPandoghList(hospitalId));
		
		return "/pandog/pandogh/pandoghList";
	}
	
	// 병원DB - 영상판독정보 --> 영상판독정보 regist form
	@RequestMapping("/pandogRegist") 
	public String getPandoghById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("pandogh", pandogService.getPandoghById(patientId));
	  
	  return "pandog/pandogRegist/pandogRegist"; 
	}
	  
	// 시스템DB
	
	// 음주상태 regist complete --> MDS DB - 영상판독정보
	@RequestMapping("/pandogdbList") 
	public String getPandogRegist(Pandog pandog, Model model) { 
		  
		pandogService.getPandogRegist(pandog);
		  
		model.addAttribute("pandogdbList", pandogService.getPandogdbList()); 
		
		return "/pandog/pandog/pandogdbList"; 
	}
	
}
