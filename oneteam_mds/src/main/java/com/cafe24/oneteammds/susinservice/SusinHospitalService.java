package com.cafe24.oneteammds.susinservice;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cafe24.oneteammds.susinmapper.SusinHospitalMapper;
import com.cafe24.oneteammds.susinvo.SusinHospital;



@Service //어노테이션 service 설정
@Transactional //포함된 메소드가 호출 될 경우, PlatformTransactionManager를 사용하여 트랜잭션을 시작하고, 
			   //정상 여부에 따라 Commit 또는 Rollback 한다.
public class SusinHospitalService {
	
	@Autowired  //@Autowired을 통해 SusinHospitalMapper 에 담긴 메서드를 불러오는 과정 susinHospitalMapper 변수설정
	private SusinHospitalMapper susinHospitalMapper;
	
	//insert 값을 넣는 메서드
	public int yochengHinsert(SusinHospital SusinHospital) {
		return susinHospitalMapper.yochengHinsert(SusinHospital);
	}
	//select 조회 메서드
	public List<SusinHospital> susinHospitalList(){
		return susinHospitalMapper.susinHospitalList();
	}
}
