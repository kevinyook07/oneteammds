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

	// 병원

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
	public List<Junyumh> getJunyumSearchList(String hospitalId, String sk, String sv) {

		List<Junyumh> list = junyumMapper.getJunyumSearchList(hospitalId, sk, sv);

		return list;
	}

	// 시스템 DB

	// MDS DB - 법정 전염성 감염병
	public List<Junyum> getJunyumdbList() {
		return junyumMapper.getJunyumdbList();
	}

	// MDS DB - 법정 전염성 감염병 검색
	public List<Junyum> getJunyumdbSearchList(String sk, String sv) {

		List<Junyum> list = junyumMapper.getJunyumdbSearchList(sk, sv);

		return list;
	}

	// MDS DB - 법정 전염성 감염병 삭제
	public int delJunyum(String lcidCode, String hospitalId, String patientId) {

		return junyumMapper.delJunyum(lcidCode, hospitalId, patientId);
	}

}
