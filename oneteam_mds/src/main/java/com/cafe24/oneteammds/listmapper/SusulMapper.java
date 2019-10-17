package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Susulh;

@Mapper
public interface SusulMapper {

	// 병원1

	// 병원DB - 수술내역

	// 병원 권한 로그인시 입력되는 ID값 받아서 수술내역 리스트 출력 처리
	public List<Susulh> getSusulhList(String hospitalId);

	// 병원DB - 수술내역 --> 수술내역 regist form
	public Susulh getSusulhById(String patientId);

	public int getSusulRegist(Susul susul);

	// 병원DB - 수술내역 검색
	public List<Susulh> getSusulSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date);

	// 시스템DB

	// 수술내역 regist complete --> MDS DB - 수술내역
	public List<Susul> getSusuldbList();

	// MDS DB - 수술내역 검색
	public List<Susul> getSusuldbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date);

	// MDS DB - 수술내역 삭제
	public int delSusul(String sbCode, String hospitalId, String patientId);

}
