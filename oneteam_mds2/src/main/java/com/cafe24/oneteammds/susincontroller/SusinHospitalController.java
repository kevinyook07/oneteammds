package com.cafe24.oneteammds.susincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//어노테이션 controller
public class SusinHospitalController {
	
	@GetMapping("/susinHospitalInsert")//어노테이션 getmapping // susinHospitalInsert 경로 설정
	public String susinHospital() {
		
		return "/susinHospital/susinHospitalInsert/susinHospitalInsert";
	}

}
