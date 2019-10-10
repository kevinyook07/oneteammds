package com.cafe24.oneteammds.controller;

//계정 오류로 인한 push
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.service.AdminService;
import com.cafe24.oneteammds.vo.Admin;

@Controller // Controller 설정.
public class AdminController {

	@Autowired
	AdminService adminService; // Autowired 를 AdminService 설정.

	// 관리자 권한 로그인 폼
	@GetMapping("/adminLogin") // GetMapping 후 경로를 "adminLogin" 설정
	public String adminLogin() { // 메서드명은 adminLogin
		return "/login/adminLogin/adminLogin";
	}

	// 로그인 권한 선택 화면
	@GetMapping("/mainLogin")
	public String mainLogin() {
		return "/login/mainLogin";
	}

	// 비회원 회원등록 선택화면
	@GetMapping("/addMain")
	public String addMain() {
		return "/login/addMain";
	}

	// 관리자 권한 로그인 중 모든 권한 회원등록 선택 화면
	@GetMapping("/addAdminMain")
	public String addAdminMain() {
		return "/login/addAdminMain";
	}

	// 관리자 권한 로그인 폼
	@PostMapping("/adminLogin")
	public String adminLogin(Admin admin, HttpSession session, Model model) {
		// 입력된 아이디 비밀번호
		System.out.println(admin.toString() + "<--입력된 정보");

		Map<String, Object> map = adminService.getAdminLogin(admin);
		String result = (String) map.get("result");
		Admin loginAdmin = (Admin) map.get("loginAdmin");

		// 로그인 실패 화면 login
		if (!result.equals("로그인 성공")) {
			model.addAttribute("result", result);
			return "/login/adminLogin/adminLogin";
		}
		session.setAttribute("SID", loginAdmin.getA_id());
		session.setAttribute("SLEVEL", loginAdmin.getA_level());
		session.setAttribute("SNAME", loginAdmin.getA_name());

		// 로그인 성공 화면 index
		return "redirect:/";
	}

	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	// 관리자 리스트
	@GetMapping("/adminList")
	public String getAdminList(Model model) {
		List<Admin> list = adminService.getAdminList();

		model.addAttribute("adminList", list);

		return "/admin/adminList/adminList";
	}

	// 관리자 리스트 검색
	@PostMapping("/adminList")
	public String getAdminList(@RequestParam(value = "sk") String sk, @RequestParam(value = "sv") String sv,
			Model model) {
		List<Admin> list = adminService.getAdminSearchList(sk, sv);
		model.addAttribute("adminList", list);

		return "/admin/adminList/adminList";
	}

	// 관리자 권한 회원등록 폼
	@GetMapping("/addAdmin")
	public String addAdmin() {
		return "/admin/addAdmin/addAdmin";
	}

	// 관리자 권한 회원등록 및 유효성검사
	@PostMapping("/addAdmin")
	public String addAdmin(Admin admin, Model model) {
		System.out.println(admin);
		Admin adminCheck = adminService.getAdminById(admin.getA_id());

		if (adminCheck != null) {
			model.addAttribute("result", "동일한 아이디가 존재합니다.");
			return "/admin/addAdmin/addAdmin";
		}

		adminService.addAdmin(admin);

		return "redirect:/adminList";
	}

	// 관리자 권한 회원정보 수정 폼
	@GetMapping("/modifyAdmin")
	public String modifyAdmin(@RequestParam(value = "adminId") String adminId, Model model) {
		System.out.println(adminId + "<--adminId");

		model.addAttribute("admin", adminService.getAdminById(adminId));

		return "/admin/modifyAdmin/modifyAdmin";
	}

	// 관리자 권한 회원정보 수정
	@PostMapping("/modifyAdmin")
	public String modifyAdmin(Admin admin) {
		adminService.modifyAdmin(admin);
		return "redirect:/adminList";
	}

	// 관리자 권한 회원 삭제 폼
	@GetMapping("/delAdmin")
	public String delAdmin(@RequestParam(value = "adminId") String adminId, Model model) {
		model.addAttribute("adminId", adminId);

		return "admin/delAdmin/delAdmin";
	}

	// 관리자 권한 회원 삭제 및 유효성 검사
	@PostMapping("/delAdmin")
	public String delAdmin(Admin admin, Model model) {

		int result = adminService.deleteAdmin(admin.getA_id(), admin.getA_pw());

		if (result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("adminId", admin.getA_id());
			return "admin/delAdmin/delAdmin";
		}

		return "redirect:/adminList";
	}
}