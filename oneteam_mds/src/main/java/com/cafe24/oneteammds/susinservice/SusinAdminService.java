package com.cafe24.oneteammds.susinservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.susinmapper.SusinAdminMapper;
import com.cafe24.oneteammds.susinvo.SusinAdmin;

@Service //어노테이션 service
@Transactional //어노테이션 transactional
public class SusinAdminService {
	
	@Autowired //어노테이션 autowired
	private SusinAdminMapper susinAdminMapper;
	
	//접근 지정자 설정 //return은 호출된 고으로 return된다
	public List<SusinAdmin> getsusinAdminYochengList(){
		
		return susinAdminMapper.getsusinAdminYochengList();
	}

}
