package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Junyumh;

@Mapper
public interface JunyumpMapper {

	// 환자 - 법정 전염성 감염병 리스트
	public List<Junyum> getJunyumpList();

	// 환자 - 법정 전염성 감염병 검색
	public List<Junyum> getJunyumpSearchList(String start_date, String finish_date);

}
