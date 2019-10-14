package com.cafe24.oneteammds.listcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.GinuengService;
import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;
import com.cafe24.oneteammds.listvo.Jindan;

@Controller
public class GinuengController {

	@Autowired
	private GinuengService ginuengService;
	
	// 병원
	
	// 병원DB - 기능검사결과
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 기능검사결과 리스트  출력 처리
	@RequestMapping("/ginuenghList")
	public String getGinuengList(@RequestParam(value="hospitalId")String hospitalId
							   , Model model) {
		
		model.addAttribute("ginuenghList", ginuengService.getGinuenghList(hospitalId));
		
		return "/ginueng/ginuengh/ginuenghList";
	}
	
	// 병원DB - 기능검사결과 --> 기능검사결과 regist form
	@RequestMapping("/ginuengRegist") 
	public String getGinuenghById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("ginuengh", ginuengService.getGinuenghById(patientId));
	  
	  return "ginueng/ginuengRegist/ginuengRegist"; 
	}
	
	// 병원DB - 기능검사결과 검색
		@PostMapping("/ginuenghList")
		public String getGinuengList(@RequestParam(value="hospitalId")String hospitalId
								    ,@RequestParam(value = "sk") String sk
								    ,@RequestParam(value = "sv") String sv,
				Model model) {
			List<Ginuengh> list = ginuengService.getGinuengSearchList(hospitalId, sk, sv);
			model.addAttribute("ginuenghList", list);

			return "/ginueng/ginuengh/ginuenghList";
		}
	  
	// 시스템DB
	
	// 기능검사결과 regist complete --> MDS DB - 기능검사결과
		@RequestMapping("/ginuengComplete") 
		public String getGinuengRegist(Ginueng ginueng) { 
			
			ginuengService.getGinuengRegist(ginueng); 		
			
			return "/ginueng/ginuengRegist/ginuengComplete"; 
		}
		
		@RequestMapping("/ginuengdbList")
		public String getGinuengdbList(Model model) {
			
			model.addAttribute("ginuengdbList", ginuengService.getGinuengdbList());
			
			return "/ginueng/ginueng/ginuengdbList";
		}
	
	// MDS DB - 기능검사결과 검색
	@PostMapping("/ginuengdbList")
	public String getGinuengdbList(
							    @RequestParam(value = "sk") String sk
							    ,@RequestParam(value = "sv") String sv,
			Model model) {
		List<Ginueng> list = ginuengService.getGinuengdbSearchList(sk, sv);
		model.addAttribute("ginuengdbList", list);

		return "/ginueng/ginueng/ginuengdbList";
	}
	
	// MDS DB - 기능검사결과 삭제 
		@GetMapping("/delGinueng")
		public String delGinueng(@RequestParam(value = "ftrCode") String ftrCode, Model model) {
			model.addAttribute("ftrCode", ftrCode);

			return "/ginueng/gdelete/delGinueng";
		}

		@PostMapping("/delGinueng")
		public String delGinueng(@RequestParam(value = "ftrCode") String ftrCode,
				@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
				Model model) {
			int result = ginuengService.delGinueng(ftrCode, hospitalId, patientId);
			if (result == 0) {
				model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
				model.addAttribute("ftrCode", ftrCode);
				return "/ginueng/gdelete/delGinueng";
			}
			return "redirect:/ginuengdbList";
		}
		
	
}
