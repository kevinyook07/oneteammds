package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.GinuengMapper;
import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;

@Service
@Transactional
public class GinuengService {

	@Autowired
	private GinuengMapper ginuengMapper;
	
	// 병원
	
	// 병원DB - 기능검사결과
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 기능검사결과 리스트  출력 처리
	public List<Ginuengh> getGinuenghList(String hospitalId){
		return ginuengMapper.getGinuenghList(hospitalId);
	}
	
	// 병원DB - 기능검사결과 -> 기능검사결과 regist form
	public Ginuengh getGinuenghById(String patientId) { 
		return ginuengMapper.getGinuenghById(patientId); 
	}
	
	// 기능검사결과 regist complete
	public int getGinuengRegist(Ginueng ginueng) { 
		return ginuengMapper.getGinuengRegist(ginueng);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 기능검사결과
	public List<Ginueng> getGinuengdbList(){ 
		return ginuengMapper.getGinuengdbList(); 
	}
 
}
