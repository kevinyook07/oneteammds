package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.listvo.Allergyh;

@Mapper
public interface AllergyMapper {

	// 병원1

	// 병원DB - 알러지 및 부작용

	// 병원 권한 로그인시 입력되는 ID값 받아서 알러지 및 부작용 리스트 출력 처리
	public List<Allergyh> getAllergyhList(String hospitalId);

	// 병원DB - 알러지 및 부작용 --> 알러지 및 부작용 regist form
	public Allergyh getAllergyhById(String patientId);

	public int getAllergyRegist(Allergy allergy);

	// 병원DB - 알러지 및 부작용 검색
	public List<Allergyh> getAllergySearchList(String hospitalId, String sk, String sv, String start_date, String finish_date);

	// 시스템DB

	// 알러지 및 부작용 regist complete --> MDS DB - 알러지 및 부작용
	public List<Allergy> getAllergydbList();

	// MDS DB - 알러지 및 부작용 검색
	public List<Allergy> getAllergydbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date);

	// MDS DB - 알러지 및 부작용 삭제
	public int delAllergy(String aseCode, String hospitalId, String patientId);

}
