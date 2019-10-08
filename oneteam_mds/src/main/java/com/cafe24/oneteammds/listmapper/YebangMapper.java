package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Yebang;
import com.cafe24.oneteammds.listvo.Yebangh;

@Mapper
public interface YebangMapper {
	
	// 병원
	
	// 병원DB - 예방접종내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 예방접종내역 리스트  출력 처리
	public List<Yebangh> getYebanghList(String hospitalId);
	
	// 병원DB - 예방접종내역 --> 예방접종내역 regist form
	public Yebangh getYebanghById(String patientId);
	  
	public int getYebangRegist(Yebang yebang);
	  
	// 시스템DB 
	
	// 예방접종내역 regist complete --> MDS DB - 예방접종내역
	public List<Yebang> getYebangdbList();
	 
}
