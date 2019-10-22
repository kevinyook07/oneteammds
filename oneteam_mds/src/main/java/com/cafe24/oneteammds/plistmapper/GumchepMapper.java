package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Gumcheh;

@Mapper
public interface GumchepMapper {

	// 환자 - 검체검사결과
	public List<Gumche> getGumchepList();

	// 환자 - 검체검사결과 검색
	public List<Gumche> getGumchepSearchList(String start_date, String finish_date);

}
