package com.cafe24.oneteammds.listcontroller;

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

@Controller
public class TotalController {

	@Autowired
	private TotalService totalService;

	// 병원

	// 병원 DB 전체리스트

	// 병원 권한 로그인시 입력되는 ID값 받아서 전체 진료정보 리스트 출력 처리
	@RequestMapping("/totalhList")
	public String getTotalList(@RequestParam(value = "hospitalId") String hospitalId, Model model) {

		model.addAttribute("totalhList", totalService.getTotalhList(hospitalId));

		return "/total/totalh/totalhList";
	}

	// 병원 DB 전체 regist
	@RequestMapping("/totalRegist")
	public String getTotalById(@RequestParam(value = "patientId") String patientId,
			@RequestParam(value = "hospitalId") String hospitalId, Model model) {

		model.addAttribute("totalh", totalService.getTotalhById(patientId, hospitalId));

		return "total/totalRegist/totalRegist";
	}

	// 병원DB - 전체 검색
	@PostMapping("/totalhList")
	public String getTotalList(@RequestParam(value = "hospitalId") String hospitalId,
			@RequestParam(value = "sk") String sk, @RequestParam(value = "sv") String sv, Model model) {
		List<Totalh> list = totalService.getTotalSearchList(hospitalId, sk, sv);
		model.addAttribute("totalhList", list);

		return "/total/totalh/totalhList";

	}

	// 시스템DB

	// 시스템 DB 전체리스트
	@RequestMapping("/totalComplete")
	public String getTotalRegist(Total total) {

		totalService.getTotalRegist(total);

		return "/total/totalRegist/totalComplete";
	}

	@RequestMapping("/totaldbList")
	public String getTotaldbList(Model model) {

		model.addAttribute("totaldbList", totalService.getTotaldbList());

		return "/total/total/totaldbList";
	}

	// MDS DB - 전체 검색
	@PostMapping("/totaldbList")
	public String getTotaldbList(@RequestParam(value = "sk") String sk, @RequestParam(value = "sv") String sv,
			Model model) {
		List<Total> list = totalService.getTotaldbSearchList(sk, sv);
		model.addAttribute("totaldbList", list);

		return "/total/total/totaldbList";

	}

	// MDS DB - 전체 삭제
	@GetMapping("/delTotal")
	public String delTotal(@RequestParam(value = "dbCode") String dbCode, Model model) {
		model.addAttribute("dbCode", dbCode);

		return "/total/tdelete/delTotal";
	}

	@PostMapping("/delTotal")
	public String delTotal(@RequestParam(value = "dbCode") String dbCode,
			@RequestParam(value = "hospitalId") String hospitalId, @RequestParam(value = "patientId") String patientId,
			Model model) {
		int result = totalService.delTotal(dbCode, hospitalId, patientId);
		if (result == 0) {
			model.addAttribute("result", "비밀번호가 일치하지 않습니다.");
			model.addAttribute("dbCode", dbCode);
			return "/total/tdelete/delTotal";
		}
		return "redirect:/totaldbList";
	}

	// 진단내역 상세
	@RequestMapping("/jindandbDesc")
	public String getJindanhByCode(@RequestParam(value = "dbCode") String dbCode, Jindan jindan, Model model) {

		totalService.getJindanRegist2(jindan);

		model.addAttribute("jindandbDesc", totalService.getJindandbDesc(dbCode));

		return "jindan/jindan/jindandbDesc";
	}

	// 약물처방내역 상세
	@RequestMapping("/yakmuldbDesc")
	public String getYakmulByCode(@RequestParam(value = "mbCode") String mbCode, Yakmul yakmul, Model model) {

		totalService.getYakmulRegist2(yakmul);

		model.addAttribute("yakmuldbDesc", totalService.getYakmuldbDesc(mbCode));

		return "yakmul/yakmul/yakmuldbDesc";
	}

	// 검체검사결과 상세
	@RequestMapping("/gumchedbDesc")
	public String getGumcheByCode(@RequestParam(value = "strCode") String strCode, Gumche gumche, Model model) {

		totalService.getGumcheRegist2(gumche);

		model.addAttribute("gumchedbDesc", totalService.getGumchedbDesc(strCode));

		return "gumche/gumche/gumchedbDesc";
	}

	// 병리검사결과 상세
	@RequestMapping("/byungridbDesc")
	public String getByungriByCode(@RequestParam(value = "ptrCode") String ptrCode, Byungri byungri, Model model) {

		totalService.getByungriRegist2(byungri);

		model.addAttribute("byungridbDesc", totalService.getByungridbDesc(ptrCode));

		return "byungri/byungri/byungridbDesc";
	}

	// 영상검사결과 상세
	@RequestMapping("/youngsangdbDesc")
	public String getYoungsangByCode(@RequestParam(value = "itrCode") String itrCode, Youngsang youngsang,
			Model model) {

		totalService.getYoungsangRegist2(youngsang);

		model.addAttribute("youngsangdbDesc", totalService.getYoungsangdbDesc(itrCode));

		return "youngsang/youngsang/youngsangdbDesc";
	}

	// 영상판독정보 상세
	@RequestMapping("/pandogdbDesc")
	public String getPandogByCode(@RequestParam(value = "iidCode") String iidCode, Pandog pandog, Model model) {

		totalService.getPandogRegist2(pandog);

		model.addAttribute("pandogdbDesc", totalService.getPandogdbDesc(iidCode));

		return "pandog/pandog/pandogdbDesc";
	}

