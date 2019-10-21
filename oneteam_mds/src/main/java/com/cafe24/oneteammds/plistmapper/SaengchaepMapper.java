package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Saengchaeh;

@Mapper
public interface SaengchaepMapper {

	// 환자 - 생체신호 및 상태 리스트
	public List<Saengchae> getSaengchaepList();

	// 환자 - 생체신호 및 상태 검색
	public List<Saengchae> getSaengchaepSearchList(String start_date, String finish_date);

}
