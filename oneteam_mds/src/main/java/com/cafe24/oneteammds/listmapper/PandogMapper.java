package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;

@Mapper
public interface PandogMapper {
	
	// 병원
	
	// 병원DB - 영상판독정보
	public List<Pandogh> getPandoghList();
	
	// 병원DB - 영상판독정보 --> 영상판독정보 regist form
	public Pandogh getPandoghById(String patientId);
	  
	public int getPandogRegist(Pandog pandog);
	  
	// 시스템DB 
	
	// 음주상태 regist complete --> MDS DB - 영상판독정보
	public List<Pandog> getPandogdbList();
	
}
