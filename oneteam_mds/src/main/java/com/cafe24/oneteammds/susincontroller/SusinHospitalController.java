package com.cafe24.oneteammds.susincontroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller //어노테이션 controller
public class SusinHospitalController {

	@GetMapping("/susinHospitalList")
	public String susinHospitalList() {
		return "/yochenghospital/yochengSusinHospitalList/susinHospitalList";
	}
}
