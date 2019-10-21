package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Jindan;

@Mapper
public interface JindanpMapper {
	
	public List<Jindan> getJindanpList();
	
	public List<Jindan> getJindanpSearchList (String start_date, String finish_date);
}
