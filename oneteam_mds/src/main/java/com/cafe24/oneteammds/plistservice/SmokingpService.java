package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.SmokingMapper;
import com.cafe24.oneteammds.listvo.Smoking;
import com.cafe24.oneteammds.listvo.Smokingh;
import com.cafe24.oneteammds.plistmapper.SmokingpMapper;

@Service
@Transactional
public class SmokingpService {

	@Autowired
	private SmokingpMapper smokingpMapper;

	// 환자 - 흡연상태
	public List<Smoking> getSmokingpList() {
		return smokingpMapper.getSmokingpList();
	}

	// 환자 - 흡연상태 검색
	public List<Smoking> getSmokringpSearchList(String start_date, String finish_date) {

		List<Smoking> list = smokingpMapper.getSmokingpSearchList(start_date, finish_date);

		return list;
	}

}
