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
	
	// 병원 권한 로그인시 입력되는 ID값 받아서 예방접종내역 리스트  출력 처리
	public List<Yebangh> getYebanghList(String hospitalId){
		return yebangMapper.getYebanghList(hospitalId);
	}
	
	// 병원DB - 예방접종내역 -> 예방접종내역 regist form
	public Yebangh getYebanghById(String patientId) { 
		return yebangMapper.getYebanghById(patientId); 
	}
	
	// 예방접종내역 regist complete
	public int getYebangRegist(Yebang yebang) { 
		return yebangMapper.getYebangRegist(yebang);
	} 
	
	// 예방접종내역 검색
		public List<Yebangh> getYebangSearchList(String hospitalId, String sk1, String sk2, String sv1, String sv2, String start_date, String finish_date) {

			List<Yebangh> list = yebangMapper.getYebangSearchList(hospitalId, sk1, sk2, sv1, sv2, start_date, finish_date);

			return list;
		}
	
	// 시스템 DB 
	
	// MDS DB - 예방접종내역
	public List<Yebang> getYebangdbList(){ 
		return yebangMapper.getYebangdbList(); 
	}
	
	// MDS DB - 예방접종내역 검색
			public List<Yebang> getYebangdbSearchList(String sk1, String sk2, String sk3, String sv1, String sv2, String sv3, String start_date, String finish_date) {

				List<Yebang> list = yebangMapper.getYebangdbSearchList(sk1, sk2, sk3, sv1, sv2, sv3, start_date, finish_date);

				return list;
			}
	
	// MDS DB - 예방접종내역 삭제
		public int delYebang(String pibCode, String hospitalId, String patientId) {

			return yebangMapper.delYebang(pibCode, hospitalId, patientId);
		}

}
