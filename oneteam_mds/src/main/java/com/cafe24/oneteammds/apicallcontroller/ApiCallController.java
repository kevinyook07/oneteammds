package com.cafe24.oneteammds.apicallcontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiCallController {
	
	//final은 상속불가 또는 변할 수 없는 상수 선언에 사용 // apiUrl은 변할 수 없다
	private final String apiUrl = "http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp";
		
	@RequestMapping("/apiCall")
	public String apiCall() {
		return "/api/apiCall";
	}

	
	@RequestMapping(value="/apiCallProcess", produces="application/json")
	public @ResponseBody List<Map<String,Object>> apiCallProcess(@RequestParam(value="stnId", defaultValue = "108", required = false) String stnId) {
		System.out.println(stnId + "<- stnId");
		
		List<Map<String,Object>> apiList = new ArrayList<Map<String,Object>>();
		
		
		try {
			Document doc = Jsoup.connect(apiUrl).data("stnId", stnId).get(); //jsoup-xml 패싱
			
			Elements locations = doc.select("location"); //패턴확인
			
			for(int i=0; i<locations.size(); i++) {
				Map<String,Object> locationMap = new HashMap<String,Object>();
 				Element location = locations.get(i);
				Elements datas = location.select("data");
				
				String city = location.select("city").text();
				
				locationMap.put("city", city);
				
				List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();				
				for(int d=0; d<datas.size(); d++) {
					Map<String,Object> dataMap = new HashMap<String,Object>();					
					Element data = datas.get(d);					
					String time = data.select("tmEf").text(); //패턴확인
					String content = data.select("wf").text();
										
					dataMap.put("time", time);
					dataMap.put("content", content);
					
					dataList.add(dataMap);					
				}
				
				locationMap.put("dataList", dataList);
				
				apiList.add(locationMap);
			}
			
			System.out.println(locations.html());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return apiList;
	}

}

	
	
	

