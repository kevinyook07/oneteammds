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
	
	//페이지 작업을 포함한 MDS 진료정보 요청 화면 출력
	@GetMapping("/yochengAdminList")
	public String yochengAdminList(Model model
										,@RequestParam(value="currentPage", required = false, defaultValue="1") int currentPage
										,Yochenglist yochenglist) {
		
				
		//map 객체 생성
		Map<String, Object> map = yochengService.getYochengAdminList(currentPage);
		
		
		/* 요청 리스트가 출력되지 않아 시도했던 yochengAdminList 전체 출력 코드 작업. 
		  * //전체 리스트 출력
		 * model.addAttribute("yochengAdminList", map.get("yochengAdminList"));
		 * System.out.println(map.get("yochengAdminList") + "<-- 요청관리자 리스트");
		 */
		
		//페이지 작업
		model.addAttribute("yochengAdminList", map.get("list")); //yochengAdminList를 map에 담았음.
		/* System.out.println(map.get("list") + "<-- yochengAdminList"); */ //콘솔창에 list값이 들어가는지 확인
		
		model.addAttribute("currentPage", map.get("currentPage")); //currentPage를 map에 담았음.
		/* System.out.println(map.get("currentPage") + "<-- currentPage"); */ //콘솔창에 currentPage값이 들어가는지 확인
		
		model.addAttribute("lastPage", map.get("lastPage")); //lastPage를 map에 담았음.
		/* System.out.println(map.get("lastPage") + "<-- lastPage"); */ //콘솔창에 lastPage값이 들어가는지 확인
		
		model.addAttribute("startPageNum", map.get("startPageNum")); //startPageNum를 map에 담았음.
		/* System.out.println(map.get("startPageNum") + "<-- startPageNum"); */ //콘솔창에 startPageNum값이 들어가는지 확인
		
		model.addAttribute("lastPageNum", map.get("lastPageNum")); //lastPageNum를 map에 담았음.
		/* System.out.println(map.get("lastPageNum") + "<-- lastPageNum"); */ //콘솔창에 lastPageNum값이 들어가는지 확인
		
		
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
	
	/*
	 * //MDS 진료 정보 등록
	 * 
	 * @RequestMapping("/balsinInsert") 
	 * public String
	 * getYochengAdminInsert(@RequestParam(value="patientId",required=false)String
	 * patientId, Model model) { //requestParam으로 patientId 값을 받음.
	 * 
	 * model.addAttribute("yochenglist",
	 * yochengService.getYochenglistById(patientId));
	 * 
	 * return "/balsin/balsinInsert/balsinInsert"; }
	 */
	
	//요청 완료 화면 출력
	@RequestMapping("/yochengwanlyo")
	public String getYochengwanlyo() {
		
		
		return "/yochengAdmin/yochengwanlyo/yochengwanlyo";
	}	
	
	@RequestMapping("/yochengAdminInsert")
	public String getYochengAdminInsert() {
		
		return "/yochengAdmin/yochengAdminInsert/yochengAdminInsert";
	}
	
	@RequestMapping("/balsinInsert")
	public String getBalsinInsert() {
		
		return "/balsin/balsinInsert/balsinInsert";
	}
	
	 
	 
	
	
}

