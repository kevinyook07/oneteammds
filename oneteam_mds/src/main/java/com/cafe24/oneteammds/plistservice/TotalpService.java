package com.cafe24.oneteammds.plistservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listvo.Allergy;
import com.cafe24.oneteammds.listvo.Allergyh;
import com.cafe24.oneteammds.listvo.Byungri;
import com.cafe24.oneteammds.listvo.Byungrih;
import com.cafe24.oneteammds.listvo.Drinking;
import com.cafe24.oneteammds.listvo.Drinkingh;
import com.cafe24.oneteammds.listvo.Ginueng;
import com.cafe24.oneteammds.listvo.Ginuengh;
import com.cafe24.oneteammds.listvo.Gumche;
import com.cafe24.oneteammds.listvo.Gumcheh;
import com.cafe24.oneteammds.listvo.Jindan;
import com.cafe24.oneteammds.listvo.Jindanh;
import com.cafe24.oneteammds.listvo.Junyum;
import com.cafe24.oneteammds.listvo.Junyumh;
import com.cafe24.oneteammds.listvo.Pandog;
import com.cafe24.oneteammds.listvo.Pandogh;
import com.cafe24.oneteammds.listvo.Saengchae;
import com.cafe24.oneteammds.listvo.Saengchaeh;
import com.cafe24.oneteammds.listvo.Smoking;
import com.cafe24.oneteammds.listvo.Smokingh;
import com.cafe24.oneteammds.listvo.Susul;
import com.cafe24.oneteammds.listvo.Susulh;
import com.cafe24.oneteammds.listvo.Total;
import com.cafe24.oneteammds.listvo.Totalh;
import com.cafe24.oneteammds.listvo.Yakmul;
import com.cafe24.oneteammds.listvo.Yakmulh;
import com.cafe24.oneteammds.listvo.Yebang;
import com.cafe24.oneteammds.listvo.Yebangh;
import com.cafe24.oneteammds.listvo.Youngsang;
import com.cafe24.oneteammds.listvo.Youngsangh;
import com.cafe24.oneteammds.plistmapper.TotalpMapper;

@Service
@Transactional
public class TotalpService {

	@Autowired
	private TotalpMapper totalpMapper;

	// 환자 - 전체
	public List<Total> getTotalpList() {
		return totalpMapper.getTotalpList();
	}

	// 환자 - 전체 검색
	public List<Total> getTotalpSearchList(String start_date, String finish_date) {
		List<Total> list = totalpMapper.getTotalpSearchList(start_date, finish_date);

		return list;
	}

	// 진단내역 상세
	public Jindanh getJindanhByCode(String dbCode) {
		return totalpMapper.getJindanhByCode(dbCode);
	}

	public int getJindanRegist2(Jindan jindan) {
		return totalpMapper.getJindanRegist2(jindan);
	}

	public Jindan getJindanpDesc(String dbCode) {
		return totalpMapper.getJindanpDesc(dbCode);
	}

	// 약물처방내역 상세
	public Yakmulh getYakmulhByCode(String mbCode) {
		return totalpMapper.getYakmulhByCode(mbCode);
	}

	public int getYakmulRegist2(Yakmul yakmul) {
		return totalpMapper.getYakmulRegist2(yakmul);
	}

	public Yakmul getYakmulpDesc(String mbCode) {
		return totalpMapper.getYakmulpDesc(mbCode);
	}

	// 검체검사결과 상세
	public Gumcheh getGumchehByCode(String strCode) {
		return totalpMapper.getGumchehByCode(strCode);
	}

	public int getGumcheRegist2(Gumche gumche) {
		return totalpMapper.getGumcheRegist2(gumche);
	}

	public Gumche getGumchepDesc(String strCode) {
		return totalpMapper.getGumchepDesc(strCode);
	}

	// 검체검사결과 상세
	public Byungrih getByungrihByCode(String ptrCode) {
		return totalpMapper.getByungrihByCode(ptrCode);
	}

	public int getByungriRegist2(Byungri byungri) {
		return totalpMapper.getByungriRegist2(byungri);
	}

	public Byungri getByungripDesc(String ptrCode) {
		return totalpMapper.getByungripDesc(ptrCode);
	}

	// 영상검사결과 상세
	public Youngsangh getYoungsanghByCode(String itrCode) {
		return totalpMapper.getYoungsanghByCode(itrCode);
	}

	public int getYoungsangRegist2(Youngsang youngsang) {
		return totalpMapper.getYoungsangRegist2(youngsang);
	}

