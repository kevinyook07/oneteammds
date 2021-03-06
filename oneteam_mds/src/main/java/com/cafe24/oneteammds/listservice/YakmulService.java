package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.YakmulMapper;
import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;

@Service
@Transactional
public class YakmulService {

	@Autowired
	private YakmulMapper yakmulMapper;

	// 병원

	// 병원DB - 약물처방내역

	// 병원 권한 로그인시 입력되는 ID값 받아서 약물처방내역 리스트 출력 처리
	public List<Yakmulh> getYakmulhList(String hospitalId) {
		return yakmulMapper.getYakmulhList(hospitalId);
	}

	// 병원DB - 약물처방내역 -> 약물처방내역 regist form
	public Yakmulh getYakmulhById(String patientId) {
		return yakmulMapper.getYakmulhById(patientId);
	}

	// 약물처방내역 regist complete
	public int getYakmulRegist(Yakmul yakmul) {
		return yakmulMapper.getYakmulRegist(yakmul);
	}

	// 약물처방내역 검색
	public List<Yakmulh> getYakmulSearchList(String hospitalId, String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {
		List<Yakmulh> list = yakmulMapper.getYakmulSearchList(hospitalId, sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 약물처방내역
	public List<Yakmul> getYakmuldbList() {
		return yakmulMapper.getYakmuldbList();
	}

	// MDS DB - 약물처방내역 검색
	public List<Yakmul> getYakmuldbSearchList(String sk1, String sk2, String sk3, String sv1, String sv2, String sv3, String start_date, String finish_date) {
		List<Yakmul> list = yakmulMapper.getYakmuldbSearchList(sk1, sk2, sk3, sv1, sv2, sv3, start_date, finish_date);

		return list;
	}

	// MDS DB - 약물처방내역 삭제
	public int delYakmul(String mbCode, String hospitalId, String patientId) {

		return yakmulMapper.delYakmul(mbCode, hospitalId, patientId);
	}

}
