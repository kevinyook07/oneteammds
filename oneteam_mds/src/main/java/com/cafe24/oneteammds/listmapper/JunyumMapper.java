package com.cafe24.oneteammds.listmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Junyumh;

@Mapper
public interface JunyumMapper {
	
	// 병원
	
	// 병원DB - 법정 전염성 감염병
	public List<Junyumh> getJunyumhList();
	
	// 병원DB - 법정 전염성 감염병 --> 법정 전염성 감염병 regist form
	public Junyumh getJunyumhById(String patientId);
	  
	public int getJunyumRegist(Junyum junyum);
	  
	// 시스템DB 
	
	// 법정 전염성 감염병 regist complete --> MDS DB - 법정 전염성 감염병
	public List<Junyum> getJunyumdbList();
	
}
