package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.YakmulMapper;
import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;
import com.cafe24.oneteammds.plistmapper.YakmulpMapper;

@Service
@Transactional
public class YakmulpService {

	@Autowired
	private YakmulpMapper yakmulpMapper;

	

	// MDS p - 약물처방내역
	public List<Yakmul> getYakmulpList() {
		return yakmulpMapper.getYakmulpList();
	}

	// MDS p - 약물처방내역 검색
	public List<Yakmul> getYakmulpSearchList(String start_date, String finish_date) {
		List<Yakmul> list = yakmulpMapper.getYakmulpSearchList(start_date, finish_date);

		return list;
	}

	

}
