package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.listvo.Youngsangh;

@Mapper
public interface YoungsangpMapper {

	

	// 영상검사결과 regist complete --> MDS p - 영상검사결과
	public List<Youngsang> getYoungsangpList();

	// MDS p - 영상검사결과 검색
	public List<Youngsang> getYoungsangpSearchList( String start_date, String finish_date);

	

}
