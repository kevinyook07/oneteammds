package com.cafe24.oneteammds.yochenglistservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.yochenglistmapper.YochengAllergyMapper;
import com.cafe24.oneteammds.yochenglistvo.YochengAllergy;



@Service
@Transactional //서비스, 트랜젝션
public class YochengAllergyService {

	@Autowired //매퍼 연결
	private YochengAllergyMapper yochengAllergyMapper;
	
	//접근 지정자 설정 후 getYochengAdminInsert 메서드 입력, return 값 입력 // return은 호출된 곳으로 return 된다.
	public int getYochengAdminInsert(YochengAllergy yochengAllergy) {
		
		return yochengAllergyMapper.getYochengAdminInsert(yochengAllergy);
	}
}
