package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.YoungsangMapper;
import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.listvo.Youngsangh;

@Service
@Transactional
public class YoungsangService {

	@Autowired
	private YoungsangMapper youngsangMapper;

	// 병원

	// 병원DB - 영상검사결과

	// 병원 권한 로그인시 입력되는 ID값 받아서 영상검사결과 리스트 출력 처리
	public List<Youngsangh> getYoungsanghList(String hospitalId) {
		return youngsangMapper.getYoungsanghList(hospitalId);
	}

	// 병원DB - 영상검사결과 -> 영상검사결과 regist form
	public Youngsangh getYoungsanghById(String patientId) {
		return youngsangMapper.getYoungsanghById(patientId);
	}

	// 영상검사결과 regist complete
	public int getYoungsangRegist(Youngsang youngsang) {
		return youngsangMapper.getYoungsangRegist(youngsang);
	}

	// 영상검사결과 검색
	public List<Youngsangh> getYoungsangSearchList(String hospitalId, String sk, String sv, String start_date, String finish_date) {

		List<Youngsangh> list = youngsangMapper.getYoungsangSearchList(hospitalId, sk, sv, start_date, finish_date);

		return list;
	}

	// 시스템 DB

	// MDS DB - 영상검사결과
	public List<Youngsang> getYoungsangdbList() {
		return youngsangMapper.getYoungsangdbList();
	}

	// MDS DB - 영상검사결과 검색
	public List<Youngsang> getYoungsangdbSearchList(String sk, String sv, String start_date, String finish_date) {

		List<Youngsang> list = youngsangMapper.getYoungsangdbSearchList(sk, sv, start_date, finish_date);

		return list;
	}

	// MDS DB - 영상검사결과 삭제
	public int delYoungsang(String itrCode, String hospitalId, String patientId) {

		return youngsangMapper.delYoungsang(itrCode, hospitalId, patientId);
	}

}