	public Youngsang getYoungsangpDesc(String itrCode) {
		return totalpMapper.getYoungsangpDesc(itrCode);
	}

	// 영상판독정보 상세
	public Pandogh getPandoghByCode(String iidCode) {
		return totalpMapper.getPandoghByCode(iidCode);
	}

	public int getPandogRegist2(Pandog pandog) {
		return totalpMapper.getPandogRegist2(pandog);
	}

	public Pandog getPandogpDesc(String iidCode) {
		return totalpMapper.getPandogpDesc(iidCode);
	}

	// 기능검사결과 상세
	public Ginuengh getGinuenghByCode(String ftrCode) {
		return totalpMapper.getGinuenghByCode(ftrCode);
	}

	public int getGinuengRegist2(Ginueng ginueng) {
		return totalpMapper.getGinuengRegist2(ginueng);
	}

	public Ginueng getGinuengpDesc(String ftrCode) {
		return totalpMapper.getGinuengpDesc(ftrCode);
	}

	// 수술내역 상세
	public Susulh getSusulhByCode(String sbCode) {
		return totalpMapper.getSusulhByCode(sbCode);
	}

	public int getSusulRegist2(Susul susul) {
		return totalpMapper.getSusulRegist2(susul);
	}

	public Susul getSusulpDesc(String sbCode) {
		return totalpMapper.getSusulpDesc(sbCode);
	}

	// 알러지 및 부작용 상세
	public Allergyh getAllergyhByCode(String aseCode) {
		return totalpMapper.getAllergyhByCode(aseCode);
	}

	public int getAllergyRegist2(Allergy allergy) {
		return totalpMapper.getAllergyRegist2(allergy);
	}

	public Allergy getAllergypDesc(String aseCode) {
		return totalpMapper.getAllergypDesc(aseCode);
	}

	// 예방접종내역 상세
	public Yebangh getYebanghByCode(String pibCode) {
		return totalpMapper.getYebanghByCode(pibCode);
	}

	public int getYebangRegist2(Yebang yebang) {
		return totalpMapper.getYebangRegist2(yebang);
	}

	public Yebang getYebangpDesc(String pibCode) {
		return totalpMapper.getYebangpDesc(pibCode);
	}

	// 생체신호 및 상태 상세
	public Saengchaeh getSaengchaehByCode(String vscCode) {
		return totalpMapper.getSaengchaehByCode(vscCode);
	}

	public int getSaengchaeRegist2(Saengchae saengchae) {
		return totalpMapper.getSaengchaeRegist2(saengchae);
	}

	public Saengchae getSaengchaepDesc(String vscCode) {
		return totalpMapper.getSaengchaepDesc(vscCode);
	}

	// 흡연상태 상세
	public Smokingh getSmokinghByCode(String scCode) {
		return totalpMapper.getSmokinghByCode(scCode);
	}

	public int getSmokingRegist2(Smoking smoking) {
		return totalpMapper.getSmokingRegist2(smoking);
	}

	public Smoking getSmokingpDesc(String scCode) {
		return totalpMapper.getSmokingpDesc(scCode);
	}

	// 음주상태 상세
	public Drinkingh getDrinkinghByCode(String dcCode) {
		return totalpMapper.getDrinkinghByCode(dcCode);
	}

	public int getDrinkingRegist2(Drinking drinking) {
		return totalpMapper.getDrinkingRegist2(drinking);
	}

	public Drinking getDrinkingpDesc(String dcCode) {
		return totalpMapper.getDrinkingpDesc(dcCode);
	}

	// 법정 전염성 감염병 상세
	public Junyumh getJunyumhByCode(String lcidCode) {
		return totalpMapper.getJunyumhByCode(lcidCode);
	}

	public int getJunyumRegist2(Junyum junyum) {
		return totalpMapper.getJunyumRegist2(junyum);
	}

	public Junyum getJunyumpDesc(String lcidCode) {
		return totalpMapper.getJunyumpDesc(lcidCode);
	}

	public Total getTotalReplace(String dbCode, String mbCode, String strCode, String ptrCode, String itrCode,
			String iidCode, String ftrCode, String sbCode, String aseCode, String pibCode, String vscCode,
			String scCode, String dcCode, String lcidCode) {
		return totalpMapper.getTotalReplace(dbCode, mbCode, strCode, ptrCode, itrCode, iidCode, ftrCode, sbCode,
				aseCode, pibCode, vscCode, scCode, dcCode, lcidCode);
	}

}
