package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.PandogMapper;
import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;

@Service
@Transactional
public class PandogService {

	@Autowired
	private PandogMapper pandogMapper;
	
	// 병원
	
	// 병원DB - 영상판독정보
	public List<Pandogh> getPandoghList(){
		return pandogMapper.getPandoghList();
	}
	
	// 병원DB - 영상판독정보 -> 영상판독정보 regist form
	public Pandogh getPandoghById(String patientId) { 
		return pandogMapper.getPandoghById(patientId); 
	}
	
	// 영상판독정보 regist complete
	public int getPandogRegist(Pandog pandog) { 
		return pandogMapper.getPandogRegist(pandog);
	} 
	
	// 시스템 DB 
	
	// MDS DB - 영상판독정보
	public List<Pandog> getPandogdbList(){ 
		return pandogMapper.getPandogdbList(); 
	}
 
}
