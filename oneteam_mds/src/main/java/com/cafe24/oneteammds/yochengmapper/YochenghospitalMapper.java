package com.cafe24.oneteammds.yochengmapper;



import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cafe24.oneteammds.yochengvo.Yochenghospital;


@Mapper //어노테이션 mapper 설정
public interface YochenghospitalMapper {
	
	//susinHospitalInsert insert interface 
	public int yochengHinsert(Yochenghospital Yochenghospital);
	
	//susinHospitalList select interface
	public List<Yochenghospital> yochengHList(String yochengoutHospitalId);
		
}
