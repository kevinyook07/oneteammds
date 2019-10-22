package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.ByungriMapper;
import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Byungrih;
import com.cafe24.oneteammds.plistmapper.ByungripMapper;

@Service
@Transactional
public class ByungripService {

	@Autowired
	private ByungripMapper byungripMapper;

	// 환자 - 병리검사결과
	public List<Byungri> getByungripList() {
		return byungripMapper.getByungripList();
	}

	// 환자 - 병리검사결과 검색
	public List<Byungri> getByungripSearchList(String start_date, String finish_date) {
		List<Byungri> list = byungripMapper.getByungripSearchList(start_date, finish_date);

		return list;
	}

}
