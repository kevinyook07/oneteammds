package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.AllergyMapper;
import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.plistmapper.AllergypMapper;

@Service
@Transactional
public class AllergypService {

	@Autowired
	private AllergypMapper allergypMapper;

	// 환자 - 알러지 및 부작용
	public List<Allergy> getAllergypList() {
		return allergypMapper.getAllergypList();
	}

	// 환자 - 알러지 및 부작용 검색
	public List<Allergy> getAllergypSearchList(String start_date, String finish_date) {

		List<Allergy> list = allergypMapper.getAllergypSearchList(start_date, finish_date);

		return list;
	}

}
