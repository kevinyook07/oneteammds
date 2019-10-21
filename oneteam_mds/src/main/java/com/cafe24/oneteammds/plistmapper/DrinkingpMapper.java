package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;

@Mapper
public interface DrinkingpMapper {

	// 환자 - 음주상태
	public List<Drinking> getDrinkingpList();

	// 환자 - 음주상태 검색
	public List<Drinking> getDrinkingpSearchList(String start_date, String finish_date);

}
