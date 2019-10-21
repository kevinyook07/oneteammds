package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.YoungsangService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.listvo.Youngsangh;
import com.cafe24.oneteammds.plistservice.YoungsangpService;

@Controller
public class YoungsangpController {

	@Autowired
	private YoungsangpService youngsangpService;

	// 환자 - 영상검사결과 리스트
	@RequestMapping("/youngsangpList")
	public String getYoungsangpList(Model model) {

		model.addAttribute("youngsangpList", youngsangpService.getYoungsangpList());

		return "/youngsang/youngsang/youngsangpList";
	}

	// 환자 - 영상검사결과 검색
	@PostMapping("/youngsangpList")
	public String getYoungsangpList(@RequestParam(value = "start_date") String start_date,
			@RequestParam(value = "finish_date") String finish_date, Model model) {
		List<Youngsang> list = youngsangpService.getYoungsangpSearchList(start_date, finish_date);
		model.addAttribute("youngsangpList", list);

		return "/youngsang/youngsang/youngsangpList";
	}

}
