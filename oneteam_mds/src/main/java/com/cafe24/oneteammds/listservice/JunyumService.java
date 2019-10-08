package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.JunyumMapper;
import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Junyumh;

@Service
@Transactional
public class JunyumService {

	@Autowired
	private JunyumMapper junyumMapper;
	
	// 병원
	
	// 병원DB - 법정 전염성 감염병
	public List<Junyumh> getJunyumhList(){
		return junyumMapper.getJunyumhList();
	}
	
	// 병원DB - 법정 전염성 감염병 -> 법정 전염성 감염병 regist form
	public Junyumh getJunyumhById(String patientId) { 
		return junyumMapper.getJunyumhById(patientId); 
	}
	
	// 법정 전염성 감염병 regist complete
	public int getJunyumRegist(Junyum junyum) { 
		return junyumMapper.getJunyumRegist(junyum);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 법정 전염성 감염병
	public List<Junyum> getJunyumdbList(){ 
		return junyumMapper.getJunyumdbList(); 
	}
	
}
