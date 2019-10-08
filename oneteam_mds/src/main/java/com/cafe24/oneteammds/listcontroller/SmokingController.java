package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.SmokingService;
import com.cafe24.oneteammds.listvo.Smoking;

@Controller
public class SmokingController {

	@Autowired
	private SmokingService smokingService;
	
	// 병원
	
	// 병원DB - 흡연상태
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 흡연상태 리스트  출력 처리
	@RequestMapping("/smokinghList")
	public String getSmokingList(@RequestParam(value="hospitalId")String hospitalId
							   , Model model) {
		
		model.addAttribute("smokinghList", smokingService.getSmokinghList(hospitalId));
		
		return "/smoking/smokingh/smokinghList";
	}
	
	// 병원DB - 흡연상태 --> 흡연상태 regist form
	@RequestMapping("/smokingRegist") 
	public String getSmokinghById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("smokingh", smokingService.getSmokinghById(patientId));
	  
	  return "smoking/smokingRegist/smokingRegist"; 
	}
	  
	// 시스템DB
	
	// 흡연상태 regist complete --> MDS DB - 흡연상태
	@RequestMapping("/smokingdbList") 
	public String getSmokingRegist(Smoking smoking, Model model) { 
		  
		smokingService.getSmokingRegist(smoking);
		  
		model.addAttribute("smokingdbList", smokingService.getSmokingdbList()); 
		
		return "/smoking/smoking/smokingdbList"; 
	}
	 
}
