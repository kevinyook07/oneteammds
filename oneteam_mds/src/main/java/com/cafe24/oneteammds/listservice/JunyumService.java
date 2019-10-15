package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.JunyumMapper;
import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Junyumh;

@Service
@Transactional
public class JunyumService {

	@Autowired
	private JunyumMapper junyumMapper;

	// 병원1

	// 병원DB - 법정 전염성 감염병

	// 병원 권한 로그인시 입력되는 ID값 받아서 법정 전염성 감염병 리스트 출력 처리
	public List<Junyumh> getJunyumhList(String hospitalId) {
		return junyumMapper.getJunyumhList(hospitalId);
	}

	// 병원DB - 법정 전염성 감염병 -> 법정 전염성 감염병 regist form
	public Junyumh getJunyumhById(String patientId) {
		return junyumMapper.getJunyumhById(patientId);
	}

	// 법정 전염성 감염병 regist complete
	public int getJunyumRegist(Junyum junyum) {
		return junyumMapper.getJunyumRegist(junyum);
	}

	// 법정 전염성 감염병 검색
	public List<Junyumh> getJunyumSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date) {

		List<Junyumh> list = junyumMapper.getJunyumSearchList(hospitalId, sk, sv, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 법정 전염성 감염병
	public List<Junyum> getJunyumdbList() {
		return junyumMapper.getJunyumdbList();
	}

	// MDS DB - 법정 전염성 감염병 검색
	public List<Junyum> getJunyumdbSearchList(String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {

		List<Junyum> list = junyumMapper.getJunyumdbSearchList(sk1, sk2, sv1, sv2, start_date, finish_date);

		return list;
	}

	// MDS DB - 법정 전염성 감염병 삭제
	public int delJunyum(String lcidCode, String hospitalId, String patientId) {

		return junyumMapper.delJunyum(lcidCode, hospitalId, patientId);
	}

}
