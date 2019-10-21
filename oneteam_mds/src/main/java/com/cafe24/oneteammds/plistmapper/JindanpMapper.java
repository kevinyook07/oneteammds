package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Jindan;

@Mapper
public interface JindanpMapper {

	// 환자 - 진단내역 리스트
	public List<Jindan> getJindanpList();

	// 환자 - 진단내역 검색
	public List<Jindan> getJindanpSearchList(String start_date, String finish_date);
}
