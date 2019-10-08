package com.cafe24.oneteammds.yochengmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.yochengvo.Yochenglist;

@Mapper //어노테이션 mapper 설정
public interface YochengMapper {
	
	//YochengMapper.xml에서 id값 getYochengAdminList를 받음.
	public List<Yochenglist> getYochengAdminList();

	//YochengMapper.xml에서 id값 getYochengAdminListSearch를 받음.
	public List<Yochenglist> getYochengAdminListSearch(String sk1, String sv1);
	
	
}
