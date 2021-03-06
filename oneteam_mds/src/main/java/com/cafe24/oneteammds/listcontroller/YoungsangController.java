package com.cafe24.oneteammds.listcontroller;

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

@Controller
public class YoungsangController {

	@Autowired
	private YoungsangService youngsangService;

	// 병원

	// 병원DB - 영상검사결과

	// 병원 권한 로그인시 입력되는 ID값 받아서 영상검사결과 리스트 출력 처리
	@RequestMapping("/youngsanghList")
	public String getYoungsangList(@RequestParam(value = "hospitalId") String hospitalId, Model model) {

		model.addAttribute("youngsanghList", youngsangService.getYoungsanghList(hospitalId));

		return "/youngsang/youngsangh/youngsanghList";
	}

	// 병원DB - 영상검사결과 --> 영상검사결과 regist form
	@RequestMapping("/youngsangRegist")
	public String getYoungsanghById(@RequestParam(value = "patientId") String patientId, Model model) {

		model.addAttribute("youngsangh", youngsangService.getYoungsanghById(patientId));

		return "youngsang/youngsangRegist/youngsangRegist";
	}

	// 병원DB - 영상검사결과 검색
	@PostMapping("/youngsanghList")
	public String getYoungsangList(@RequestParam(value = "hospitalId") String hospitalId
								  ,@RequestParam(value = "sk1") String sk1
								  ,@RequestParam(value = "sk2") String sk2
							   	  ,@RequestParam(value = "sv1") String sv1
							   	  ,@RequestParam(value = "sv2") String sv2
								  ,@RequestParam(value = "start_date") String start_date
								  ,@RequestParam(value = "finish_date") String finish_date
								  , Model model) {
		List<Youngsangh> list = youngsangService.getYoungsangSearchList(hospitalId, sk1, sk2, sv1, sv2, start_date, finish_date);
		model.addAttribute("youngsanghList", list);

		return "/youngsang/youngsangh/youngsanghList";
	}

	// 시스템DB

	// 영상검사결과 regist complete --> MDS DB - 영상검사결과
	@RequestMapping("/youngsangComplete")
	public String getYoungsangRegist(Youngsang youngsang) {

		youngsangService.getYoungsangRegist(youngsang);

		return "/youngsang/youngsangRegist/youngsangComplete";
	}

	// MDS DB - 영상검사결과 리스트
	@RequestMapping("/youngsangdbList")
	public String getYoungsangdbList(Model model) {

		model.addAttribute("youngsangdbList", youngsangService.getYoungsangdbList());

		return "/youngsang/youngsang/youngsangdbList";
	}

	// MDS DB - 영상검사결과 검색
	@PostMapping("/youngsangdbList")
	public String getYoungsangdbList(@RequestParam(value = "sk1") String sk1
								    ,@RequestParam(value = "sk2") String sk2
								    ,@RequestParam(value = "sk3") String sk3
								   	,@RequestParam(value = "sv1") String sv1
								   	,@RequestParam(value = "sv2") String sv2
								   	,@RequestParam(value = "sv3") String sv3
									,@RequestParam(value = "start_date") String start_date
									,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Youngsang> list = youngsangService.getYoungsangdbSearchList(sk1, sk2, sk3, sv1, sv2, sv3, start_date, finish_date);
		model.addAttribute("youngsangdbList", list);

		return "/youngsang/youngsang/youngsangdbList";
	}

	// MDS DB - 영상검사결과 삭제
	@GetMapping("/delYoungsang")
	public String delYoungsang(@RequestParam(value = "itrCode") String itrCode, Model model) {
		model.addAttribute("itrCode", itrCode);

		return "youngsang/ydelete/delYoungsang";
	}

	@PostMapping("/delYoungsang")
	public String delYoungsang(@RequestParam(value = "itrCode") String itrCode,
			@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
			Model model) {
		int result = youngsangService.delYoungsang(itrCode, hospitalId, patientId);
		if (result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다..");
			model.addAttribute("itrCode", itrCode);
			return "/youngsang/ydelete/delYoungsang";
		}
		return "redirect:/youngsangdbList";

	}

}
