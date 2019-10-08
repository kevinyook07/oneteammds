package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.JindanMapper;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Jindanh;

@Service
@Transactional
public class JindanService {

	@Autowired
	private JindanMapper jindanMapper;
	
	// 병원
	
	// 병원DB - 진단내역
	public List<Jindanh> getJindanhList(){
		return jindanMapper.getJindanhList();
	}
	
	// 병원DB - 진단내역 -> 진단내역 regist form
	public Jindanh getJindanhById(String patientId) { 
		return jindanMapper.getJindanhById(patientId); 
	}
	
	// 진단내역 regist complete
	public int getJindanRegist(Jindan jindan) { 
		return jindanMapper.getJindanRegist(jindan);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 진단내역
	public List<Jindan> getJindandbList(){ 
		return jindanMapper.getJindandbList(); 
	}
	 
}
