package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.PandogMapper;
import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;
import com.cafe24.oneteammds.plistmapper.PandogpMapper;

@Service
@Transactional
public class PandogpService {

	@Autowired
	private PandogpMapper pandogpMapper;

	

	// MDS p - 영상판독정보
	public List<Pandog> getPandogpList() {
		return pandogpMapper.getPandogpList();
	}

	// MDS p - 영상판독정보 검색
	public List<Pandog> getPandogpSearchList(String start_date, String finish_date) {

		List<Pandog> list = pandogpMapper.getPandogpSearchList(start_date, finish_date);

		return list;
	}

	

}
