package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.SmokingMapper;
import com.cafe24.oneteammds.listvo.Smoking;
import com.cafe24.oneteammds.listvo.Smokingh;

@Service
@Transactional
public class SmokingService {

	@Autowired
	private SmokingMapper smokingMapper;

	// 병원1

	// 병원DB - 흡연상태

	// 병원 권한 로그인시 입력되는 ID값 받아서 흡연상태 리스트 출력 처리
	public List<Smokingh> getSmokinghList(String hospitalId) {
		return smokingMapper.getSmokinghList(hospitalId);
	}

	// 병원DB - 흡연상태 -> 흡연상태 regist form
	public Smokingh getSmokinghById(String patientId) {
		return smokingMapper.getSmokinghById(patientId);
	}

	// 흡연상태 regist complete
	public int getSmokingRegist(Smoking smoking) {
		return smokingMapper.getSmokingRegist(smoking);
	}

	// 흡연상태 검색
	public List<Smokingh> getSmokringSearchList(String hospitalId, String sk, String sv) {

		List<Smokingh> list = smokingMapper.getSmokingSearchList(hospitalId, sk, sv);

		return list;
	}

	// 시스템 DB

	// MDS DB - 흡연상태
	public List<Smoking> getSmokingdbList() {
		return smokingMapper.getSmokingdbList();
	}

	// MDS DB - 흡연상태 검색
	public List<Smoking> getSmokringdbSearchList(String sk, String sv) {

		List<Smoking> list = smokingMapper.getSmokingdbSearchList(sk, sv);

		return list;
	}

	// MDS DB - 흡연상태 삭제
	public int delSmoking(String scCode, String hospitalId, String patientId) {

		return smokingMapper.delSmoking(scCode, hospitalId, patientId);
	}
}
