package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.YakmulService;
import com.cafe24.oneteammds.listvo.Yakmul;

@Controller
public class YakmulController {

	@Autowired
	private YakmulService yakmulService;
	
	// 병원
	
	// 병원DB - 약물처방내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 약물처방내역 리스트  출력 처리
	@RequestMapping("/yakmulhList")
	public String getYakmulList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("yakmulhList", yakmulService.getYakmulhList(hospitalId));
		
		return "/yakmul/yakmulh/yakmulhList";
	}
	
	// 병원DB - 약물처방내역 --> 약물처방내역 regist form
	@RequestMapping("/yakmulRegist") 
	public String getYakmulhById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("yakmulh", yakmulService.getYakmulhById(patientId));
	  
	  return "yakmul/yakmulRegist/yakmulRegist"; 
	}
	  
	// 시스템DB
	
	// 약물처방내역 regist complete --> MDS DB - 약물처방내역
	@RequestMapping("/yakmuldbList") 
	public String getYakmulRegist(Yakmul yakmul, Model model) { 
		  
		yakmulService.getYakmulRegist(yakmul);
		  
		model.addAttribute("yakmuldbList", yakmulService.getYakmuldbList()); 
		
		return "/yakmul/yakmul/yakmuldbList"; 
	}
	  
}
