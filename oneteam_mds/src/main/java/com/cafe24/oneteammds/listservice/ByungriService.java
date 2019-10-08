package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.ByungriMapper;
import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Byungrih;

@Service
@Transactional
public class ByungriService {

	@Autowired
	private ByungriMapper byungriMapper;
	
	// 병원
	
	// 병원DB - 병리검사결과
	public List<Byungrih> getByungrihList(){
		return byungriMapper.getByungrihList();
	}
	
	// 병원DB - 병리검사결과 -> 병리검사결과 regist form
	public Byungrih getByungrihById(String patientId) { 
		return byungriMapper.getByungrihById(patientId); 
	}
	
	// 병리검사결과 regist complete
	public int getByungriRegist(Byungri byungri) { 
		return byungriMapper.getByungriRegist(byungri);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 병리검사결과
	public List<Byungri> getByungridbList(){ 
		return byungriMapper.getByungridbList(); 
	}

}
