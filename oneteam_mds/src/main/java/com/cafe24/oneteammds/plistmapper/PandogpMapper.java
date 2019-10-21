package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;

@Mapper
public interface PandogpMapper {

	// 환자 - 영상판독정보 리스트
	public List<Pandog> getPandogpList();

	// 환자 - 영상판독정보 검색
	public List<Pandog> getPandogpSearchList(String start_date, String finish_date);

}
