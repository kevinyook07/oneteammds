package com.cafe24.oneteammds.susincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//어노테이션 controller 설정
public class SusinHospitalController {
	
	@GetMapping("/susinHospitalInsert")//어노테이션 getmapping 설정
	//접근 지정자 public(제한없음)으로 설정 후 리턴 데이터 타입은 String 메서드명 susinHospital
	public String susinHospital() {      
		
		return "/susinHospital/susinHospitalInsert/susinHospitalInsert"; //리턴 susinHospitalInsert.html  경로로 설정
	}

}
