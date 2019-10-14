package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Byungrih;

@Mapper
public interface ByungriMapper {

	// 병원

	// 병원DB - 병리검사결과

	// 병원 권한 로그인시 입력되는 ID값 받아서 병리검사결과 리스트 출력 처리
	public List<Byungrih> getByungrihList(String hospitalId);

	// 병원DB - 병리검사결과 --> 병리검사결과 regist form
	public Byungrih getByungrihById(String patientId);

	public int getByungriRegist(Byungri byungri);

	// 병원DB - 병리검사결과 검색
	public List<Byungrih> getByungriSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date);

	// 시스템DB

	// 병리검사결과 regist complete --> MDS DB - 병리검사결과
	public List<Byungri> getByungridbList();

	// MDS DB - 병리검사결과 검색
	public List<Byungri> getByungridbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date);

	// MDS DB - 병리검사결과 삭제
	public int delByungri(String ptrCode, String hospitalId, String patientId);
}
