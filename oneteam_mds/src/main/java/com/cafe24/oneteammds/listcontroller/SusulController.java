package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.SusulService;
import com.cafe24.oneteammds.listvo.Susul;

@Controller
public class SusulController {

	@Autowired
	private SusulService susulService;
	
	// 병원
	
	// 병원DB - 수술내역
	@RequestMapping("/susulhList")
	public String getSusulList(Model model) {
		
		model.addAttribute("susulhList", susulService.getSusulhList());
		
		return "/susul/susulh/susulhList";
	}
	
	// 병원DB - 수술내역 --> 수술내역 regist form
	@RequestMapping("/susulRegist") 
	public String getSusulhById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("susulh", susulService.getSusulhById(patientId));
	  
	  return "susul/susulRegist/susulRegist"; 
	}
	  
	// 시스템DB
	
	// 수술내역 regist complete --> MDS DB - 수술내역
	@RequestMapping("/susuldbList") 
	public String getSusulRegist(Susul susul, Model model) { 
		  
		susulService.getSusulRegist(susul);
		  
		model.addAttribute("susuldbList", susulService.getSusuldbList()); 
		
		return "/susul/susul/susuldbList"; 
	}
	 
}
