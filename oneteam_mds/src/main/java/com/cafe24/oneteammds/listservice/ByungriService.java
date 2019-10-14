package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.ByungriMapper;
import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Byungrih;

@Service
@Transactional
public class ByungriService {

	@Autowired
	private ByungriMapper byungriMapper;

	// 병원

	// 병원DB - 병리검사결과

	// 병원 권한 로그인시 입력되는 ID값 받아서 병리검사결과 리스트 출력 처리
	public List<Byungrih> getByungrihList(String hospitalId) {
		return byungriMapper.getByungrihList(hospitalId);
	}

	// 병원DB - 병리검사결과 -> 병리검사결과 regist form
	public Byungrih getByungrihById(String patientId) {
		return byungriMapper.getByungrihById(patientId);
	}

	// 병리검사결과 regist complete
	public int getByungriRegist(Byungri byungri) {
		return byungriMapper.getByungriRegist(byungri);
	}

	// 병리검사결과 검색
	public List<Byungrih> getByungriSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date) {
		List<Byungrih> list = byungriMapper.getByungriSearchList(hospitalId, sk, sv, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 병리검사결과
	public List<Byungri> getByungridbList() {
		return byungriMapper.getByungridbList();
	}

	// MDS DB - 병리검사결과 검색
	public List<Byungri> getByungridbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {
		List<Byungri> list = byungriMapper.getByungridbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// MDS DB - 병리검사결과 삭제
	public int delByungri(String ptrCode, String hospitalId, String patientId) {

		return byungriMapper.delByungri(ptrCode, hospitalId, patientId);
	}

}
