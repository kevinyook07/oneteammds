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
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 수술내역 리스트  출력 처리
	public List<Susulh> getSusulhList(String hospitalId){
		return susulMapper.getSusulhList(hospitalId);
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
