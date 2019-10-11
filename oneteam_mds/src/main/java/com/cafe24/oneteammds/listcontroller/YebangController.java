package com.cafe24.oneteammds.listcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.YebangService;
import com.cafe24.oneteammds.listvo.Yebang;
import com.cafe24.oneteammds.listvo.Yebangh;

@Controller
public class YebangController {

	@Autowired
	private YebangService yebangService;
	
	// 병원
	
	// 병원DB - 예방접종내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 예방접종내역 리스트  출력 처리
	@RequestMapping("/yebanghList")
	public String getYebangList(@RequestParam(value="hospitalId")String hospitalId
							  , Model model) {
		
		model.addAttribute("yebanghList", yebangService.getYebanghList(hospitalId));
		
		return "/yebang/yebangh/yebanghList";
	}
	
	// 병원DB - 예방접종내역 --> 예방접종내역 regist form
	@RequestMapping("/yebangRegist") 
	public String getYebanghById(@RequestParam(value="patientId")String patientId 
			                   , Model model) {
	  
	  model.addAttribute("yebangh", yebangService.getYebanghById(patientId));
	  
	  return "yebang/yebangRegist/yebangRegist"; 
	}
	
	// 병원DB - 예방접종내역 검색
		@PostMapping("/yebanghList")
		public String getYebangList(@RequestParam(value="hospitalId")String hospitalId
								   ,@RequestParam(value = "sk") String sk
								   ,@RequestParam(value = "sv") String sv,
				Model model) {
			List<Yebangh> list = yebangService.getYebangSearchList(hospitalId, sk, sv);
			model.addAttribute("yebanghList", list);

			return "/yebang/yebangh/yebanghList"; 
		}
	  
	// 시스템DB
	
	// 예방접종내역 regist complete --> MDS DB - 예방접종내역
	@RequestMapping("/yebangdbList") 
	public String getYebangRegist(Yebang yebang, Model model) { 
		  
		yebangService.getYebangRegist(yebang);
		  
		model.addAttribute("yebangdbList", yebangService.getYebangdbList()); 
		
		return "/yebang/yebang/yebangdbList"; 
	}
	
	// 예방접종내역 삭제 1
		@GetMapping("/delYebang")
		public String delYebang(@RequestParam(value = "pibCode") String pibCode, Model model) {
			model.addAttribute("pibCode", pibCode);

			return "yebang/ydelete/delYebang";
		}

		@PostMapping("/delYebang")
		public String delYebang(@RequestParam(value = "pibCode") String pibCode,
				@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
				Model model) {
			int result = yebangService.delYebang(pibCode, hospitalId, patientId);
			if (result == 0) {
				model.addAttribute("result", "비밀번호가 일치하지 않습니다..");
				model.addAttribute("pibCode", pibCode);
				return "/yebang/ydelete/delYebang";
			}
			return "redirect:/yebangdbList";

		}
	
}
