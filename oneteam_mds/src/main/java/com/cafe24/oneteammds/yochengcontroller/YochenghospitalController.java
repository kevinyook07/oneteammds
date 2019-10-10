package com.cafe24.oneteammds.yochengcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.cafe24.oneteammds.yochengservice.YochenghospitalService;
import com.cafe24.oneteammds.yochengvo.Yochenghospital;





@Controller//어노테이션 controller 설정
public class YochenghospitalController {
	
	// @Autowired을 통해 SusinHospitalService 에 담긴 메서드를 불러오는 과정 susinHospitalService 변수설정
	@Autowired YochenghospitalService yochenghospitalService;
	
	// 값을 입력하는insert 폼 
	@GetMapping("/yochengHospitalInsert")//어노테이션 getmapping 설정
	public String yochengHinsert() {      
		
		return "/yochenghospital/yochengHospitalInsert/yochengHospitalInsert"; 
	}
	// insert 시 db 테이블로 입력되는 과정
	@PostMapping("/yochengHospitalInsert")
	public String yochengHinsert(Yochenghospital Yochenghospital) {
		yochenghospitalService.yochengHinsert(Yochenghospital);
		return "redirect:/yochengHospitalList";
	}
	// db안에 있는 값을 아이디를 통해 특정 컬럼 만 호출해주는 메서드 리스트 
	@GetMapping("/yochengHospitalList")
	public String yochengHList(Model model, @RequestParam(value="yochengoutHospitalId", required = false) String yochengoutHospitalId){
		model.addAttribute("yochengHList", yochenghospitalService.yochengHList(yochengoutHospitalId));
		return "/yochenghospital/yochengHospitalList/yochengHospitalList";
	}
	// 조건을 선택 후 검색시 리스트 출력 메서드
	@PostMapping("/yochengHospitalList")
	public String yochenghSearch(@RequestParam(value="search1", required = false) String search1, 
								 @RequestParam(value="search2", required = false) String search2,
								 @RequestParam(value="yochengoutHospitalId", required = false) String yochengoutHospitalId,
								 Model model) {
		model.addAttribute("yochengHList", yochenghospitalService.yochenghSearch(search1, search2, yochengoutHospitalId));
		return "/yochenghospital/yochengHospitalList/yochengHospitalList";
		
	}
}
