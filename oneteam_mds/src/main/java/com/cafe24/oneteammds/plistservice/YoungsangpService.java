package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.YoungsangMapper;
import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.listvo.Youngsangh;
import com.cafe24.oneteammds.plistmapper.YoungsangpMapper;

@Service
@Transactional
public class YoungsangpService {

	@Autowired
	private YoungsangpMapper youngsangpMapper;

	// 환자 - 영상검사결과
	public List<Youngsang> getYoungsangpList() {
		return youngsangpMapper.getYoungsangpList();
	}

	// 환자 - 영상검사결과 검색
	public List<Youngsang> getYoungsangpSearchList(String start_date, String finish_date) {

		List<Youngsang> list = youngsangpMapper.getYoungsangpSearchList(start_date, finish_date);

		return list;
	}

}
