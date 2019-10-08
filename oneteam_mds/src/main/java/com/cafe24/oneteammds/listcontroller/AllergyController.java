package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.AllergyService;
import com.cafe24.oneteammds.listvo.Allergy;

@Controller
public class AllergyController {

	@Autowired
	private AllergyService allergyService;
	
	// 병원
	
	// 병원DB - 알러지 및 부작용
	@RequestMapping("/allergyhList")
	public String getAllergyList(Model model) {
		
		model.addAttribute("allergyhList", allergyService.getAllergyhList());
		
		return "/allergy/allergyh/allergyhList";
	}
	
	// 병원DB - 알러지 및 부작용 --> 알러지 및 부작용 regist form
	@RequestMapping("/allergyRegist") 
	public String getAllergyhById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("allergyh", allergyService.getAllergyhById(patientId));
	  
	  return "allergy/allergyRegist/allergyRegist"; 
	}
	  
	// 시스템DB
	
	// 알러지 및 부작용 regist complete --> MDS DB - 알러지 및 부작용
	@RequestMapping("/allergydbList") 
	public String getAllergyRegist(Allergy allergy, Model model) { 
		  
		allergyService.getAllergyRegist(allergy);
		  
		model.addAttribute("allergydbList", allergyService.getAllergydbList()); 
		
		return "/allergy/allergy/allergydbList"; 
	}
	 
}