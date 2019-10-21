package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;

@Mapper
public interface PandogpMapper {

	

	// 음주상태 regist complete --> MDS p - 영상판독정보
	public List<Pandog> getPandogpList();

	// MDS p - 영상판독정보 검색
	public List<Pandog> getPandogpSearchList( String start_date, String finish_date);


}
