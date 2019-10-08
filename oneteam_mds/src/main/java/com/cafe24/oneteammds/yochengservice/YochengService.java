package com.cafe24.oneteammds.yochengservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.yochengmapper.YochengMapper;
import com.cafe24.oneteammds.yochengvo.Yochenglist;

@Service //어노테이션 service 설정
@Transactional //어노테이션 transactional 설정
public class YochengService {
	
	@Autowired //어노테이션 autowired 설정
	private YochengMapper yochengMapper;
	
	//접근 지정자 설정 후  getYochengAdminList 메서드 입력, return 값 입력 // return은 호출된 곳으로 return 된다.
	public List<Yochenglist> getYochengAdminList(){
		
		return yochengMapper.getYochengAdminList();
	}
	
	//접근 지정자 설정 후 getYochengAdminListSearch 메서드 입력, return 값 입력 // return은 호출된 곳으로 return 된다.
	public List<Yochenglist> getYochengAdminListSearch(String sk1, String sv1){
		
		return yochengMapper.getYochengAdminListSearch(sk1, sv1);
	}

}
