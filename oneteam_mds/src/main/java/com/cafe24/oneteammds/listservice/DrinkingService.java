package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.DrinkingMapper;
import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;

@Service
@Transactional
public class DrinkingService {

	@Autowired
	private DrinkingMapper drinkingMapper;
	
	// 병원
	
	// 병원DB - 음주상태
	public List<Drinkingh> getDrinkinghList(){
		return drinkingMapper.getDrinkinghList();
	}
	
	// 병원DB - 음주상태 -> 음주상태 regist form
	public Drinkingh getDrinkinghById(String patientId) { 
		return drinkingMapper.getDrinkinghById(patientId); 
	}
	
	// 음주상태 regist complete
	public int getDrinkingRegist(Drinking drinking) { 
		return drinkingMapper.getDrinkingRegist(drinking);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 음주상태
	public List<Drinking> getDrinkingdbList(){ 
		return drinkingMapper.getDrinkingdbList(); 
	}
	 
}
