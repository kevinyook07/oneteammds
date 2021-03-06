package com.cafe24.oneteammds.yochengmapper;



import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cafe24.oneteammds.yochengvo.Yochenghospital;


@Mapper //어노테이션 mapper 설정
public interface YochenghospitalMapper {
	
	//yochengHinsert insert interface 
	public int yochengHinsert(Yochenghospital Yochenghospital);
	
	//yochengHList select interface
	public List<Yochenghospital> yochengHList(String yochengoutHospitalId);
		
	//yochenghSearch select interface
	public List<Yochenghospital> yochenghSearch(String search1, String search2, String yochengoutHospitalId);
}
