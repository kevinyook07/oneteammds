package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.SaengchaeMapper;
import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Saengchaeh;
import com.cafe24.oneteammds.plistmapper.SaengchaepMapper;

@Service
@Transactional
public class SaengchaepService {

	@Autowired
	private SaengchaepMapper saengchaepMapper;

	// 환자 - 생체신호 및 상태
	public List<Saengchae> getSaengchaepList() {
		return saengchaepMapper.getSaengchaepList();
	}

	// 환자 - 생체신호 및 상태 검색
	public List<Saengchae> getSaengchaepSearchList(String start_date, String finish_date) {

		List<Saengchae> list = saengchaepMapper.getSaengchaepSearchList(start_date, finish_date);

		return list;
	}

}
