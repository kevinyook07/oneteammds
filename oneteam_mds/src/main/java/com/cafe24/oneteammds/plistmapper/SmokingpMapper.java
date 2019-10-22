package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Smoking;
import com.cafe24.oneteammds.listvo.Smokingh;

@Mapper
public interface SmokingpMapper {

	// 환자 - 흡연상태 리스트
	public List<Smoking> getSmokingpList();

	// 환자 - 흡연상태 검색
	public List<Smoking> getSmokingpSearchList(String start_date, String finish_date);

}
