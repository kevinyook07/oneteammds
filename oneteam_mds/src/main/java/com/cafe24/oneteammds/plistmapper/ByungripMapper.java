package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Byungrih;

@Mapper
public interface ByungripMapper {

	// 환자 - 병리검사결과
	public List<Byungri> getByungripList();

	// 환자 - 병리검사결과 검색
	public List<Byungri> getByungripSearchList(String start_date, String finish_date);

}
