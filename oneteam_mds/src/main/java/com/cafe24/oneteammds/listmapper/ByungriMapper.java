package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Byungrih;

@Mapper
public interface ByungriMapper {
	
	// 병원
	
	// 병원DB - 병리검사결과
	public List<Byungrih> getByungrihList();
	
	// 병원DB - 병리검사결과 --> 병리검사결과 regist form
	public Byungrih getByungrihById(String patientId);
	  
	public int getByungriRegist(Byungri byungri);
	  
	// 시스템DB 
	
	// 병리검사결과 regist complete --> MDS DB - 병리검사결과
	public List<Byungri> getByungridbList();
	
}
