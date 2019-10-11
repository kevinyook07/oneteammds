package com.cafe24.oneteammds.yochengcontroller;

import java.util.List;
import java.util.Map;

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
	public String getYochengAdminList(Model model
										,@RequestParam(value="currentPage", required = false, defaultValue="1") int currentPage
										,Yochenglist yochenglist) {
		
		//map에 담음.
		Map<String, Object> map = yochengService.getYochengAdminList(currentPage);
		
		
		//페이지 작업
		model.addAttribute("getYochengAdminList", map.get("list"));
		model.addAttribute("currentPage", map.get("currentPage"));
		model.addAttribute("lastPage", map.get("lastPage"));
		model.addAttribute("startPageNum", map.get("startPageNum"));
		model.addAttribute("lastPageNum", map.get("lastPageNum"));
		
		
		return "/yochengAdmin/yochengAdminList/yochengAdminList"; //return 경로 지정
	}
	
	//MDS 진료 정보 요청 내역에서 검색 화면
	@RequestMapping("/yochengAdminList")
	public String getYochengAdminList_Search(@RequestParam(value="sk1") String sk1, //어노테이션 requestParam으로 sk1, sv1 값을 받음.
											 @RequestParam(value="sv1") String sv1, 
											 Model model) {
		
		List<Yochenglist> list = yochengService.getYochengAdminListSearch(sk1, sv1);
		model.addAttribute("yochengAdminList", list);
		
		return "/yochengAdmin/yochengAdminList/yochengAdminList"; //return 경로 지정
	}
	
	//MDS 진료 정보 등록
	@RequestMapping("/yochengAdminInsert")
	public String getYochengAdminInsert(@RequestParam(value="patientId",required=false)String patientId, Model model) { //requestParam으로 patientId 값을 받음.
		
		model.addAttribute("yochenglist", yochengService.getYochenglist_ById(patientId));
		
		return "/yochengAdmin/yochengAdminInsert/yochengAdminInsert";
	}
	
	//요청 완료 화면 출력
	@RequestMapping("/yochengwanlyo")
	public String getYochengwanlyo() {
		
		return "/yochengAdmin/yochengwanlyo/yochengwanlyo.html";
	}
	
	@RequestMapping("/")
	public String yochengAdminList() {
		
		
		return "/yochengAdmin/yochengAdminList/yochengAdminList";
	}
}