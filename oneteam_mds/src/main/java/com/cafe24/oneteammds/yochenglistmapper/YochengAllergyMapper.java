package com.cafe24.oneteammds.yochenglistmapper;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.yochenglistvo.YochengAllergy;



@Mapper // 매퍼
public interface YochengAllergyMapper {
	
	//요청알러지 값 출력
	public int getYochengAdminInsert(YochengAllergy yochengAllergy);
	
}
