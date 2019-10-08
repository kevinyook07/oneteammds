package com.cafe24.oneteammds.susincontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.cafe24.oneteammds.susinservice.SusinHospitalService;
import com.cafe24.oneteammds.susinvo.SusinHospital;





@Controller//어노테이션 controller 설정
public class SusinHospitalController {
	
	// @Autowired을 통해 SusinHospitalService 에 담긴 메서드를 불러오는 과정 susinHospitalService 변수설정
	@Autowired SusinHospitalService susinHospitalService;
	
	// 값을 입력하는insert 폼 
	@GetMapping("/susinHospitalInsert")//어노테이션 getmapping 설정
	public String yochengHinsert() {      
		
		return "/susinHospital/susinHospitalInsert/susinHospitalInsert"; 
	}
	// insert 시 db 테이블로 입력되는 과정
	@PostMapping("/susinHospitalInsert")
	public String susinHospitalInsert(SusinHospital SusinHospital) {
		susinHospitalService.yochengHinsert(SusinHospital);
		return "redirect:/susinHospitalList";
	}
	// db안에 있는 값을 특정 컬럼 만 호출해주는 리스트 
	@GetMapping("/susinHospitalList")
	public String susinHospitalList(Model model){
		model.addAttribute("susinHospitalList", susinHospitalService.susinHospitalList());
		return "/susinHospital/susinHospitalList/susinHospitalList";
	}
}
