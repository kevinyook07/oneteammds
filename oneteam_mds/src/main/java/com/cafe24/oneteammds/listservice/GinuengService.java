package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.GinuengMapper;
import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;

@Service
@Transactional
public class GinuengService {

	@Autowired
	private GinuengMapper ginuengMapper;

	// 병원

	// 병원DB - 기능검사결과

	// 병원 권한 로그인시 입력되는 ID값 받아서 기능검사결과 리스트 출력 처리
	public List<Ginuengh> getGinuenghList(String hospitalId) {
		return ginuengMapper.getGinuenghList(hospitalId);
	}

	// 병원DB - 기능검사결과 -> 기능검사결과 regist form
	public Ginuengh getGinuenghById(String patientId) {
		return ginuengMapper.getGinuenghById(patientId);
	}

	// 기능검사결과 regist complete
	public int getGinuengRegist(Ginueng ginueng) {
		return ginuengMapper.getGinuengRegist(ginueng);
	}

	// 기능검사결과 검색
	public List<Ginuengh> getGinuengSearchList(String hospitalId, String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {

		List<Ginuengh> list = ginuengMapper.getGinuengSearchList(hospitalId, sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 기능검사결과
	public List<Ginueng> getGinuengdbList() {
		return ginuengMapper.getGinuengdbList();
	}

	// MDS DB - 기능검사결과 검색
	public List<Ginueng> getGinuengdbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {

		List<Ginueng> list = ginuengMapper.getGinuengdbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// MDS DB - 기능검사결과 삭제
	public int delGinueng(String ftrCode, String hospitalId, String patientId) {

		return ginuengMapper.delGinueng(ftrCode, hospitalId, patientId);
	}

}
