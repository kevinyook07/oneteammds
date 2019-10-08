package com.cafe24.oneteammds.listcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.JunyumService;
import com.cafe24.oneteammds.listvo.Junyum;

@Controller
public class JunyumController {

	@Autowired
	private JunyumService junyumService;
	
	// 병원
	
	// 병원DB - 법정 전염성 감염병
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 법정 전염성 감염병 리스트  출력 처리
	@RequestMapping("/junyumhList")
	public String getJunyumList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("junyumhList", junyumService.getJunyumhList(hospitalId));
		
		return "/junyum/junyumh/junyumhList";
	}
	
	// 병원DB - 법정 전염성 감염병 --> 법정 전염성 감염병 regist form
	@RequestMapping("/junyumRegist") 
	public String getJunyumhById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("junyumh", junyumService.getJunyumhById(patientId));
	  
	  return "junyum/junyumRegist/junyumRegist"; 
	}
	  
	// 시스템DB
	
	// 법정 전염성 감염병 regist complete --> MDS DB - 법정 전염성 감염병
	@RequestMapping("/junyumdbList") 
	public String getJunyumRegist(Junyum junyum, Model model) { 
		  
		junyumService.getJunyumRegist(junyum);
		  
		model.addAttribute("junyumdbList", junyumService.getJunyumdbList()); 
		
		return "/junyum/junyum/junyumdbList"; 
	}
	 
}
