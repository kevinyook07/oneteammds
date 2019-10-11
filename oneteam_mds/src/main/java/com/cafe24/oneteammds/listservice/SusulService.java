package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.SusulMapper;
import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Susulh;

@Service
@Transactional
public class SusulService {

	@Autowired
	private SusulMapper susulMapper;
	
	// 병원1
	
	// 병원DB - 수술내역
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 수술내역 리스트  출력 처리
	public List<Susulh> getSusulhList(String hospitalId){
		return susulMapper.getSusulhList(hospitalId);
	}
	
	// 병원DB - 수술내역 -> 수술내역 regist form
	public Susulh getSusulhById(String patientId) { 
		return susulMapper.getSusulhById(patientId); 
	}
	
	// 수술내역 regist complete
	public int getSusulRegist(Susul susul) { 
		return susulMapper.getSusulRegist(susul);
	} 
	
	// 수술내역 검색
		public List<Susulh> getSusulSearchList(String hospitalId, String sk, String sv) {

			List<Susulh> list = susulMapper.getSusulSearchList(hospitalId, sk, sv);

			return list;
		}
	
	// 시스템 DB 
	
	// MDS DB - 수술내역
	public List<Susul> getSusuldbList(){ 
		return susulMapper.getSusuldbList(); 
	}
 
	// MDS DB - 수술내역 삭제
		public int delSusul(String sbCode, String hospitalId, String patientId) {

			return susulMapper.delSusul(sbCode, hospitalId, patientId);
		}
}
