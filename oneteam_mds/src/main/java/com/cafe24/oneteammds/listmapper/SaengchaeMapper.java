package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Saengchaeh;

@Mapper
public interface SaengchaeMapper {
	
	// 병원
	
	// 병원DB - 생체신호 및 상태
	public List<Saengchaeh> getSaengchaehList();
	
	// 병원DB - 생체신호 및 상태 --> 생체신호 및 상태 regist form
	public Saengchaeh getSaengchaehById(String patientId);
	  
	public int getSaengchaeRegist(Saengchae saengchae);
	  
	// 시스템DB 
	
	// 병원DB - 생체신호 및 상태 --> 생체신호 및 상태 regist form
	public List<Saengchae> getSaengchaedbList();
	
}
