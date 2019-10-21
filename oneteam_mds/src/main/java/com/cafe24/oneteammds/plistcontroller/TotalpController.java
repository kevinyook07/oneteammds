package com.cafe24.oneteammds.plistcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.oneteammds.listservice.TotalService;
import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Smoking;
import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Total;
import com.cafe24.oneteammds.listvo.Totalh;
import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;
import com.cafe24.oneteammds.listvo.Yebang;
import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.plistservice.TotalpService;

@Controller
public class TotalpController {

	@Autowired
	private TotalpService totalpService;



	@RequestMapping("/totalpList")
	public String getTotalpList(Model model) {

		model.addAttribute("totalpList", totalpService.getTotalpList());

		return "/total/total/totalpList";
	}

	// MDS p - 전체 검색
	@PostMapping("/totalpList")
	public String getTotalpList(
								@RequestParam(value = "start_date") String start_date
								,@RequestParam(value = "finish_date") String finish_date,
			Model model) {
		List<Total> list = totalpService.getTotalpSearchList(start_date, finish_date);
		model.addAttribute("totalpList", list);

		return "/total/total/totalpList";

	}

	

	// 진단내역 상세
	@RequestMapping("/jindanpDesc")
	public String getJindanhByCode(@RequestParam(value = "dbCode") String dbCode, Jindan jindan, Model model) {

		totalpService.getJindanRegist2(jindan);

		model.addAttribute("jindanpDesc", totalpService.getJindanpDesc(dbCode));

		return "jindan/jindan/jindanpDesc";
	}

	// 약물처방내역 상세
	@RequestMapping("/yakmulpDesc")
	public String getYakmulByCode(@RequestParam(value = "mbCode") String mbCode, Yakmul yakmul, Model model) {

		totalpService.getYakmulRegist2(yakmul);

		model.addAttribute("yakmulpDesc", totalpService.getYakmulpDesc(mbCode));

		return "yakmul/yakmul/yakmulpDesc";
	}

	// 검체검사결과 상세
	@RequestMapping("/gumchepDesc")
	public String getGumcheByCode(@RequestParam(value = "strCode") String strCode, Gumche gumche, Model model) {

		totalpService.getGumcheRegist2(gumche);

		model.addAttribute("gumchepDesc", totalpService.getGumchepDesc(strCode));

		return "gumche/gumche/gumchepDesc";
	}

	// 병리검사결과 상세
	@RequestMapping("/byungripDesc")
	public String getByungriByCode(@RequestParam(value = "ptrCode") String ptrCode, Byungri byungri, Model model) {

		totalpService.getByungriRegist2(byungri);

		model.addAttribute("byungripDesc", totalpService.getByungripDesc(ptrCode));

		return "byungri/byungri/byungripDesc";
	}

	// 영상검사결과 상세
	@RequestMapping("/youngsangpDesc")
	public String getYoungsangByCode(@RequestParam(value = "itrCode") String itrCode, Youngsang youngsang,
			Model model) {

		totalpService.getYoungsangRegist2(youngsang);

		model.addAttribute("youngsangpDesc", totalpService.getYoungsangpDesc(itrCode));

		return "youngsang/youngsang/youngsangpDesc";
	}

	// 영상판독정보 상세
	@RequestMapping("/pandogpDesc")
	public String getPandogByCode(@RequestParam(value = "iidCode") String iidCode, Pandog pandog, Model model) {

		totalpService.getPandogRegist2(pandog);

		model.addAttribute("pandogpDesc", totalpService.getPandogpDesc(iidCode));

		return "pandog/pandog/pandogpDesc";
	}

	// 기능검사결과 상세
	@RequestMapping("/ginuengpDesc")
	public String getGinuengByCode(@RequestParam(value = "ftrCode") String ftrCode, Ginueng ginueng, Model model) {

		totalpService.getGinuengRegist2(ginueng);

		model.addAttribute("ginuengpDesc", totalpService.getGinuengpDesc(ftrCode));

		return "ginueng/ginueng/ginuengpDesc";
	}

	// 수술내역 상세
	@RequestMapping("/susulpDesc")
	public String getSusulByCode(@RequestParam(value = "sbCode") String sbCode, Susul susul, Model model) {

		totalpService.getSusulRegist2(susul);

		model.addAttribute("susulpDesc", totalpService.getSusulpDesc(sbCode));

		return "susul/susul/susulpDesc";
	}

	// 알러지 및 부작용 상세
	@RequestMapping("/allergypDesc")
	public String getAllergyByCode(@RequestParam(value = "aseCode") String aseCode, Allergy allergy, Model model) {

		totalpService.getAllergyRegist2(allergy);

		model.addAttribute("allergypDesc", totalpService.getAllergypDesc(aseCode));

		return "allergy/allergy/allergypDesc";
	}

	// 예방접종내역 상세
	@RequestMapping("/yebangpDesc")
	public String getYebangByCode(@RequestParam(value = "pibCode") String pibCode, Yebang yebang, Model model) {

		totalpService.getYebangRegist2(yebang);

		model.addAttribute("yebangpDesc", totalpService.getYebangpDesc(pibCode));

		return "yebang/yebang/yebangpDesc";
	}

