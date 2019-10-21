package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.SusulMapper;
import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Susulh;
import com.cafe24.oneteammds.plistmapper.SusulpMapper;

@Service
@Transactional
public class SusulpService {

	@Autowired
	private SusulpMapper susulpMapper;

	

	// MDS p - 수술내역
	public List<Susul> getSusulpList() {
		return susulpMapper.getSusulpList();
	}

	// MDS p - 수술내역 검색
	public List<Susul> getSusulpSearchList(String start_date, String finish_date) {

		List<Susul> list = susulpMapper.getSusulpSearchList(start_date, finish_date);

		return list;
	}

	
}
