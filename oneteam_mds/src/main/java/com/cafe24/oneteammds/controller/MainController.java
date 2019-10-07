package com.cafe24.oneteammds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller //어노테이션 controller
public class MainController {
	
	@GetMapping("/") //어노테이션 getmapping //index 연결
	public String index() {
		
		return "/index";
	}

}
