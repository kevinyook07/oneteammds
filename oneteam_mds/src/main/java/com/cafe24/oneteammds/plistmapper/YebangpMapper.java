package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.oneteammds.listvo.Yakmulh;
import com.cafe24.oneteammds.listvo.Yebang;
import com.cafe24.oneteammds.listvo.Yebangh;

@Mapper
public interface YebangpMapper {

	

	// 예방접종내역 regist complete --> MDS p - 예방접종내역
	public List<Yebang> getYebangpList();

	// MDS p - 예방접종내역 검색
	public List<Yebang> getYebangpSearchList( String start_date, String finish_date);


}
