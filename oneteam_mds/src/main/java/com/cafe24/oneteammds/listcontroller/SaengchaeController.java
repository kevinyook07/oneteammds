package com.cafe24.oneteammds.listcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.SaengchaeService;
import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Saengchaeh;

@Controller
public class SaengchaeController {

	@Autowired
	private SaengchaeService saengchaeService;
	
	// 병원
	
	// 병원DB - 생체신호 및 상태
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 생체상태 및 신호 리스트  출력 처리
	@RequestMapping("/saengchaehList")
	public String getSaengchaeList(@RequestParam(value="hospitalId")String hospitalId
							     , Model model) {
		
		model.addAttribute("saengchaehList", saengchaeService.getSaengchaehList(hospitalId));
		
		return "/saengchae/saengchaeh/saengchaehList";
	}
	
	// 병원DB - 생체신호 및 상태 --> 생체신호 및 상태 regist form
	@RequestMapping("/saengchaeRegist") 
	public String getSaengchaehById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("saengchaeh", saengchaeService.getSaengchaehById(patientId));
	  
	  return "saengchae/saengchaeRegist/saengchaeRegist"; 
	}
	
	// 병원DB - 생체신호 및 상태 검색
		@PostMapping("/saengchaehList")
		public String getSaengchaeList(@RequestParam(value="hospitalId")String hospitalId
									  ,@RequestParam(value = "sk") String sk
									  ,@RequestParam(value = "sv") String sv,
					Model model) {
			List<Saengchaeh> list = saengchaeService.getSaengchaeSearchList(hospitalId, sk, sv);
			model.addAttribute("saengchaehList", list);

			return "/saengchae/saengchaeh/saengchaehList";
		}
	  
	// 시스템DB
	
	// 병원DB - 생체신호 및 상태 --> 생체신호 및 상태 regist form
	@RequestMapping("/saengchaedbList") 
	public String getSaengchaeRegist(Saengchae saengchae, Model model) { 
		  
		saengchaeService.getSaengchaeRegist(saengchae);
		  
		model.addAttribute("saengchaedbList", saengchaeService.getSaengchaedbList()); 
		
		return "/saengchae/saengchae/saengchaedbList"; 
	}
	
	// 병원DB - 생체신호 및 상태 삭제
		@GetMapping("/delSaengchae")
		public String delSaengchae(@RequestParam(value = "vscCode") String vscCode, Model model) {
			model.addAttribute("vscCode", vscCode);

			return "saengchae/sdelete/delSaengchae";
		}

		@PostMapping("/delSaengchae")
		public String delSaengchae(@RequestParam(value = "vscCode") String vscCode,
				@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
				Model model) {
			int result = saengchaeService.delSaengchae(vscCode, hospitalId, patientId);
			if (result == 0) {
				model.addAttribute("result", "비밀번호가 일치하지 않습니다..");
				model.addAttribute("vscCode", vscCode);
				return "/saengchae/sdelete/delSaengchae";
			}
			return "redirect:/saengchaedbList";

		}
	 
}
