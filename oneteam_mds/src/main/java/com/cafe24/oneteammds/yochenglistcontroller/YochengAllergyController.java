package com.cafe24.oneteammds.yochenglistcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.oneteammds.yochenglistservice.YochengAllergyService;
import com.cafe24.oneteammds.yochenglistvo.YochengAllergy;

@Controller // 컨트롤러
public class YochengAllergyController {
	
	
	@Autowired // 서비스 연결
	private YochengAllergyService yochengAllergyService;
	
	@RequestMapping("/yochengAdminInsert") // 요청 내역에서 전송 클리 후 나오는 insert화면
	public String getYochengAdminInsert(YochengAllergy yochengAllergy, Model model) {
		
		model.addAttribute("yochengAdminInsert", yochengAllergyService.getYochengAdminInsert(yochengAllergy));
		
		return "/yochengAdmin/yochengAdminInsert/yochengAdminInsert";
	}
	
}