	// 생체신호 및 상태 상세
	@RequestMapping("/saengchaepDesc")
	public String getSaengchaeByCode(@RequestParam(value = "vscCode") String vscCode, Saengchae saengchae,
			Model model) {

		totalpService.getSaengchaeRegist2(saengchae);

		model.addAttribute("saengchaepDesc", totalpService.getSaengchaepDesc(vscCode));

		return "saengchae/saengchae/saengchaepDesc";
	}

	// 흡연상태 상세
	@RequestMapping("/smokingpDesc")
	public String getSmokingByCode(@RequestParam(value = "scCode") String scCode, Smoking smoking, Model model) {

		totalpService.getSmokingRegist2(smoking);

		model.addAttribute("smokingpDesc", totalpService.getSmokingpDesc(scCode));

		return "smoking/smoking/smokingpDesc";
	}

	// 흡연상태 상세
	@RequestMapping("/drinkingpDesc")
	public String getDrinkingByCode(@RequestParam(value = "dcCode") String dcCode, Drinking drinking, Model model) {

		totalpService.getDrinkingRegist2(drinking);

		model.addAttribute("drinkingpDesc", totalpService.getDrinkingpDesc(dcCode));

		return "drinking/drinking/drinkingpDesc";
	}

	// 법정 전염성 감염병 상세
	@RequestMapping("/junyumpDesc")
	public String getJunyumByCode(@RequestParam(value = "lcidCode") String lcidCode, Junyum junyum, Model model) {

		totalpService.getJunyumRegist2(junyum);

		model.addAttribute("junyumpDesc", totalpService.getJunyumpDesc(lcidCode));

		return "junyum/junyum/junyumpDesc";
	}

	// 전체 확인 replace 일괄처리 및 전체 항목 상세 리스트 출력
	@RequestMapping("/totalpDesc")
	public String getTotalReplace(@RequestParam(value = "dbCode") String dbCode,
			@RequestParam(value = "mbCode") String mbCode, @RequestParam(value = "strCode") String strCode,
			@RequestParam(value = "ptrCode") String ptrCode, @RequestParam(value = "itrCode") String itrCode,
			@RequestParam(value = "iidCode") String iidCode, @RequestParam(value = "ftrCode") String ftrCode,
			@RequestParam(value = "sbCode") String sbCode, @RequestParam(value = "aseCode") String aseCode,
			@RequestParam(value = "pibCode") String pibCode, @RequestParam(value = "vscCode") String vscCode,
			@RequestParam(value = "scCode") String scCode, @RequestParam(value = "dcCode") String dcCode,
			@RequestParam(value = "lcidCode") String lcidCode, Jindan jindan, Yakmul yakmul, Gumche gumche,
			Byungri byungri, Youngsang youngsang, Pandog pandog, Ginueng ginueng, Susul susul, Allergy allergy,
			Yebang yebang, Saengchae saengchae, Smoking smoking, Drinking drinking, Junyum junyum, Model model) {

		totalpService.getJindanRegist2(jindan);
		totalpService.getYakmulRegist2(yakmul);
		totalpService.getGumcheRegist2(gumche);
		totalpService.getByungriRegist2(byungri);
		totalpService.getYoungsangRegist2(youngsang);
		totalpService.getPandogRegist2(pandog);
		totalpService.getGinuengRegist2(ginueng);
		totalpService.getSusulRegist2(susul);
		totalpService.getAllergyRegist2(allergy);
		totalpService.getYebangRegist2(yebang);
		totalpService.getSaengchaeRegist2(saengchae);
		totalpService.getSmokingRegist2(smoking);
		totalpService.getDrinkingRegist2(drinking);
		totalpService.getJunyumRegist2(junyum);

		model.addAttribute("totalpDesc", totalpService.getJindanpDesc(dbCode));
		model.addAttribute("totalpDesc2", totalpService.getYakmulpDesc(mbCode));
		model.addAttribute("totalpDesc3", totalpService.getGumchepDesc(strCode));
		model.addAttribute("totalpDesc4", totalpService.getByungripDesc(ptrCode));
		model.addAttribute("totalpDesc5", totalpService.getYoungsangpDesc(itrCode));
		model.addAttribute("totalpDesc6", totalpService.getPandogpDesc(iidCode));
		model.addAttribute("totalpDesc7", totalpService.getGinuengpDesc(ftrCode));
		model.addAttribute("totalpDesc8", totalpService.getSusulpDesc(sbCode));
		model.addAttribute("totalpDesc9", totalpService.getAllergypDesc(aseCode));
		model.addAttribute("totalpDesc10", totalpService.getYebangpDesc(pibCode));
		model.addAttribute("totalpDesc11", totalpService.getSaengchaepDesc(vscCode));
		model.addAttribute("totalpDesc12", totalpService.getSmokingpDesc(scCode));
		model.addAttribute("totalpDesc13", totalpService.getDrinkingpDesc(dcCode));
		model.addAttribute("totalpDesc14", totalpService.getJunyumpDesc(lcidCode));

		return "total/total/totalpDesc";
	}

}
