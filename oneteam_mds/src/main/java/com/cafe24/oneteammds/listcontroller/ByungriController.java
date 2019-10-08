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
	@RequestMapping("/byungrihList")
	public String getByungriList(Model model) {
		
		model.addAttribute("byungrihList", byungriService.getByungrihList());
		
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
