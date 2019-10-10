package com.cafe24.oneteammds.yochengmapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.yochengvo.Yochenglist;

@Mapper //어노테이션 mapper 설정
public interface YochengMapper {
	
	//전체 리스트. getYochengAdminList를 map에 담았음. YochengMapper.xml에서 id값 getYochengAdminList를 받음.
	public List<Yochenglist> getYochengAdminList(Map<String, Integer> map);
	
	//페이지 처리를 위한 전체행의 갯수. YochengMapper.xml에서 id값 getYochengAdminListAllCount를 받음.
	public int getYochengAdminListAllCount();
	
	//요청 코드. YochengMapper.xml에서 id값 getYochengCode를 받음.
	public Yochenglist getYochengCode(int yochengCode);

	//YochengMapper.xml에서 id값 getYochengAdminListSearch를 받음.
	public List<Yochenglist> getYochengAdminListSearch(String sk1, String sv1);
	
	//YochengMapper.xml에서 id값 getYochenglist_ById를 받음.
	public Yochenglist getYochenglist_ById(String patientId);	
	
	//YochengMapper.xml에서 id값 getYochengAdminInsert를 받음.
	public int getYochengAdminInsert(Yochenglist yochenglist);
	
	
	
	
}
