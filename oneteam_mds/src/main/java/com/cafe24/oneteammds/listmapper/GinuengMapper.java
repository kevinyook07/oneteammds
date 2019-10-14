package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;

@Mapper
public interface GinuengMapper {

	// 병원

	// 병원DB - 기능검사결과

	// 병원 권한 로그인시 입력되는 ID값 받아서 기능검사결과 리스트 출력 처리
	public List<Ginuengh> getGinuenghList(String hospitalId);

	// 병원DB - 기능검사결과 --> 기능검사결과 regist form
	public Ginuengh getGinuenghById(String patientId);

	public int getGinuengRegist(Ginueng ginueng);

	// 병원DB - 기능검사결과
	public List<Ginuengh> getGinuengSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date);

	// 시스템DB

	// 기능검사결과 regist complete --> MDS DB - 기능검사결과
	public List<Ginueng> getGinuengdbList();

	// MDS DB - 기능검사결과 검색
	public List<Ginueng> getGinuengdbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date);

	// MDS DB - 기능검사결과 삭제
	public int delGinueng(String ftrCode, String hospitalId, String patientId);

}
