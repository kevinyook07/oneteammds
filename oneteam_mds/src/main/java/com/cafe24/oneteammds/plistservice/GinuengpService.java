package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.GinuengMapper;
import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;
import com.cafe24.oneteammds.plistmapper.GinuengpMapper;

@Service
@Transactional
public class GinuengpService {

	@Autowired
	private GinuengpMapper ginuengpMapper;

	

	// MDS p - 기능검사결과
	public List<Ginueng> getGinuengpList() {
		return ginuengpMapper.getGinuengpList();
	}

	// MDS p - 기능검사결과 검색
	public List<Ginueng> getGinuengpSearchList(String start_date, String finish_date) {

		List<Ginueng> list = ginuengpMapper.getGinuengpSearchList(start_date, finish_date);

		return list;
	}

	

}
