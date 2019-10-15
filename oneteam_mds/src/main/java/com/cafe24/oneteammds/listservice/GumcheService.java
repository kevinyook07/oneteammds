package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.GumcheMapper;
import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Gumcheh;

@Service
@Transactional
public class GumcheService {

	@Autowired
	private GumcheMapper gumcheMapper;

	// 병원1

	// 병원DB - 검체검사결과

	// 병원 권한 로그인시 입력되는 ID값 받아서 검체검사결과 리스트 출력 처리
	public List<Gumcheh> getGumchehList(String hospitalId) {
		return gumcheMapper.getGumchehList(hospitalId);
	}

	// 병원DB - 검체검사결과 -> 검체검사결과 regist form
	public Gumcheh getGumchehById(String patientId) {
		return gumcheMapper.getGumchehById(patientId);
	}

	// 검체검사결과 regist complete
	public int getGumcheRegist(Gumche gumche) {
		return gumcheMapper.getGumcheRegist(gumche);
	}

	// 병원DB - 검체검사결과 검색
	public List<Gumcheh> getGumcheSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date) {
		List<Gumcheh> list = gumcheMapper.getGumcheSearchList(hospitalId, sk, sv, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 검체검사결과
	public List<Gumche> getGumchedbList() {
		return gumcheMapper.getGumchedbList();
	}

	// MDS DB - 검체검사결과 검색
	public List<Gumche> getGumchedbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {
		List<Gumche> list = gumcheMapper.getGumchedbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// MDS DB - 검체검사결과 삭제
	public int delGumche(String strCode, String hospitalId, String patientId) {

		return gumcheMapper.delGumche(strCode, hospitalId, patientId);
	}

}
