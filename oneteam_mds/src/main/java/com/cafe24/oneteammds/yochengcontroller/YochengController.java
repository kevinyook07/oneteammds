package com.cafe24.oneteammds.yochengcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.yochengservice.YochengService;
import com.cafe24.oneteammds.yochengvo.Yochenglist;

@Controller //어노테이션 controller 설정
public class YochengController {
	
	@Autowired //어노테이션 autowired 설정
	private YochengService yochengService;
	
	//병원에서 요청이 들어 왔을 경우 조회 화면
	@GetMapping("/yochengAdminList")
	public String getYochengAdminList(Yochenglist yochenglist, Model model) {
		
		List<Yochenglist> list = yochengService.getYochengAdminList();
		model.addAttribute("yochengAdminList", list);
		
		
		return "/yochengAdmin/yochengAdminList/yochengAdminList";
	}
	
	//MDS 진료 정보 요청 내역에서 검색 화면
	@RequestMapping("/yochengAdminList")
	public String getYochengAdminList_Search(@RequestParam(value="sk1") String sk1, //어노테이션 requestParam으로 sk1, sv1 값을 받음.
											 @RequestParam(value="sv1") String sv1, 
											 Model model) {
		
		List<Yochenglist> list = yochengService.getYochengAdminListSearch(sk1, sv1);
		model.addAttribute("yochengAdminList", list);
		
		return "/yochengAdmin/yochengAdminList/yochengAdminList";
	}
	
	
	
	
	
	
	
	
	
	
	
}
