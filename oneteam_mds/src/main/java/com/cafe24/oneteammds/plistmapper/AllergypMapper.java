package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.listvo.Allergyh;

@Mapper
public interface AllergypMapper {

	// 환자 - 알러지 및 부작용 리스트
	public List<Allergy> getAllergypList();

	// 환자 - 알러지 및 부작용 검색
	public List<Allergy> getAllergypSearchList(String start_date, String finish_date);

}
