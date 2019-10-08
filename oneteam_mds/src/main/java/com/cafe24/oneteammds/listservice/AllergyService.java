package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.AllergyMapper;
import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.listvo.Allergyh;

@Service
@Transactional
public class AllergyService {

	@Autowired
	private AllergyMapper allergyMapper;
	
	// 병원
	
	// 병원DB - 알러지 및 부작용
	public List<Allergyh> getAllergyhList(){
		return allergyMapper.getAllergyhList();
	}
	
	// 병원DB - 알러지 및 부작용 -> 알러지 및 부작용 regist form
	public Allergyh getAllergyhById(String patientId) { 
		return allergyMapper.getAllergyhById(patientId); 
	}
	
	// 알러지 및 부작용 regist complete
	public int getAllergyRegist(Allergy allergy) { 
		return allergyMapper.getAllergyRegist(allergy);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 알러지 및 부작용
	public List<Allergy> getAllergydbList(){ 
		return allergyMapper.getAllergydbList(); 
	}

}
