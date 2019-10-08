package com.cafe24.oneteammds.susinmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.susinvo.SusinAdmin;

@Mapper //어노테이션 mapper
public interface SusinAdminMapper {
	
	//접근 지정자 설정
	public List<SusinAdmin> getsusinAdminYochengList();
		
}
