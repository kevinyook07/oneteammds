package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;

@Mapper
public interface YakmulMapper {

	// 병원

	// 병원DB - 약물처방내역

	// 병원 권한 로그인시 입력되는 ID값 받아서 약물처방내역 리스트 출력 처리
	public List<Yakmulh> getYakmulhList(String hospitalId);

	// 병원DB - 약물처방내역 --> 약물처방내역 regist form
	public Yakmulh getYakmulhById(String patientId);

	public int getYakmulRegist(Yakmul yakmul);

	// 병원DB - 약물처방내역 --> 검색
	public List<Yakmulh> getYakmulSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date);

	// 시스템DB

	// 약물처방내역 regist complete --> MDS DB - 약물처방내역
	public List<Yakmul> getYakmuldbList();

	// MDS DB - 약물처방내역 검색
	public List<Yakmul> getYakmuldbSearchList(String sk, String sv, String start_date, String finish_date);

	// MDS DB - 약물처방내역 삭제
	public int delYakmul(String mbCode, String hospitalId, String patientId);
}
