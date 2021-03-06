package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.PandogMapper;
import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;

@Service
@Transactional
public class PandogService {

	@Autowired
	private PandogMapper pandogMapper;

	// 병원

	// 병원DB - 영상판독정보

	// 병원 권한 로그인시 입력되는 ID값 받아서 영상판독정보 리스트 출력 처리
	public List<Pandogh> getPandoghList(String hospitalId) {
		return pandogMapper.getPandoghList(hospitalId);
	}

	// 병원DB - 영상판독정보 -> 영상판독정보 regist form
	public Pandogh getPandoghById(String patientId) {
		return pandogMapper.getPandoghById(patientId);
	}

	// 영상판독정보 regist complete
	public int getPandogRegist(Pandog pandog) {
		return pandogMapper.getPandogRegist(pandog);
	}

	// 영상판독정보 검색
	public List<Pandogh> getPandogSearchList(String hospitalId, String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {

		List<Pandogh> list = pandogMapper.getPandogSearchList(hospitalId, sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 영상판독정보
	public List<Pandog> getPandogdbList() {
		return pandogMapper.getPandogdbList();
	}

	// MDS DB - 영상판독정보 검색
	public List<Pandog> getPandogdbSearchList(String sk1, String sk2, String sk3, String sv1, String sv2, String sv3, String start_date, String finish_date) {

		List<Pandog> list = pandogMapper.getPandogdbSearchList(sk1, sk2, sk3, sv1, sv2, sv3, start_date, finish_date);

		return list;
	}

	// MDS DB - 영상판독정보 삭제
	public int delPandog(String iidCode, String hospitalId, String patientId) {

		return pandogMapper.delPandog(iidCode, hospitalId, patientId);
	}

}
