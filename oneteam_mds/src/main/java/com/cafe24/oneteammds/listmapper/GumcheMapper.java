package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Gumcheh;

@Mapper
public interface GumcheMapper {
	
	// 병원
	
	// 병원DB - 검체검사결과
	public List<Gumcheh> getGumchehList();
	
	// 병원DB - 검체검사결과 --> 검체검사결과 regist form
	public Gumcheh getGumchehById(String patientId);
	  
	public int getGumcheRegist(Gumche gumche);
	  
	// 시스템DB 
	
	// 검체검사결과 regist complete --> MDS DB - 검체검사결과
	public List<Gumche> getGumchedbList();
	
}
