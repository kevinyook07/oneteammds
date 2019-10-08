package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.YoungsangMapper;
import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.listvo.Youngsangh;

@Service
@Transactional
public class YoungsangService {

	@Autowired
	private YoungsangMapper youngsangMapper;
	
	// 병원
	
	// 병원DB - 영상검사결과
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 영상검사결과 리스트  출력 처리
	public List<Youngsangh> getYoungsanghList(String hospitalId){
		return youngsangMapper.getYoungsanghList(hospitalId);
	}
	
	// 병원DB - 영상검사결과 -> 영상검사결과 regist form
	public Youngsangh getYoungsanghById(String patientId) { 
		return youngsangMapper.getYoungsanghById(patientId); 
	}
	
	// 영상검사결과 regist complete
	public int getYoungsangRegist(Youngsang youngsang) { 
		return youngsangMapper.getYoungsangRegist(youngsang);
	} 
	
	// 시스템 DB
	
	// MDS DB - 영상검사결과
	public List<Youngsang> getYoungsangdbList(){ 
		return youngsangMapper.getYoungsangdbList(); 
	}

}
