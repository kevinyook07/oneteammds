package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.SaengchaeMapper;
import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Saengchaeh;

@Service
@Transactional
public class SaengchaeService {

	@Autowired
	private SaengchaeMapper saengchaeMapper;
	
	// 병원
	
	// 병원DB - 생체신호 및 상태
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 생체상태 및 신호 리스트  출력 처리
	public List<Saengchaeh> getSaengchaehList(String hospitalId){
		return saengchaeMapper.getSaengchaehList(hospitalId);
	}
	
	// 병원DB - 생체신호 및 상태 -> 생체신호 및 상태 regist form
	public Saengchaeh getSaengchaehById(String patientId) { 
		return saengchaeMapper.getSaengchaehById(patientId); 
	}
	
	// 생체신호 및 상태 regist complete
	public int getSaengchaeRegist(Saengchae saengchae) { 
		return saengchaeMapper.getSaengchaeRegist(saengchae);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 생체신호 및 상태
	public List<Saengchae> getSaengchaedbList(){ 
		return saengchaeMapper.getSaengchaedbList(); 
	}

}
