package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.YakmulMapper;
import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;

@Service
@Transactional
public class YakmulService {

	@Autowired
	private YakmulMapper yakmulMapper;
	
	// 병원
	
	// 병원DB - 약물처방내역
	public List<Yakmulh> getYakmulhList(){
		return yakmulMapper.getYakmulhList();
	}
	
	// 병원DB - 약물처방내역 -> 약물처방내역 regist form
	public Yakmulh getYakmulhById(String patientId) { 
		return yakmulMapper.getYakmulhById(patientId); 
	}
	
	// 약물처방내역 regist complete
	public int getYakmulRegist(Yakmul yakmul) { 
		return yakmulMapper.getYakmulRegist(yakmul);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 약물처방내역
	public List<Yakmul> getYakmuldbList(){ 
		return yakmulMapper.getYakmuldbList(); 
	}
	 
}
