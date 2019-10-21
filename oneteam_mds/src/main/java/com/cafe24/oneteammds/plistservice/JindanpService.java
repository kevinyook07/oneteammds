package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.plistmapper.JindanpMapper;

@Service
@Transactional
public class JindanpService {

	@Autowired
	private JindanpMapper jindanpMapper;

	// 환자 - 진단내역
	public List<Jindan> getJindanpList() {
		return jindanpMapper.getJindanpList();
	}
	
	// 환자 - 진단내역 검색
	public List<Jindan> getJindanpSearchList(String start_date, String finish_date){
		List<Jindan> list = jindanpMapper.getJindanpSearchList(start_date, finish_date);
		
		return list;
	}
}
