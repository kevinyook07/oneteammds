package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;

@Mapper
public interface GinuengMapper {
	
	// 병원
	
	// 병원DB - 기능검사결과
	public List<Ginuengh> getGinuenghList();
	
	// 병원DB - 기능검사결과 --> 기능검사결과 regist form
	public Ginuengh getGinuenghById(String patientId);
	  
	public int getGinuengRegist(Ginueng ginueng);
	  
	// 시스템DB 
	
	// 기능검사결과 regist complete --> MDS DB - 기능검사결과
	public List<Ginueng> getGinuengdbList();
	
}
