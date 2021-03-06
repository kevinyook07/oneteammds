package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Saengchaeh;

@Mapper
public interface SaengchaeMapper {

	// 병원

	// 병원DB - 생체신호 및 상태

	// 병원 권한 로그인시 입력되는 ID값 받아서 생체상태 및 신호 리스트 출력 처리
	public List<Saengchaeh> getSaengchaehList(String hospitalId);

	// 병원DB - 생체신호 및 상태 --> 생체신호 및 상태 regist form
	public Saengchaeh getSaengchaehById(String patientId);

	public int getSaengchaeRegist(Saengchae saengchae);

	// 병원DB - 생체신호 및 상태 검색
	public List<Saengchaeh> getSaengchaeSearchList(String hospitalId, String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date);

	// 시스템DB

	// 생체신호 및 상태 regist complete --> MDS DB - 생체신호 및 상태
	public List<Saengchae> getSaengchaedbList();

	// MDS DB - 생체신호 및 상태 검색
	public List<Saengchae> getSaengchaedbSearchList(String sk1, String sk2, String sk3, String sv1, String sv2, String sv3, String start_date, String finish_date);

	// MDS DB - 생체신호 및 상태 삭제
	public int delSaengchae(String vscCode, String hospitalId, String patientId);

}
