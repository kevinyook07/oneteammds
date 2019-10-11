package com.cafe24.oneteammds.listcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.ByungriService;
import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Byungrih;

@Controller
public class ByungriController {

	@Autowired
	private ByungriService byungriService;
	
	// 병원
	
	// 병원DB - 병리검사결과
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 병리검사결과 리스트  출력 처리
	@RequestMapping("/byungrihList")
	public String getByungriList(@RequestParam(value="hospitalId")String hospitalId
			 				   , Model model) {
		
		model.addAttribute("byungrihList", byungriService.getByungrihList(hospitalId));
		
		return "/byungri/byungrih/byungrihList";
	}
	
	// 병원DB - 병리검사결과 --> 병리검사결과 regist form
	@RequestMapping("/byungriRegist") 
	public String getByungrihById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("byungrih", byungriService.getByungrihById(patientId));
	  
	  return "byungri/byungriRegist/byungriRegist"; 
	}
	
	// 병원DB - 병리검사결과 검색
		@PostMapping("/byungrihList")
		public String getByungriList(@RequestParam(value="hospitalId")String hospitalId
								    ,@RequestParam(value = "sk") String sk
								    ,@RequestParam(value = "sv") String sv,
				Model model) {
			List<Byungrih> list = byungriService.getByungriSearchList(hospitalId, sk, sv);
			model.addAttribute("byungrihList", list);

			return "/byungri/byungrih/byungrihList";
		}
	  
	// 시스템DB
	
	// 병리검사결과 regist complete --> MDS DB - 병리검사결과
	@RequestMapping("/byungridbList") 
	public String getByungriRegist(Byungri byungri, Model model) { 
		  
		byungriService.getByungriRegist(byungri);
		  
		model.addAttribute("byungridbList", byungriService.getByungridbList()); 
		
		return "/byungri/byungri/byungridbList"; 
	}
	
	// MDS DB - 병리검사결과 삭제 1
		@GetMapping("/delByungri")
		public String delByungri(@RequestParam(value = "ptrCode") String ptrCode, Model model) {
			model.addAttribute("ptrCode", ptrCode);

			return "/byungri/bdelete/delByungri";
		}

		@PostMapping("/delByungri")
		public String delByungri(@RequestParam(value = "ptrCode") String ptrCode,
				@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
				Model model) {
			int result = byungriService.delByungri(ptrCode, hospitalId, patientId);
			if (result == 0) {
				model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
				model.addAttribute("ptrCode", ptrCode);
				return "/Byungri/bdelete/delByungri";
			}
			return "redirect:/byungridbList";
		}
	  
}
