package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.YebangMapper;
import com.cafe24.oneteammds.listvo.Yebang;
import com.cafe24.oneteammds.listvo.Yebangh;

@Service
@Transactional
public class YebangService {

	@Autowired
	private YebangMapper yebangMapper;
	
	// 병원
	
	// 병원DB - 예방접종내역
	public List<Yebangh> getYebanghList(){
		return yebangMapper.getYebanghList();
	}
	
	// 병원DB - 예방접종내역 -> 예방접종내역 regist form
	public Yebangh getYebanghById(String patientId) { 
		return yebangMapper.getYebanghById(patientId); 
	}
	
	// 예방접종내역 regist complete
	public int getYebangRegist(Yebang yebang) { 
		return yebangMapper.getYebangRegist(yebang);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 예방접종내역
	public List<Yebang> getYebangdbList(){ 
		return yebangMapper.getYebangdbList(); 
	}

}
