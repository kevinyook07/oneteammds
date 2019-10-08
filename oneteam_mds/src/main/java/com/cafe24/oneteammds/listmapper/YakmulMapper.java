package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;

@Mapper
public interface YakmulMapper {
	
	// 병원
	
	// 병원DB - 약물처방내역
	public List<Yakmulh> getYakmulhList();
	
	// 병원DB - 약물처방내역 --> 약물처방내역 regist form
	public Yakmulh getYakmulhById(String patientId);
	  
	public int getYakmulRegist(Yakmul yakmul);
	  
	// 시스템DB 
	
	// 약물처방내역 regist complete --> MDS DB - 약물처방내역
	public List<Yakmul> getYakmuldbList();
	
}
