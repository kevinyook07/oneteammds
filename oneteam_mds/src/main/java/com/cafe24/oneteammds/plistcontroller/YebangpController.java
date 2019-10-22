package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.YebangService;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Yebang;
import com.cafe24.oneteammds.listvo.Yebangh;
import com.cafe24.oneteammds.plistservice.YebangpService;

@Controller
public class YebangpController {

	@Autowired
	private YebangpService yebangpService;

	// 환자 - 예방접종내역 리스트
	@RequestMapping("/yebangpList")
	public String getYebangpList(Model model) {

		model.addAttribute("yebangpList", yebangpService.getYebangpList());

		return "/yebang/yebang/yebangpList";
	}

	// 환자 - 예방접종내역 검색
	@PostMapping("/yebangpList")
	public String getYebangpList(@RequestParam(value = "start_date") String start_date,
			@RequestParam(value = "finish_date") String finish_date, Model model) {
		List<Yebang> list = yebangpService.getYebangpSearchList(start_date, finish_date);
		model.addAttribute("yebangpList", list);

		return "/yebang/yebang/yebangpList";
	}

}
