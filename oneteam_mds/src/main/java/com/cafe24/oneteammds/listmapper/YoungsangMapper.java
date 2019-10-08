package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.listvo.Youngsangh;

@Mapper
public interface YoungsangMapper {
	
	// 병원
	
	// 병원DB - 영상검사결과
	public List<Youngsangh> getYoungsanghList();
	
	// 병원DB - 영상검사결과 --> 영상검사결과 regist form
	public Youngsangh getYoungsanghById(String patientId);
	  
	public int getYoungsangRegist(Youngsang youngsang);
	  
	// 시스템DB
	
	// 영상검사결과 regist complete --> MDS DB - 영상검사결과
	public List<Youngsang> getYoungsangdbList();
	
}
