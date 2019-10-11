package com.cafe24.oneteammds.listcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.GumcheService;
import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Gumcheh;

@Controller
public class GumcheController {

	@Autowired
	private GumcheService gumcheService;
	
	// 병원
	
	// 병원DB - 검체검사결과
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 검체검사결과 리스트  출력 처리
	@RequestMapping("/gumchehList")
	public String getGumcheList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("gumchehList", gumcheService.getGumchehList(hospitalId));
		
		return "/gumche/gumcheh/gumchehList";
	}
	
	// 병원DB - 검체검사결과 --> 검체검사결과 regist form
	@RequestMapping("/gumcheRegist") 
	public String getGumchehById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("gumcheh", gumcheService.getGumchehById(patientId));
	  
	  return "gumche/gumcheRegist/gumcheRegist"; 
	}
	
	// 병원DB - 검체검사결과 검색
		@PostMapping("/gumchehList")
		public String getGumcheList(@RequestParam(value="hospitalId")String hospitalId
								   ,@RequestParam(value = "sk") String sk
								   ,@RequestParam(value = "sv") String sv,
				Model model) {
			List<Gumcheh> list = gumcheService.getGumcheSearchList(hospitalId, sk, sv);
			model.addAttribute("gumchehList", list);

			return "/gumche/gumcheh/gumchehList";

		}
	  
	// 시스템DB
	
	// 검체검사결과 regist complete --> MDS DB - 검체검사결과
	@RequestMapping("/gumchedbList") 
	public String getGumcheRegist(Gumche gumche, Model model) { 
		  
		gumcheService.getGumcheRegist(gumche);
		  
		model.addAttribute("gumchedbList", gumcheService.getGumchedbList()); 
		
		return "/gumche/gumche/gumchedbList"; 
	}
	
	// MDS DB - 검체검사결과 삭제 1
		@GetMapping("/delGumche")
		public String delGumche(@RequestParam(value = "strCode") String strCode, Model model) {
			model.addAttribute("strCode", strCode);

			return "gumche/gdelete/delGumche";
		}

		@PostMapping("/delGumche")
		public String delJindan(@RequestParam(value = "strCode") String strCode,
				@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
				Model model) {
			int result = gumcheService.delGumche(strCode, hospitalId, patientId);
			if (result == 0) {
				model.addAttribute("result", "비밀번호가 일치하지 않습니다..");
				model.addAttribute("strCode", strCode);
				return "/gumche/gdelete/delGumche";
			}
			return "redirect:/gumchedbList";
		}
		
	 	 
}
