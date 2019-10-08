package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.JindanService;
import com.cafe24.oneteammds.listvo.Jindan;

@Controller
public class JindanController {

	@Autowired
	private JindanService jindanService;
	
	// 병원
	
	// 병원DB - 진단내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 진단내역 리스트  출력 처리
	@RequestMapping("/jindanhList")
	public String getJindanList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("jindanhList", jindanService.getJindanhList(hospitalId));
		
		return "/jindan/jindanh/jindanhList";
	}
	
	// 병원DB - 진단내역 --> 진단내역 regist form
	@RequestMapping("/jindanRegist") 
	public String getJindanhById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("jindanh", jindanService.getJindanhById(patientId));
	  
	  return "jindan/jindanRegist/jindanRegist"; 
	}
	  
	// 시스템DB
	
	// 진단내역 regist complete --> MDS DB - 진단내역
	@RequestMapping("/jindandbList") 
	public String getJindanRegist(Jindan jindan, Model model) { 
		  
		jindanService.getJindanRegist(jindan);
		  
		model.addAttribute("jindandbList", jindanService.getJindandbList()); 
		
		return "/jindan/jindan/jindandbList"; 
	}
	 
}
