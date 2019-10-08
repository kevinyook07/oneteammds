package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Jindanh;

@Mapper
public interface JindanMapper {
	
	// 병원
	
	// 병원DB - 진단내역
	public List<Jindanh> getJindanhList();
	
	// 병원DB - 진단내역 --> 진단내역 regist form
	public Jindanh getJindanhById(String patientId);
	  
	public int getJindanRegist(Jindan jindan);
	  
	// 시스템DB 
	
	// 진단내역 regist complete --> MDS DB - 진단내역
	public List<Jindan> getJindandbList();	 
	
}
