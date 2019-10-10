package com.cafe24.oneteammds.service;

//계정 오류로 인한 push
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.mapper.HospitalMapper;
import com.cafe24.oneteammds.vo.Hospital;

@Service
@Transactional
public class HospitalService {

	@Autowired
	private HospitalMapper hospitalMapper;

	// 병원 권한 로그인
	public Map<String, Object> getHospitalLogin(Hospital hospital) {

		String result = "";

		Map<String, Object> map = new HashMap<String, Object>();

		Hospital hospitalCheck = hospitalMapper.getHospitalLogin(hospital);

		if (hospitalCheck == null) {
			Hospital hospitalIdCheck = hospitalMapper.getHospitalById(hospital.getH_id());
			if (hospitalIdCheck == null) {
				result = "등록된 아이디의 정보가 없습니다.";
			} else {
				result = "비밀번호가 일치하지 않습니다.";
			}

		} else {
			result = "로그인 성공";
			map.put("loginHospital", hospitalCheck);
		}

		map.put("result", result);

		return map;
	}

	// 병원 권한 리스트
	public List<Hospital> getHospitalList() {
		List<Hospital> list = hospitalMapper.getHospitalList();
		return list;
	}

	// 병원 권한 리스트 검색
	public List<Hospital> getHospitalSearchList(String sk2, String sv2) {
		List<Hospital> list = hospitalMapper.getHospitalSearchList(sk2, sv2);

		return list;
	}

	// 병원 권한 회원등록
	public int addHospital(Hospital hospital) {
		int result = hospitalMapper.addHospital(hospital);
		return result;
	}

	// 병원 권한 로그인 값 가져오기
	public Hospital getHospitalById(String h_id) {

		return hospitalMapper.getHospitalById(h_id);
	}

	// 병원 권한 회원수정
	public int modifyHospital(Hospital hospital) {
		return hospitalMapper.modifyHospital(hospital);
	}

	// 병원 권한 회원삭제
	public int deleteHospital(String h_id, String h_pw) {
		return hospitalMapper.delHospital(h_id, h_pw);
	}

}
