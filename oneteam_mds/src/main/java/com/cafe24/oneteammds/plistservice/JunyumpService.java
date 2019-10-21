package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.JunyumMapper;
import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Junyumh;
import com.cafe24.oneteammds.plistmapper.JunyumpMapper;

@Service
@Transactional
public class JunyumpService {

	@Autowired
	private JunyumpMapper junyumpMapper;

	

	// MDS p - 법정 전염성 감염병
	public List<Junyum> getJunyumpList() {
		return junyumpMapper.getJunyumpList();
	}

	// MDS p - 법정 전염성 감염병 검색
	public List<Junyum> getJunyumpSearchList(String start_date, String finish_date) {

		List<Junyum> list = junyumpMapper.getJunyumpSearchList(start_date, finish_date);

		return list;
	}

	

}
