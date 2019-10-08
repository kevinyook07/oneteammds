package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.GumcheService;
import com.cafe24.oneteammds.listvo.Gumche;

@Controller
public class GumcheController {

	@Autowired
	private GumcheService gumcheService;
	
	// 병원
	
	// 병원DB - 검체검사결과
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 검체검사결과 리스트  출력 처리
	@RequestMapping("/gumchehList")
	public String getGumcheList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("gumchehList", gumcheService.getGumchehList(hospitalId));
		
		return "/gumche/gumcheh/gumchehList";
	}
	
	// 병원DB - 검체검사결과 --> 검체검사결과 regist form
	@RequestMapping("/gumcheRegist") 
	public String getGumchehById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("gumcheh", gumcheService.getGumchehById(patientId));
	  
	  return "gumche/gumcheRegist/gumcheRegist"; 
	}
	  
	// 시스템DB
	
	// 검체검사결과 regist complete --> MDS DB - 검체검사결과
	@RequestMapping("/gumchedbList") 
	public String getGumcheRegist(Gumche gumche, Model model) { 
		  
		gumcheService.getGumcheRegist(gumche);
		  
		model.addAttribute("gumchedbList", gumcheService.getGumchedbList()); 
		
		return "/gumche/gumche/gumchedbList"; 
	}
	 	 
}
