package com.cafe24.oneteammds.mapper;
//계정 오류로 인한 push
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.vo.Admin;





@Mapper
public interface AdminMapper {

	//관리자 리스트
	public List<Admin> getAdminList();
	
	//관리자 회원등록
	public int addAdmin(Admin admin);
	
	//관리자 로그인 값 가져오기
	public Admin getAdminById(String a_id);
	
	//관리자 회원수정
	public int modifyAdmin (Admin admin);
	
	//관리자 회원삭제
	public int delAdmin(String a_id, String a_pw);
	
	//관리자 로그인
	public Admin getAdminLogin(Admin admin);
	
	//관리자 리스트 검색
	public List<Admin> getAdminSearchList (String sk, String sv);
}
