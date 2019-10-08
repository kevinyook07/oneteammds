package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.listvo.Allergyh;

@Mapper
public interface AllergyMapper {
	
	// 병원
	
	// 병원DB - 알러지 및 부작용
	public List<Allergyh> getAllergyhList();
	
	// 병원DB - 알러지 및 부작용 --> 알러지 및 부작용 regist form
	public Allergyh getAllergyhById(String patientId);
	  
	public int getAllergyRegist(Allergy allergy);
	  
	// 시스템DB 
	
	// 알러지 및 부작용 regist complete --> MDS DB - 알러지 및 부작용
	public List<Allergy> getAllergydbList();
	
}
