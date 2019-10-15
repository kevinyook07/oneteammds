package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.DrinkingMapper;
import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;

@Service
@Transactional
public class DrinkingService {

	@Autowired
	private DrinkingMapper drinkingMapper;

	// 병원1

	// 병원DB - 음주상태

	// 병원 권한 로그인시 입력되는 ID값 받아서 음주상태 리스트 출력 처리
	public List<Drinkingh> getDrinkinghList(String hospitalId) {
		return drinkingMapper.getDrinkinghList(hospitalId);
	}

	// 병원DB - 음주상태 -> 음주상태 regist form
	public Drinkingh getDrinkinghById(String patientId) {
		return drinkingMapper.getDrinkinghById(patientId);
	}

	// 음주상태 regist complete
	public int getDrinkingRegist(Drinking drinking) {
		return drinkingMapper.getDrinkingRegist(drinking);
	}

	// 음주상태 검색
	public List<Drinkingh> getDrinkingSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date) {

		List<Drinkingh> list = drinkingMapper.getDrinkingSearchList(hospitalId, sk, sv, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 음주상태
	public List<Drinking> getDrinkingdbList() {
		return drinkingMapper.getDrinkingdbList();
	}

	// MDS DB - 음주상태 검색
	public List<Drinking> getDrinkingdbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {

		List<Drinking> list = drinkingMapper.getDrinkingdbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// MDS DB - 음주상태 삭제
	public int delDrinking(String dcCode, String hospitalId, String patientId) {

		return drinkingMapper.delDrinking(dcCode, hospitalId, patientId);
	}

}
