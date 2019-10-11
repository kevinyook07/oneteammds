package com.cafe24.oneteammds.listcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.DrinkingService;
import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;

@Controller
public class DrinkingController {

	@Autowired
	private DrinkingService drinkingService;
	
	// 병원
	
	// 병원DB - 음주상태
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 음주상태 리스트  출력 처리
	@RequestMapping("/drinkinghList")
	public String getDrinkingList(@RequestParam(value="hospitalId")String hospitalId
							    , Model model) {
		
		model.addAttribute("drinkinghList", drinkingService.getDrinkinghList(hospitalId));
		
		return "/drinking/drinkingh/drinkinghList";
	}
	
	// 병원DB - 음주상태 --> 음주상태 regist form
	@RequestMapping("/drinkingRegist") 
	public String getDrinkinghById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("drinkingh", drinkingService.getDrinkinghById(patientId));
	  
	  return "drinking/drinkingRegist/drinkingRegist"; 
	}
	
	// 병원DB - 음주상태 검색
		@PostMapping("drinkinghList")
		public String getDrinkingList(@RequestParam(value="hospitalId")String hospitalId
								     ,@RequestParam(value = "sk") String sk
								     ,@RequestParam(value = "sv") String sv,
				Model model) {
			List<Drinkingh> list = drinkingService.getDrinkingSearchList(hospitalId, sk, sv);
			model.addAttribute("drinkinghList", list);

			return "/drinking/drinkingh/drinkinghList";

		}
	  
	// 시스템DB
	
	// 음주상태 regist complete --> MDS DB - 음주상태
	@RequestMapping("/drinkingdbList") 
	public String getDrinkingRegist(Drinking drinking, Model model) { 
		  
		drinkingService.getDrinkingRegist(drinking);
		  
		model.addAttribute("drinkingdbList", drinkingService.getDrinkingdbList()); 
		
		return "/drinking/drinking/drinkingdbList"; 
	}
	
	// 음주상태 삭제
		@GetMapping("/delDrinking")
		public String delDrinking(@RequestParam(value = "dcCode") String dcCode, Model model) {
			model.addAttribute("dcCode", dcCode);

			return "drinking/ddelete/delDrinking";
		}

		@PostMapping("/delDrinking")
		public String delDrinking(@RequestParam(value = "dcCode") String dcCode,
				@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
				Model model) {
			int result = drinkingService.delDrinking(dcCode, hospitalId, patientId);
			if (result == 0) {
				model.addAttribute("result", "비밀번호가 일치하지 않습니다..");
				model.addAttribute("dcCode", dcCode);
				return "/drinking/ddelete/delDrinking";
			}
			return "redirect:/drinkingdbList";
		}
	 
}
