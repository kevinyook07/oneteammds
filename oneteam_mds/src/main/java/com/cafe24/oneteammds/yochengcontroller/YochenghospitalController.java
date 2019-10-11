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
		
		// 진료 정보 요청 insert form 출력 확인 test
		/**************************************************************************/
		System.out.println("yochengHinsert" + "<-- 진료 정보 요청 insert form");
		/**************************************************************************/
		
		return "/yochenghospital/yochengHospitalInsert/yochengHospitalInsert"; 
	}
	// insert 시 db 테이블로 입력되는 과정
	@PostMapping("/yochengHospitalInsert")
	public String yochengHinsert(Yochenghospital Yochenghospital) {
		
		yochenghospitalService.yochengHinsert(Yochenghospital);
		
		// 진료 정보 요청 insert 입력한 값 삽입 확인 test
		/**************************************************************************/
		System.out.println(Yochenghospital + "<-- 진료 정보 요청 insert 입력한 값");
		/**************************************************************************/
		
		return "redirect:/yochenghWanlyo";
	}
	@GetMapping("/yochenghWanlyo")
	public String yochenghWanlyo() {
		
		// 진료 정보 요청 insert 후 완료 from 출력 확인 test
		/**************************************************************************/
		System.out.println("yochenghWanlyo" + "<-- 진료 정보 요청 insert 후 완료 from");
		/**************************************************************************/
		
		return "/yochenghospital/yochenghWanlyo/yochenghWanlyo";
	}
	// db안에 있는 값을 아이디를 통해 특정 컬럼 만 호출해주는 메서드 리스트 
	@GetMapping("/yochengHospitalList")
	public String yochengHList(Model model, @RequestParam(value="yochengoutHospitalId", required = false) String yochengoutHospitalId){
		
		model.addAttribute("yochengHList", yochenghospitalService.yochengHList(yochengoutHospitalId));
		
		// 아이디 로그인시 해당 LIST 출력 확인 test
		/**********************************************************/
		System.out.println(yochengoutHospitalId + "<-- 로그인한 정보 값 해당 아이디 list 출력");
		/**********************************************************/
	
		return "/yochenghospital/yochengHospitalList/yochengHospitalList";
	}
	
	// 조건을 선택 후 검색시 리스트 출력 메서드
	@PostMapping("/yochengHospitalList")
	public String yochenghSearch(@RequestParam(value="search1", required = false) String search1, 
								 @RequestParam(value="search2", required = false) String search2,
								 @RequestParam(value="yochengoutHospitalId", required = false) String yochengoutHospitalId,
								 Model model) {
		//검색 항목 선택, text 입력 후 출력 확인 test 
		/**********************************************************/
		System.out.println(search1 + "<-- 항목 선택 값");
		System.out.println(search2 + "<-- 항목 선택 후 text 입력 값");
		System.out.println(yochengoutHospitalId + "<-- 로그인한 정보 값 해당 아이디 list 출력");
		/**********************************************************/
		
		model.addAttribute("yochengHList", yochenghospitalService.yochenghSearch(search1, search2, yochengoutHospitalId));
		
		return "/yochenghospital/yochengHospitalList/yochengHospitalList";
		
	}
}
