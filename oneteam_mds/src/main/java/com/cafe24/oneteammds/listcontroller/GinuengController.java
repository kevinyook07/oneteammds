package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.GinuengService;
import com.cafe24.oneteammds.listvo.Ginueng;

@Controller
public class GinuengController {

	@Autowired
	private GinuengService ginuengService;
	
	// 병원
	
	// 병원DB - 기능검사결과
	@RequestMapping("/ginuenghList")
	public String getGinuengList(Model model) {
		
		model.addAttribute("ginuenghList", ginuengService.getGinuenghList());
		
		return "/ginueng/ginuengh/ginuenghList";
	}
	
	// 병원DB - 기능검사결과 --> 기능검사결과 regist form
	@RequestMapping("/ginuengRegist") 
	public String getGinuenghById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("ginuengh", ginuengService.getGinuenghById(patientId));
	  
	  return "ginueng/ginuengRegist/ginuengRegist"; 
	}
	  
	// 시스템DB
	
	// 기능검사결과 regist complete --> MDS DB - 기능검사결과
	@RequestMapping("/ginuengdbList") 
	public String getGinuengRegist(Ginueng ginueng, Model model) { 
		  
		ginuengService.getGinuengRegist(ginueng);
		  
		model.addAttribute("ginuengdbList", ginuengService.getGinuengdbList()); 
		
		return "/ginueng/ginueng/ginuengdbList"; 
	}
	
}
