package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.AllergyMapper;
import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.listvo.Allergyh;

@Service
@Transactional
public class AllergyService {

	@Autowired
	private AllergyMapper allergyMapper;

	// 병원

	// 병원DB - 알러지 및 부작용

	// 병원 권한 로그인시 입력되는 ID값 받아서 알러지 및 부작용 리스트 출력 처리
	public List<Allergyh> getAllergyhList(String hospitalId) {
		return allergyMapper.getAllergyhList(hospitalId);
	}

	// 병원DB - 알러지 및 부작용 -> 알러지 및 부작용 regist form
	public Allergyh getAllergyhById(String patientId) {
		return allergyMapper.getAllergyhById(patientId);
	}

	// 알러지 및 부작용 regist complete
	public int getAllergyRegist(Allergy allergy) {
		return allergyMapper.getAllergyRegist(allergy);
	}

	// 알러지 및 부작용 검색
	public List<Allergyh> getAllergySearchList(String hospitalId, String sk, String sv, String start_date, String finish_dates) {

		List<Allergyh> list = allergyMapper.getAllergySearchList(hospitalId, sk, sv, start_date, finish_dates);

		return list;
	}

	// 시스템 DB

	// MDS DB - 알러지 및 부작용
	public List<Allergy> getAllergydbList() {
		return allergyMapper.getAllergydbList();
	}

	// MDS DB - 알러지 및 부작용 검색
	public List<Allergy> getAllergydbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {

		List<Allergy> list = allergyMapper.getAllergydbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// MDS DB - 알러지 및 부작용 삭제
	public int delAllergy(String aseCode, String hospitalId, String patientId) {

		return allergyMapper.delAllergy(aseCode, hospitalId, patientId);
	}

}
