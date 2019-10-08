package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.SusulMapper;
import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Susulh;

@Service
@Transactional
public class SusulService {

	@Autowired
	private SusulMapper susulMapper;
	
	// 병원
	
	// 병원DB - 수술내역
	public List<Susulh> getSusulhList(){
		return susulMapper.getSusulhList();
	}
	
	// 병원DB - 수술내역 -> 수술내역 regist form
	public Susulh getSusulhById(String patientId) { 
		return susulMapper.getSusulhById(patientId); 
	}
	
	// 수술내역 regist complete
	public int getSusulRegist(Susul susul) { 
		return susulMapper.getSusulRegist(susul);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 수술내역
	public List<Susul> getSusuldbList(){ 
		return susulMapper.getSusuldbList(); 
	}
 
}
