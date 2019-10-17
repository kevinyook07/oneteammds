package com.cafe24.oneteammds.listcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.JindanService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Jindanh;

@Controller
public class JindanController {

	@Autowired
	private JindanService jindanService;
	
	// 병원
	
	// 병원DB - 진단내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 진단내역 리스트  출력 처리
	@RequestMapping("/jindanhList")
	public String getJindanList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("jindanhList", jindanService.getJindanhList(hospitalId));
		
		return "/jindan/jindanh/jindanhList";
	}
	
	// 병원DB - 진단내역 --> 진단내역 regist form
	@RequestMapping("/jindanRegist") 
	public String getJindanhById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("jindanh", jindanService.getJindanhById(patientId));
	  
	  return "jindan/jindanRegist/jindanRegist"; 
	}
	
	// 병원DB - 진단내역 검색
	@PostMapping("/jindanhList")
	public String getJindanhSearchList(@RequestParam(value="hospitalId")String hospitalId
									  ,@RequestParam(value = "sk1") String sk1
									  ,@RequestParam(value = "sk2") String sk2
								   	  ,@RequestParam(value = "sv1") String sv1
								   	  ,@RequestParam(value = "sv2") String sv2
								      ,@RequestParam(value = "start_date") String start_date
								      ,@RequestParam(value = "finish_date") String finish_date,
				Model model) {
			List<Jindanh> list = jindanService.getJindanhSearchList(hospitalId, sk1, sk2, sv1, sv2, start_date, finish_date);
			model.addAttribute("jindanhList", list);

			return "/jindan/jindanh/jindanhList";
		}
	  
	// 시스템DB
	
	// 진단내역 regist complete --> MDS DB - 진단내역
	@RequestMapping("/jindanComplete") 
	public String getJindanRegist(Jindan jindan) { 
		
		jindanService.getJindanRegist(jindan); 		
		
		return "/jindan/jindanRegist/jindanComplete"; 
	}
	
	// MDS DB - 진단내역 리스트
	@RequestMapping("/jindandbList")
	public String getJindandbList(Model model) {
		
		model.addAttribute("jindandbList", jindanService.getJindandbList());
		
		return "/jindan/jindan/jindandbList";
	}
	
	// MDS DB - 진단내역 검색
	@PostMapping("/jindandbList")
	public String getJindandbSearchList(@RequestParam(value = "sk1") String sk1
									   ,@RequestParam(value = "sk2") String sk2
								   	   ,@RequestParam(value = "sv1") String sv1
								   	   ,@RequestParam(value = "sv2") String sv2
								   	   ,@RequestParam(value = "start_date") String start_date
								   	   ,@RequestParam(value = "finish_date") String finish_date,
				Model model) {
			List<Jindan> list = jindanService.getJindandbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);
			model.addAttribute("jindandbList", list);

			return "/jindan/jindan/jindandbList";
		}
	
	
	// MDS DB - 진단내역 삭제
		@GetMapping("/delJindan")
		public String Jindan(@RequestParam(value="dbCode")
								String dbCode, Model model) {
			model.addAttribute("dbCode", dbCode);
			
			return "/jindan/jdelete/delJindan";
		}
		
		@PostMapping("/delJindan")
		public String delJindan(@RequestParam(value = "dbCode") String dbCode,
				@RequestParam(value = "hospitalId") String hospitalId, 
				@RequestParam(value = "patientId") String patientId,
				Model model) {
			int result = jindanService.delJindan(dbCode, hospitalId, patientId);
			if (result == 0) {
				model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
				model.addAttribute("dbCode", dbCode);
				return "/jindan/jdelete/delJindan";
			}
			return "redirect:/jindandbList";
		}
					
}
