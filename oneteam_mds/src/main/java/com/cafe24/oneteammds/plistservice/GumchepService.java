package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.GumcheMapper;
import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Gumcheh;
import com.cafe24.oneteammds.plistmapper.GumchepMapper;

@Service
@Transactional
public class GumchepService {

	@Autowired
	private GumchepMapper gumchepMapper;


	// MDS p - 검체검사결과
	public List<Gumche> getGumchepList() {
		return gumchepMapper.getGumchepList();
	}

	// MDS p - 검체검사결과 검색
	public List<Gumche> getGumchepSearchList(String start_date, String finish_date) {
		List<Gumche> list = gumchepMapper.getGumchepSearchList(start_date, finish_date);

		return list;
	}

	

}
