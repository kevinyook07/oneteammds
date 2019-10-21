package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;

@Mapper
public interface YakmulpMapper {

	

	// 약물처방내역 regist complete --> MDS p - 약물처방내역
	public List<Yakmul> getYakmulpList();

	// MDS p - 약물처방내역 검색
	public List<Yakmul> getYakmulpSearchList( String start_date, String finish_date);

	
}
