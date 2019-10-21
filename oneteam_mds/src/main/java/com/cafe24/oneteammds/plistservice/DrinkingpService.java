package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.DrinkingMapper;
import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;
import com.cafe24.oneteammds.plistmapper.DrinkingpMapper;

@Service
@Transactional
public class DrinkingpService {

	@Autowired
	private DrinkingpMapper drinkingpMapper;

	

	// MDS p - 음주상태
	public List<Drinking> getDrinkingpList() {
		return drinkingpMapper.getDrinkingpList();
	}

	// MDS p - 음주상태 검색
	public List<Drinking> getDrinkingpSearchList(String start_date, String finish_date) {

		List<Drinking> list = drinkingpMapper.getDrinkingpSearchList(start_date, finish_date);

		return list;
	}

	

}
