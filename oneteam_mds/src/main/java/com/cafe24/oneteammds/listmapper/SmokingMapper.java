package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Smoking;
import com.cafe24.oneteammds.listvo.Smokingh;

@Mapper
public interface SmokingMapper {
	
	// 병원
	
	// 병원DB - 흡연상태
	public List<Smokingh> getSmokinghList();
	
	// 병원DB - 흡연상태 --> 흡연상태 regist form
	public Smokingh getSmokinghById(String patientId);
	  
	public int getSmokingRegist(Smoking smoking);
	  
	// 시스템DB 
	
	// 흡연상태 regist complete --> MDS DB - 흡연상태
	public List<Smoking> getSmokingdbList();
	
}
