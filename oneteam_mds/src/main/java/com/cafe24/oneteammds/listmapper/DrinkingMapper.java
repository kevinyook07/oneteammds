package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;

@Mapper
public interface DrinkingMapper {
	
	// 병원
	
	// 병원DB - 음주상태
	public List<Drinkingh> getDrinkinghList();
	
	// 병원DB - 음주상태 --> 음주상태 regist form
	public Drinkingh getDrinkinghById(String patientId);
	
	public int getDrinkingRegist(Drinking drinking);
	  
	// 시스템DB 
	
	// 음주상태 regist complete --> MDS DB - 음주상태
	public List<Drinking> getDrinkingdbList();
	
}
