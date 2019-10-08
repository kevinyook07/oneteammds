package com.cafe24.oneteammds.susinmapper;



import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.cafe24.oneteammds.susinvo.SusinHospital;


@Mapper //어노테이션 mapper 설정
public interface SusinHospitalMapper {
	
	//susinHospitalInsert insert interface 
	public int yochengHinsert(SusinHospital SusinHospital);
	
	//susinHospitalList select interface
	public List<SusinHospital> susinHospitalList();
		
}
