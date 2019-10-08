package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.GumcheMapper;
import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Gumcheh;

@Service
@Transactional
public class GumcheService {

	@Autowired
	private GumcheMapper gumcheMapper;
	
	// 병원
	
	// 병원DB - 검체검사결과
	public List<Gumcheh> getGumchehList(){
		return gumcheMapper.getGumchehList();
	}
	
	// 병원DB - 검체검사결과 -> 검체검사결과 regist form
	public Gumcheh getGumchehById(String patientId) { 
		return gumcheMapper.getGumchehById(patientId); 
	}
	
	// 검체검사결과 regist complete
	public int getGumcheRegist(Gumche gumche) { 
		return gumcheMapper.getGumcheRegist(gumche);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 검체검사결과
	public List<Gumche> getGumchedbList(){ 
		return gumcheMapper.getGumchedbList(); 
	}

}
