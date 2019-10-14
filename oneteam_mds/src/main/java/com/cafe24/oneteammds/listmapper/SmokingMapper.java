package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Smoking;
import com.cafe24.oneteammds.listvo.Smokingh;

@Mapper
public interface SmokingMapper {

	// 병원

	// 병원DB - 흡연상태

	// 병원 권한 로그인시 입력되는 ID값 받아서 흡연상태 리스트 출력 처리
	public List<Smokingh> getSmokinghList(String hospitalId);

	// 병원DB - 흡연상태 --> 흡연상태 regist form
	public Smokingh getSmokinghById(String patientId);

	public int getSmokingRegist(Smoking smoking);

	// 병원DB - 흡연상태 검색
	public List<Smokingh> getSmokingSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date);

	// 시스템DB

	// 흡연상태 regist complete --> MDS DB - 흡연상태
	public List<Smoking> getSmokingdbList();

	// MDS DB - 흡연상태 검색
	public List<Smoking> getSmokingdbSearchList(String sk, String sv, String start_date, String finish_date);

	// MDS DB - 흡연상태 삭제
	public int delSmoking(String scCode, String hospitalId, String patientId);

}
