package com.cafe24.oneteammds.yochengservice;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cafe24.oneteammds.yochengmapper.YochenghospitalMapper;
import com.cafe24.oneteammds.yochengvo.Yochenghospital;



@Service //어노테이션 service 설정
@Transactional //포함된 메소드가 호출 될 경우, PlatformTransactionManager를 사용하여 트랜잭션을 시작하고, 
			   //정상 여부에 따라 Commit 또는 Rollback 한다.
public class YochenghospitalService {
	
	@Autowired  //@Autowired을 통해 SusinHospitalMapper 에 담긴 메서드를 불러오는 과정 susinHospitalMapper 변수설정
	private YochenghospitalMapper yochenghospitalMapper;
	
	//insert 값을 넣는 메서드
	public int yochengHinsert(Yochenghospital Yochenghospital) {
		return yochenghospitalMapper.yochengHinsert(Yochenghospital);
	}
	//특정 아이디 로그인시 list select 조회 
	public List<Yochenghospital> yochengHList(String hospitalId){
		return yochenghospitalMapper.yochengHList(hospitalId);	
	}
	//특정 아이디 항목 선택 후 검색 list select 조회
	public List<Yochenghospital> yochenghSearch(String search1, String search2, String yochengoutHospitalId){
		return yochenghospitalMapper.yochenghSearch(search1, search2, yochengoutHospitalId);
	}
}
