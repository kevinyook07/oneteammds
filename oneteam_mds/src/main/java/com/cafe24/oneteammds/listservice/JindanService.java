package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.JindanMapper;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Jindanh;

@Service
@Transactional
public class JindanService {

	@Autowired
	private JindanMapper jindanMapper;

	// 병원

	// 병원DB - 진단내역

	// 병원 권한 로그인시 입력되는 ID값 받아서 진단내역 리스트 출력 처리
	public List<Jindanh> getJindanhList(String hospitalId) {
		return jindanMapper.getJindanhList(hospitalId);
	}

	// 병원DB - 진단내역 -> 진단내역 regist form
	public Jindanh getJindanhById(String patientId) {
		return jindanMapper.getJindanhById(patientId);
	}

	// 진단내역 regist complete
	public int getJindanRegist(Jindan jindan) {
		return jindanMapper.getJindanRegist(jindan);
	}

	// 병원DB - 검색
	public List<Jindanh> getJindanhSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date) {
		List<Jindanh> list = jindanMapper.getJindanhSearchList(hospitalId, sk, sv, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 진단내역
	public List<Jindan> getJindandbList() {
		return jindanMapper.getJindandbList();
	}

	// MDS DB - 진단내역 검색
	public List<Jindan> getJindandbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {
		List<Jindan> list = jindanMapper.getJindandbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// MDS DB - 진단내역 삭제
	public int delJindan(String dbCode, String hospitalId, String patientId) {

		return jindanMapper.delJindan(dbCode, hospitalId, patientId);
	}

}
