package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Susulh;

@Mapper
public interface SusulpMapper {

	// 환자 - 수술내역
	public List<Susul> getSusulpList();

	// 환자 - 수술내역 검색
	public List<Susul> getSusulpSearchList(String start_date, String finish_date);

}
