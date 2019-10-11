package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;

@Mapper
public interface PandogMapper {
	
	// 병원1
	
	// 병원DB - 영상판독정보
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 영상판독정보 리스트  출력 처리
	public List<Pandogh> getPandoghList(String hospitalId);
	
	// 병원DB - 영상판독정보 --> 영상판독정보 regist form
	public Pandogh getPandoghById(String patientId);
	  
	public int getPandogRegist(Pandog pandog);
	
	// 병원DB - 영상판독정보 검색
		public List<Pandogh> getPandogSearchList (String hospitalId, String sk, String sv);
	  
	// 시스템DB 
	
	// 음주상태 regist complete --> MDS DB - 영상판독정보
	public List<Pandog> getPandogdbList();
	
	// 영상판독정보 삭제
		public int delPandog(String iidCode, String hospitalId, String patientId);
	
}
