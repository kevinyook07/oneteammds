package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Jindanh;

@Mapper
public interface JindanMapper {
	
	// 병원1
	
	// 병원DB - 진단내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 진단내역 리스트  출력 처리
	public List<Jindanh> getJindanhList(String hospitalId);
	
	// 병원DB - 진단내역 --> 진단내역 regist form
	public Jindanh getJindanhById(String patientId);
	  
	public int getJindanRegist(Jindan jindan);
	
	// 병원DB - 검색
	public List<Jindanh> getJindanhSearchList (String hospitalId, String sk, String sv);
	  
	// 시스템DB 
	
	// 진단내역 regist complete --> MDS DB - 진단내역
	public List<Jindan> getJindandbList();	 
	
	// MDS DB - 진단내역 검색
	public List<Jindan> getJindandbSearchList (String sk, String sv);
	
	// 시스템DB - 삭제
	public int delJindan(String dbCode, String hospitalId, String patientId);

}
