package com.cafe24.oneteammds.susincontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cafe24.oneteammds.susinservice.SusinAdminService;
import com.cafe24.oneteammds.susinvo.SusinAdmin;

@Controller //어노테이션 controller
public class SusinAdminController {

	@Autowired //어너테이션 autowired
	private SusinAdminService susinAdminService;
	
	
	@GetMapping("/susinAdminYochengList") //어노테이션 getmapping // susinAdminInsert 경로 설정
	public String susinAdminYochengList(SusinAdmin susinAdmin, Model model) {
		
		List<SusinAdmin> list = susinAdminService.getsusinAdminYochengList();
		model.addAttribute("susinAdminYochengList", list);
		
		return "/susinAdmin/susinAdminYochengList/susinAdminYochengList";
	}
	
}
