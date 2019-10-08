package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.YebangService;
import com.cafe24.oneteammds.listvo.Yebang;

@Controller
public class YebangController {

	@Autowired
	private YebangService yebangService;
	
	// 병원
	
	// 병원DB - 예방접종내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 예방접종내역 리스트  출력 처리
	@RequestMapping("/yebanghList")
	public String getYebangList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("yebanghList", yebangService.getYebanghList(hospitalId));
		
		return "/yebang/yebangh/yebanghList";
	}
	
	// 병원DB - 예방접종내역 --> 예방접종내역 regist form
	@RequestMapping("/yebangRegist") 
	public String getYebanghById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("yebangh", yebangService.getYebanghById(patientId));
	  
	  return "yebang/yebangRegist/yebangRegist"; 
	}
	  
	// 시스템DB
	
	// 예방접종내역 regist complete --> MDS DB - 예방접종내역
	@RequestMapping("/yebangdbList") 
	public String getYebangRegist(Yebang yebang, Model model) { 
		  
		yebangService.getYebangRegist(yebang);
		  
		model.addAttribute("yebangdbList", yebangService.getYebangdbList()); 
		
		return "/yebang/yebang/yebangdbList"; 
	}
	
}
