package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.DrinkingService;
import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.plistservice.DrinkingpService;

@Controller
public class DrinkingpController {

	@Autowired
	private DrinkingpService drinkingpService;



	// 시스템p


	
	@RequestMapping("/drinkingpList")
	public String getDrinkingpList(Model model) {
		
		model.addAttribute("drinkingpList", drinkingpService.getDrinkingpList());
		
		return "/drinking/drinking/drinkingpList";
	}

	// MDS p - 음주상태 검색
	@PostMapping("drinkingpList")
	public String getDrinkingpList(
								   @RequestParam(value = "start_date") String start_date
								   ,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Drinking> list = drinkingpService.getDrinkingpSearchList(start_date, finish_date);
		model.addAttribute("drinkingpList", list);

		return "/drinking/drinking/drinkingpList";

	}

	

}
