package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Susulh;

@Mapper
public interface SusulMapper {
	
	// 병원
	
	// 병원DB - 수술내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 수술내역 리스트  출력 처리
	public List<Susulh> getSusulhList(String hospitalId);
	
	// 병원DB - 수술내역 --> 수술내역 regist form
	public Susulh getSusulhById(String patientId);
	  
	public int getSusulRegist(Susul susul);
	  
	// 시스템DB 
	
	// 수술내역 regist complete --> MDS DB - 수술내역
	public List<Susul> getSusuldbList();
	
}
