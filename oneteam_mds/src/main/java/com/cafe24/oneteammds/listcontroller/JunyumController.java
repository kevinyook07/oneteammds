package com.cafe24.oneteammds.listcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.JunyumService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Junyumh;

@Controller
public class JunyumController {

	@Autowired
	private JunyumService junyumService;
	
	// 병원

	// 병원DB - 법정 전염성 감염병
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 법정 전염성 감염병 리스트  출력 처리
	@RequestMapping("/junyumhList")
	public String getJunyumList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("junyumhList", junyumService.getJunyumhList(hospitalId));
		
		return "/junyum/junyumh/junyumhList";
	}
	
	// 병원DB - 법정 전염성 감염병 --> 법정 전염성 감염병 regist form
	@RequestMapping("/junyumRegist") 
	public String getJunyumhById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("junyumh", junyumService.getJunyumhById(patientId));
	  
	  return "junyum/junyumRegist/junyumRegist"; 
	}
	
	// 병원DB - 법정 전염성 감염병 검색
		@PostMapping("/junyumhList")
		public String getJunyumList(@RequestParam(value="hospitalId")String hospitalId
								   ,@RequestParam(value = "sk") String sk
								   ,@RequestParam(value = "sv") String sv
								   ,@RequestParam(value = "start_date") String start_date
								   ,@RequestParam(value = "finish_date") String finish_date,
				Model model) {
			List<Junyumh> list = junyumService.getJunyumSearchList(hospitalId, sk, sv, start_date, finish_date);
			model.addAttribute("junyumhList", list);

			return "/junyum/junyumh/junyumhList";
		}
	  
	// 시스템DB
	
	// 법정 전염성 감염병 regist complete --> MDS DB - 법정 전염성 감염병
		@RequestMapping("/junyumComplete") 
		public String getJunyumRegist(Junyum junyum) { 
			
			junyumService.getJunyumRegist(junyum); 		
			
			return "/junyum/junyumRegist/junyumComplete"; 
		}
		
		// MDS DB - 법정 전염성 감염병 리스트
		@RequestMapping("/junyumdbList")
		public String getJunyumdbList(Model model) {
			
			model.addAttribute("junyumdbList", junyumService.getJunyumdbList());
			
			return "/junyum/junyum/junyumdbList";
		}
	
	// MDS DB - 법정 전염성 감염병 검색	
	@PostMapping("/junyumdbList")
	public String getJunyumdbList(@RequestParam(value = "sk1") String sk1
							     ,@RequestParam(value = "sk2") String sk2
						   	     ,@RequestParam(value = "sv1") String sv1
						   	     ,@RequestParam(value = "sv2") String sv2
							     ,@RequestParam(value = "start_date") String start_date
							     ,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Junyum> list = junyumService.getJunyumdbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);
		model.addAttribute("junyumdbList", list);

		return "/junyum/junyum/junyumdbList";
	}
	
	// MDS DB - 법정 전염성 감염병 삭제 
		@GetMapping("/delJunyum")
		public String delJunyum(@RequestParam(value = "lcidCode") String lcidCode, Model model) {
			model.addAttribute("lcidCode", lcidCode);

			return "junyum/jdelete/delJunyum";
		}

		@PostMapping("/delJunyum")
		public String delJunyum(@RequestParam(value = "lcidCode") String lcidCode,
				@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
				Model model) {
			int result = junyumService.delJunyum(lcidCode, hospitalId, patientId);
			if (result == 0) {
				model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
				model.addAttribute("lcidCode", lcidCode);
				return "/junyum/jdelete/delJunyum";
			}
			return "redirect:/junyumdbList";

		}
	 
}
