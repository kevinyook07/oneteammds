package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.YoungsangService;
import com.cafe24.oneteammds.listvo.Youngsang;

@Controller
public class YoungsangController {

	@Autowired
	private YoungsangService youngsangService;
	
	// 병원
	
	// 병원DB - 영상검사결과
	@RequestMapping("/youngsanghList")
	public String getYoungsangList(Model model) {
		
		model.addAttribute("youngsanghList", youngsangService.getYoungsanghList());
		
		return "/youngsang/youngsangh/youngsanghList";
	}
	
	// 병원DB - 영상검사결과 --> 영상검사결과 regist form
	@RequestMapping("/youngsangRegist") 
	public String getYoungsanghById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("youngsangh", youngsangService.getYoungsanghById(patientId));
	  
	  return "youngsang/youngsangRegist/youngsangRegist"; 
	}
	  
	// 시스템DB
	
	// 영상검사결과 regist complete --> MDS DB - 영상검사결과
	@RequestMapping("/youngsangdbList") 
	public String getYoungsangRegist(Youngsang youngsang, Model model) { 
		  
		youngsangService.getYoungsangRegist(youngsang);
		  
		model.addAttribute("youngsangdbList", youngsangService.getYoungsangdbList()); 
		
		return "/youngsang/youngsang/youngsangdbList"; 
	}
	 
}
