package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.YebangMapper;
import com.cafe24.oneteammds.listvo.Yebang;
import com.cafe24.oneteammds.listvo.Yebangh;
import com.cafe24.oneteammds.plistmapper.YebangpMapper;

@Service
@Transactional
public class YebangpService {

	@Autowired
	private YebangpMapper yebangpMapper;
	
	
	
	// MDS p - 예방접종내역
	public List<Yebang> getYebangpList(){ 
		return yebangpMapper.getYebangpList(); 
	}
	
	// MDS p - 예방접종내역 검색
			public List<Yebang> getYebangpSearchList(String start_date, String finish_date) {

				List<Yebang> list = yebangpMapper.getYebangpSearchList(start_date, finish_date);

				return list;
			}
	
	

}
