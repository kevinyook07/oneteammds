package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;

@Mapper
public interface GinuengpMapper {

	// 환자 - 기능검사결과
	public List<Ginueng> getGinuengpList();

	// 환자 - 기능검사결과 검색
	public List<Ginueng> getGinuengpSearchList(String start_date, String finish_date);

}
