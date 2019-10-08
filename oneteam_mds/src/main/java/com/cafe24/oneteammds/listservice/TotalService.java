package com.cafe24.oneteammds.listservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.oneteammds.listmapper.TotalMapper;
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

@Service
@Transactional
public class TotalService {

	@Autowired
	private TotalMapper totalMapper;
	
	// 병원
	public List<Totalh> getTotalhList(){
		return totalMapper.getTotalhList();
	}
	
	public Totalh getTotalhById(String patientId, String hospitalId) { 
		return totalMapper.getTotalhById(patientId, hospitalId); 
	}
	  
	public int getTotalRegist(Total total) {
		return totalMapper.getTotalRegist(total);
	}
	
	//시스템 DB 
	public List<Total> getTotaldbList(){ 
		return totalMapper.getTotaldbList(); 
	}
	
	// 진단내역 상세
	public Jindanh getJindanhByCode(String dbCode) {
		return totalMapper.getJindanhByCode(dbCode);
	}
	public int getJindanRegist2(Jindan jindan) {
		return totalMapper.getJindanRegist2(jindan);
	}
	
	public Jindan getJindandbDesc(String dbCode){
		return totalMapper.getJindandbDesc(dbCode);
	}
	
	// 약물처방내역 상세
	public Yakmulh getYakmulhByCode(String mbCode) {
		return totalMapper.getYakmulhByCode(mbCode);
	}
	
	public int getYakmulRegist2(Yakmul yakmul) {
		return totalMapper.getYakmulRegist2(yakmul);
	}
	
	public Yakmul getYakmuldbDesc(String mbCode){
		return totalMapper.getYakmuldbDesc(mbCode);
	}
	
	// 검체검사결과 상세
	public Gumcheh getGumchehByCode(String strCode) {
		return totalMapper.getGumchehByCode(strCode);
	}

	public int getGumcheRegist2(Gumche gumche) {
		return totalMapper.getGumcheRegist2(gumche);
	}

	public Gumche getGumchedbDesc(String strCode) {
		return totalMapper.getGumchedbDesc(strCode);
	}
	
	// 검체검사결과 상세
	public Byungrih getByungrihByCode(String ptrCode) {
		return totalMapper.getByungrihByCode(ptrCode);
	}

	public int getByungriRegist2(Byungri byungri) {
		return totalMapper.getByungriRegist2(byungri);
	}

	public Byungri getByungridbDesc(String ptrCode) {
		return totalMapper.getByungridbDesc(ptrCode);
	}
	
	// 영상검사결과 상세
	public Youngsangh getYoungsanghByCode(String itrCode) {
		return totalMapper.getYoungsanghByCode(itrCode);
	}

	public int getYoungsangRegist2(Youngsang youngsang) {
		return totalMapper.getYoungsangRegist2(youngsang);
	}

	public Youngsang getYoungsangdbDesc(String itrCode) {
		return totalMapper.getYoungsangdbDesc(itrCode);
	}
	
	// 영상판독정보 상세
	public Pandogh getPandoghByCode(String iidCode) {
		return totalMapper.getPandoghByCode(iidCode);
	}

	public int getPandogRegist2(Pandog pandog) {
		return totalMapper.getPandogRegist2(pandog);
	}

	public Pandog getPandogdbDesc(String iidCode) {
		return totalMapper.getPandogdbDesc(iidCode);
	}
	
	// 기능검사결과 상세
	public Ginuengh getGinuenghByCode(String ftrCode) {
		return totalMapper.getGinuenghByCode(ftrCode);
	}

	public int getGinuengRegist2(Ginueng ginueng) {
		return totalMapper.getGinuengRegist2(ginueng);
	}

	public Ginueng getGinuengdbDesc(String ftrCode) {
		return totalMapper.getGinuengdbDesc(ftrCode);
	}
	
	// 수술내역 상세
	public Susulh getSusulhByCode(String sbCode) {
		return totalMapper.getSusulhByCode(sbCode);
	}

	public int getSusulRegist2(Susul susul) {
		return totalMapper.getSusulRegist2(susul);
	}

	public Susul getSusuldbDesc(String sbCode) {
		return totalMapper.getSusuldbDesc(sbCode);
	}
	
	// 알러지 및 부작용 상세
	public Allergyh getAllergyhByCode(String aseCode) {
		return totalMapper.getAllergyhByCode(aseCode);
	}

	public int getAllergyRegist2(Allergy allergy) {
		return totalMapper.getAllergyRegist2(allergy);
	}

	public Allergy getAllergydbDesc(String aseCode) {
		return totalMapper.getAllergydbDesc(aseCode);
	}
	
	// 예방접종내역 상세
	public Yebangh getYebanghByCode(String pibCode) {
		return totalMapper.getYebanghByCode(pibCode);
	}

	public int getYebangRegist2(Yebang yebang) {
		return totalMapper.getYebangRegist2(yebang);
	}

	public Yebang getYebangdbDesc(String pibCode) {
		return totalMapper.getYebangdbDesc(pibCode);
	}
	
	// 생체신호 및 상태 상세
	public Saengchaeh getSaengchaehByCode(String vscCode) {
		return totalMapper.getSaengchaehByCode(vscCode);
	}

	public int getSaengchaeRegist2(Saengchae saengchae) {
		return totalMapper.getSaengchaeRegist2(saengchae);
	}

	public Saengchae getSaengchaedbDesc(String vscCode) {
		return totalMapper.getSaengchaedbDesc(vscCode);
	}
	
	// 흡연상태 상세
	public Smokingh getSmokinghByCode(String scCode) {
		return totalMapper.getSmokinghByCode(scCode);
	}

	public int getSmokingRegist2(Smoking smoking) {
		return totalMapper.getSmokingRegist2(smoking);
	}

	public Smoking getSmokingdbDesc(String scCode) {
		return totalMapper.getSmokingdbDesc(scCode);
	}
	
	// 음주상태 상세
	public Drinkingh getDrinkinghByCode(String dcCode) {
		return totalMapper.getDrinkinghByCode(dcCode);
	}

	public int getDrinkingRegist2(Drinking drinking) {
		return totalMapper.getDrinkingRegist2(drinking);
	}

	public Drinking getDrinkingdbDesc(String dcCode) {
		return totalMapper.getDrinkingdbDesc(dcCode);
	}
	
	// 법정 전염성 감염병 상세
	public Junyumh getJunyumhByCode(String lcidCode) {
		return totalMapper.getJunyumhByCode(lcidCode);
	}

	public int getJunyumRegist2(Junyum junyum) {
		return totalMapper.getJunyumRegist2(junyum);
	}

	public Junyum getJunyumdbDesc(String lcidCode) {
		return totalMapper.getJunyumdbDesc(lcidCode);
	}
	
	public Total getTotalReplace(String dbCode, String mbCode, String strCode, String ptrCode
							   , String itrCode, String iidCode, String ftrCode, String sbCode
							   , String aseCode, String pibCode, String vscCode, String scCode
							   , String dcCode, String lcidCode) {
		return totalMapper.getTotalReplace(dbCode, mbCode, strCode, ptrCode
										 , itrCode, iidCode, ftrCode, sbCode
										 , aseCode, pibCode, vscCode, scCode
										 , dcCode, lcidCode);
	}
	
}
