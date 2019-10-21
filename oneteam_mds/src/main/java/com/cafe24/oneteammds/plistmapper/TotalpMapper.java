package com.cafe24.oneteammds.plistmapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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

@Mapper
public interface TotalpMapper {
	
	
	
    // 시스템 p 전체리스트
	public List<Total> getTotalpList();

	// MDS p - 전체 검색
	public List<Total> getTotalpSearchList( String start_date, String finish_date);

	
	
	// 진단내역 상세
	public Jindanh getJindanhByCode(String dbCode);
	
	public int getJindanRegist2(Jindan jindan);
	  
	public Jindan getJindanpDesc(String dbCode);
	
	// 약물처방내역 상세
	public Yakmulh getYakmulhByCode(String mbCode);
	
	public int getYakmulRegist2(Yakmul yakmul);
	  
	public Yakmul getYakmulpDesc(String mbCode);
	
	// 검체검사결과 상세
	public Gumcheh getGumchehByCode(String strCode);

	public int getGumcheRegist2(Gumche gumche);

	public Gumche getGumchepDesc(String strCode);
	
	// 병리검사결과 상세
	public Byungrih getByungrihByCode(String ptrCode);

	public int getByungriRegist2(Byungri byungri);

	public Byungri getByungripDesc(String ptrCode);
	
	// 영상검사결과 상세
	public Youngsangh getYoungsanghByCode(String itrCode);

	public int getYoungsangRegist2(Youngsang youngsang);

	public Youngsang getYoungsangpDesc(String itrCode);
	
	// 영상판독정보 상세
	public Pandogh getPandoghByCode(String iidCode);

	public int getPandogRegist2(Pandog pandog);

	public Pandog getPandogpDesc(String iidCode);
	
	// 기능검사결과 상세
	public Ginuengh getGinuenghByCode(String ftrCode);

	public int getGinuengRegist2(Ginueng ginueng);

	public Ginueng getGinuengpDesc(String ftrCode);
	
	// 수술내역 상세
	public Susulh getSusulhByCode(String sbCode);

	public int getSusulRegist2(Susul ginueng);

	public Susul getSusulpDesc(String sbCode);
	
	// 알러지 및 부작용 상세
	public Allergyh getAllergyhByCode(String aseCode);

	public int getAllergyRegist2(Allergy allergy);

	public Allergy getAllergypDesc(String aseCode);
	
	// 예방접종내역 상세
	public Yebangh getYebanghByCode(String pibCode);

	public int getYebangRegist2(Yebang yebang);

	public Yebang getYebangpDesc(String pibCode);
	
	// 생체신호 및 상태 상세
	public Saengchaeh getSaengchaehByCode(String vscCode);

	public int getSaengchaeRegist2(Saengchae saengchae);

	public Saengchae getSaengchaepDesc(String vscCode);
	
	// 흡연상태 상세
	public Smokingh getSmokinghByCode(String scCode);

	public int getSmokingRegist2(Smoking smoking);

	public Smoking getSmokingpDesc(String scCode);
	
	// 음주상태 상세
	public Drinkingh getDrinkinghByCode(String dcCode);

	public int getDrinkingRegist2(Drinking drinking);

	public Drinking getDrinkingpDesc(String dcCode);
	
	// 법정 전염성 감염병 상세
	public Junyumh getJunyumhByCode(String lcidCode);

	public int getJunyumRegist2(Junyum junyum);

	public Junyum getJunyumpDesc(String lcidCode);
	
	public Total getTotalReplace(String dbCode, String mbCode, String strCode, String ptrCode
							   , String itrCode, String iidCode, String ftrCode, String sbCode
							   , String aseCode, String pibCode, String vscCode, String scCode
							   , String dcCode, String lcidCode);
	
}
