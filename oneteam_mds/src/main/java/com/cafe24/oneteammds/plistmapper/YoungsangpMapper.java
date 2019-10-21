package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.listvo.Youngsangh;

@Mapper
public interface YoungsangpMapper {

	// 환자 - 영상검사결과 리스트
	public List<Youngsang> getYoungsangpList();

	// 환자 - 영상검사결과 검색
	public List<Youngsang> getYoungsangpSearchList(String start_date, String finish_date);

}
