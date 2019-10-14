package com.cafe24.oneteammds.yochengservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	//yochengAdminList출력과 페이지 작업. 접근 지정자 설정 후  getYochengAdminList 메서드 입력, return 값 입력 // return은 호출된 곳으로 return 된다.
	public Map<String, Object> getYochengAdminList(int currentPage){
		
		//페이지 구성할 행의 갯수
		//1~10번까지 페이지가 보임.
		final int ROW_PER_PAGE = 5;
		
		//보여줄 첫번째 페이지번호 초기화
		//1부터 5번까지 보여줌. 3번 클릭시 12~17번까지 보여줌
		int startPageNum = 1;
		
		//보여줄 페이지 번호의 갯수 초기화
		int lastPageNum  =  ROW_PER_PAGE;
		
		//계속 증가되게
		//6번부터 아래 조건문이 실행 됨
		if(currentPage > (ROW_PER_PAGE/2)) {
			startPageNum = currentPage -((lastPageNum/2)-1);
			lastPageNum += (startPageNum-1);
		}
		
		//limit 적용될 값 startRow, 상수ROW_PER_PAGE를 담을 것.
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		
		map.put("startRow", startRow); 
		map.put("rowPerPage", ROW_PER_PAGE); //5개 고정으로 보여줌
		
		//전체행의 갯수를 가져오는 쿼리
		//lastPage를 구하기 위해 전체 행의 갯수를 가져온다
		//double은 소수점 까지 구함
		double yochengAdminListCount = yochengMapper.getYochengAdminListAllCount();
		
		//yochengAdminList는 double소수점까지 구함. 그래서  Math.ceil을 써서 올림 함.
		int lastPage = (int)(Math.ceil(yochengAdminListCount/ROW_PER_PAGE));
		
		if(currentPage >= (lastPage-3)) {
			lastPageNum = lastPage;
		}
		
		

		/* <리스트가 출력 되지 않아 yochengAdminList()로 출력한 작업
		 * List<Yochenglist> list = yochengMapper.yochengAdminList();
		 * resultMap.put("yochengAdminList", list);
		 */
		
		//resultMap 객체를 생성하고 return. return은 호출된 곳으로 return 된다
		Map<String, Object> resultMap = new HashMap<String,Object>();
				
		resultMap.put("list", yochengMapper.yochengAdminList(map));		
		resultMap.put("currentPage", currentPage);
		resultMap.put("lastPage", lastPage);
		resultMap.put("startPageNum", startPageNum);
		resultMap.put("lastPageNum", lastPageNum);
		resultMap.put("currentPage", currentPage);	
		
		return resultMap;
	}
	
	/*페이지 작업을 yochengCode로 하려고 했던 작업 내용
	 * //접근 지정자 설정 후 getYochengCode 메서드 입력, return 값 입력 // return은 호출된 곳으로 return
	 * 된다. public Yochenglist getYochengCode(int yochengCode) {
	 * 
	 * return yochengMapper.getYochengCode(yochengCode); }
	 */
	
	
	//검색. 접근 지정자 설정 후 getYochengAdminListSearch 메서드 입력, return 값 입력 // return은 호출된 곳으로 return 된다.
	public List<Yochenglist> getYochengAdminListSearch(String sk1, String sv1){
		
		return yochengMapper.getYochengAdminListSearch(sk1, sv1);
	}
	
	//MDS 진료 정보 등록. 접근 지정자 설정 후 getYochenglist_ById 메서드 입력, return 값 입력 // return은 호출된 곳으로 return 된다.
	public Yochenglist getYochenglist_ById(String patientId) {
		
		return yochengMapper.getYochenglist_ById(patientId);
	}
	
	
	
	//접근 지정자 설정 후 getYochengAdminInsert 메서드 입력, return 값 입력 // return은 호출된 곳으로 return 된다.
	public int getYochengAdminInsert(Yochenglist yochenglist) {
		
		return yochengMapper.getYochengAdminInsert(yochenglist);
	}
	
	
	
	
	
	

}
