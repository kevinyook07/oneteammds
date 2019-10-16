package com.cafe24.oneteammds.yochengmapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


import com.cafe24.oneteammds.yochengvo.Yochenglist;

@Mapper //어노테이션 mapper 설정
public interface YochengMapper {
	
	//전체리스트. 요청 리스트가 출력되지 않아 시도했던 yochengAdminList 전체 출력 코드 작업
	//public List<Yochenglist> yochengAdminList();
	
	//(페이지를 포함)전체 리스트에 map으로 String과 페이지 작업을 위한 Integer 변수선언. getYochengAdminList를 map에 담았음. YochengMapper.xml에서 id값 getYochengAdminList를 받음.
	public List<Yochenglist> yochengAdminList(Map<String, Integer> map);
	
	//페이지 처리를 위한 전체행의 갯수. YochengMapper.xml에서 id값 getYochengAdminListAllCount를 받음.
	public int getYochengAdminListAllCount();
	
	/* 페이지 작업을 yochengCode로 하려고 했던 작업 내용
	* //요청 코드. YochengMapper.xml에서 id값 getYochengCode를 받음. public Yochenglist
	* getYochengCode(int yochengCode);
	*/

	//검색. YochengMapper.xml에서 id값 getYochengAdminListSearch를 받음.
	public List<Yochenglist> getYochengAdminListSearch(String sk1, String sv1);
	
	//MDS 진료 정보 등록. YochengMapper.xml에서 id값 getYochenglist_ById를 받음.
	public Yochenglist getYochenglistById(String patientId);	
	
	
	

	
	
	
}
