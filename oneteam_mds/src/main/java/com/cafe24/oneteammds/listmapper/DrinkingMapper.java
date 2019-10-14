package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;

@Mapper
public interface DrinkingMapper {

	// 병원

	// 병원DB - 음주상태

	// 병원 권한 로그인시 입력되는 ID값 받아서 음주상태 리스트 출력 처리
	public List<Drinkingh> getDrinkinghList(String hospitalId);

	// 병원DB - 음주상태 --> 음주상태 regist form
	public Drinkingh getDrinkinghById(String patientId);

	public int getDrinkingRegist(Drinking drinking);

	// 병원DB - 음주상태 검색
	public List<Drinkingh> getDrinkingSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date);

	// 시스템DB

	// 음주상태 regist complete --> MDS DB - 음주상태
	public List<Drinking> getDrinkingdbList();

	// MDS DB - 음주상태 검색
	public List<Drinking> getDrinkingdbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date);

	// MDS DB - 음주상태 삭제
	public int delDrinking(String dcCode, String hospitalId, String patientId);

}