	// 기능검사결과 상세
	@RequestMapping("/ginuengdbDesc")
	public String getGinuengByCode(@RequestParam(value = "ftrCode") String ftrCode, Ginueng ginueng, Model model) {

		totalService.getGinuengRegist2(ginueng);

		model.addAttribute("ginuengdbDesc", totalService.getGinuengdbDesc(ftrCode));

		return "ginueng/ginueng/ginuengdbDesc";
	}

	// 수술내역 상세
	@RequestMapping("/susuldbDesc")
	public String getSusulByCode(@RequestParam(value = "sbCode") String sbCode, Susul susul, Model model) {

		totalService.getSusulRegist2(susul);

		model.addAttribute("susuldbDesc", totalService.getSusuldbDesc(sbCode));

		return "susul/susul/susuldbDesc";
	}

	// 알러지 및 부작용 상세
	@RequestMapping("/allergydbDesc")
	public String getAllergyByCode(@RequestParam(value = "aseCode") String aseCode, Allergy allergy, Model model) {

		totalService.getAllergyRegist2(allergy);

		model.addAttribute("allergydbDesc", totalService.getAllergydbDesc(aseCode));

		return "allergy/allergy/allergydbDesc";
	}

	// 예방접종내역 상세
	@RequestMapping("/yebangdbDesc")
	public String getYebangByCode(@RequestParam(value = "pibCode") String pibCode, Yebang yebang, Model model) {

		totalService.getYebangRegist2(yebang);

		model.addAttribute("yebangdbDesc", totalService.getYebangdbDesc(pibCode));

		return "yebang/yebang/yebangdbDesc";
	}

	// 생체신호 및 상태 상세
	@RequestMapping("/saengchaedbDesc")
	public String getSaengchaeByCode(@RequestParam(value = "vscCode") String vscCode, Saengchae saengchae,
			Model model) {

		totalService.getSaengchaeRegist2(saengchae);

		model.addAttribute("saengchaedbDesc", totalService.getSaengchaedbDesc(vscCode));

		return "saengchae/saengchae/saengchaedbDesc";
	}

	// 흡연상태 상세
	@RequestMapping("/smokingdbDesc")
	public String getSmokingByCode(@RequestParam(value = "scCode") String scCode, Smoking smoking, Model model) {

		totalService.getSmokingRegist2(smoking);

		model.addAttribute("smokingdbDesc", totalService.getSmokingdbDesc(scCode));

		return "smoking/smoking/smokingdbDesc";
	}

	// 흡연상태 상세
	@RequestMapping("/drinkingdbDesc")
	public String getDrinkingByCode(@RequestParam(value = "dcCode") String dcCode, Drinking drinking, Model model) {

		totalService.getDrinkingRegist2(drinking);

		model.addAttribute("drinkingdbDesc", totalService.getDrinkingdbDesc(dcCode));

		return "drinking/drinking/drinkingdbDesc";
	}

	// 법정 전염성 감염병 상세
	@RequestMapping("/junyumdbDesc")
	public String getJunyumByCode(@RequestParam(value = "lcidCode") String lcidCode, Junyum junyum, Model model) {

		totalService.getJunyumRegist2(junyum);

		model.addAttribute("junyumdbDesc", totalService.getJunyumdbDesc(lcidCode));

		return "junyum/junyum/junyumdbDesc";
	}

	// 전체 확인 replace 일괄처리 및 전체 항목 상세 리스트 출력
	@RequestMapping("/totaldbDesc")
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

		totalService.getJindanRegist2(jindan);
		totalService.getYakmulRegist2(yakmul);
		totalService.getGumcheRegist2(gumche);
		totalService.getByungriRegist2(byungri);
		totalService.getYoungsangRegist2(youngsang);
		totalService.getPandogRegist2(pandog);
		totalService.getGinuengRegist2(ginueng);
		totalService.getSusulRegist2(susul);
		totalService.getAllergyRegist2(allergy);
		totalService.getYebangRegist2(yebang);
		totalService.getSaengchaeRegist2(saengchae);
		totalService.getSmokingRegist2(smoking);
		totalService.getDrinkingRegist2(drinking);
		totalService.getJunyumRegist2(junyum);

		model.addAttribute("totaldbDesc", totalService.getJindandbDesc(dbCode));
		model.addAttribute("totaldbDesc2", totalService.getYakmuldbDesc(mbCode));
		model.addAttribute("totaldbDesc3", totalService.getGumchedbDesc(strCode));
		model.addAttribute("totaldbDesc4", totalService.getByungridbDesc(ptrCode));
		model.addAttribute("totaldbDesc5", totalService.getYoungsangdbDesc(itrCode));
		model.addAttribute("totaldbDesc6", totalService.getPandogdbDesc(iidCode));
		model.addAttribute("totaldbDesc7", totalService.getGinuengdbDesc(ftrCode));
		model.addAttribute("totaldbDesc8", totalService.getSusuldbDesc(sbCode));
		model.addAttribute("totaldbDesc9", totalService.getAllergydbDesc(aseCode));
		model.addAttribute("totaldbDesc10", totalService.getYebangdbDesc(pibCode));
		model.addAttribute("totaldbDesc11", totalService.getSaengchaedbDesc(vscCode));
		model.addAttribute("totaldbDesc12", totalService.getSmokingdbDesc(scCode));
		model.addAttribute("totaldbDesc13", totalService.getDrinkingdbDesc(dcCode));
		model.addAttribute("totaldbDesc14", totalService.getJunyumdbDesc(lcidCode));

		return "total/total/totaldbDesc";
	}

}
