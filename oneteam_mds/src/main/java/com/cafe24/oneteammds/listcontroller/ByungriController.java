package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.ByungriService;
import com.cafe24.oneteammds.listvo.Byungri;

@Controller
public class ByungriController {

	@Autowired
	private ByungriService byungriService;
	
	// 병원
	
	// 병원DB - 병리검사결과
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 병리검사결과 리스트  출력 처리
	@RequestMapping("/byungrihList")
	public String getByungriList(@RequestParam(value="hospitalId")String hospitalId
			 				   , Model model) {
		
		model.addAttribute("byungrihList", byungriService.getByungrihList(hospitalId));
		
		return "/byungri/byungrih/byungrihList";
	}
	
	// 병원DB - 병리검사결과 --> 병리검사결과 regist form
	@RequestMapping("/byungriRegist") 
	public String getByungrihById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("byungrih", byungriService.getByungrihById(patientId));
	  
	  return "byungri/byungriRegist/byungriRegist"; 
	}
	  
	// 시스템DB
	
	// 병리검사결과 regist complete --> MDS DB - 병리검사결과
	@RequestMapping("/byungridbList") 
	public String getByungriRegist(Byungri byungri, Model model) { 
		  
		byungriService.getByungriRegist(byungri);
		  
		model.addAttribute("byungridbList", byungriService.getByungridbList()); 
		
		return "/byungri/byungri/byungridbList"; 
	}
	  
}
