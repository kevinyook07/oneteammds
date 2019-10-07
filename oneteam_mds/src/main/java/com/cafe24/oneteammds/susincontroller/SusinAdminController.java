package com.cafe24.oneteammds.susincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //어노테이션 controller
public class SusinAdminController {

	
	@GetMapping("/susinAdminInsert") //어노테이션 getmapping // susinAdminInsert 경로 설정
	public String susinAdminInsert() {
		
		return "/susinAdmin/susinAdminInsert/susinAdminInsert";
	}
	
}
