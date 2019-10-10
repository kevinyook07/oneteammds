package com.cafe24.oneteammds.service;

//계정 오류로 인한 push
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.mapper.AdminMapper;
import com.cafe24.oneteammds.vo.Admin;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;

	// 관리자 권한 로그인
	public Map<String, Object> getAdminLogin(Admin admin) {

		String result = "";

		Map<String, Object> map = new HashMap<String, Object>();

		Admin adminCheck = adminMapper.getAdminLogin(admin);

		if (adminCheck == null) {
			Admin adminIdCheck = adminMapper.getAdminById(admin.getA_id());
			if (adminIdCheck == null) {
				result = "등록된 아이디의 정보가 없습니다.";
			} else {
				result = "비밀번호가 일치하지 않습니다.";
			}

		} else {
			result = "로그인 성공";
			map.put("loginAdmin", adminCheck);
		}

		map.put("result", result);

		return map;
	}

	// 관리자 권한 리스트
	public List<Admin> getAdminList() {
		List<Admin> list = adminMapper.getAdminList();
		return list;
	}

	// 관리자 권한 리스트 검색
	public List<Admin> getAdminSearchList(String sk, String sv) {
		List<Admin> list = adminMapper.getAdminSearchList(sk, sv);

		return list;
	}

	// 관리자 권한 회원등록
	public int addAdmin(Admin admin) {
		int result = adminMapper.addAdmin(admin);
		return result;
	}

	// 관리자 권한 로그인 값 가져오기
	public Admin getAdminById(String a_id) {

		return adminMapper.getAdminById(a_id);
	}

	// 관리자 회원정보 수정
	public int modifyAdmin(Admin admin) {
		return adminMapper.modifyAdmin(admin);
	}

	// 관리자 권한 회원삭제
	public int deleteAdmin(String a_id, String a_pw) {
		return adminMapper.delAdmin(a_id, a_pw);
	}

}
