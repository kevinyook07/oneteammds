package com.cafe24.oneteammds.yochengvo;

public class Yochenglist {
	//Yochenglist DB 컬럼 값 vo
	//private 접근 지정자 설정 후 각각의 변수 입력
	private String yochengCode;
	private String yochengoutHospitalId;
	private String yochengoutHospitalName;
	private String yochenginHospitalId;
	private String yochenginHospitalName;
	private String patientId;
	private String patientName;
	private String yochengJinlyoCode;
	private String yochengDate;
	private String yochengSayu;	
	//getter setter 입력
	public String getYochengCode() {
		return yochengCode;
	}
	public void setYochengCode(String yochengCode) {
		this.yochengCode = yochengCode;
	}
	public String getYochengoutHospitalId() {
		return yochengoutHospitalId;
	}
	public void setYochengoutHospitalId(String yochengoutHospitalId) {
		this.yochengoutHospitalId = yochengoutHospitalId;
	}
	public String getYochengoutHospitalName() {
		return yochengoutHospitalName;
	}
	public void setYochengoutHospitalName(String yochengoutHospitalName) {
		this.yochengoutHospitalName = yochengoutHospitalName;
	}
	public String getYochenginHospitalId() {
		return yochenginHospitalId;
	}
	public void setYochenginHospitalId(String yochenginHospitalId) {
		this.yochenginHospitalId = yochenginHospitalId;
	}
	public String getYochenginHospitalName() {
		return yochenginHospitalName;
	}
	public void setYochenginHospitalName(String yochenginHospitalName) {
		this.yochenginHospitalName = yochenginHospitalName;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getYochengJinlyoCode() {
		return yochengJinlyoCode;
	}
	public void setYochengJinlyoCode(String yochengJinlyoCode) {
		this.yochengJinlyoCode = yochengJinlyoCode;
	}
	public String getYochengDate() {
		return yochengDate;
	}
	public void setYochengDate(String yochengDate) {
		this.yochengDate = yochengDate;
	}
	public String getYochengSayu() {
		return yochengSayu;
	}
	public void setYochengSayu(String yochengSayu) {
		this.yochengSayu = yochengSayu;
	}	
	//toString 입력
	//어노테이션 override
	@Override
	public String toString() {
		return "Yochenglist [yochengCode=" + yochengCode + ", yochengoutHospitalId=" + yochengoutHospitalId
				+ ", yochengoutHospitalName=" + yochengoutHospitalName + ", yochenginHospitalId=" + yochenginHospitalId
				+ ", yochenginHospitalName=" + yochenginHospitalName + ", patientId=" + patientId + ", patientName="
				+ patientName + ", yochengJinlyoCode=" + yochengJinlyoCode + ", yochengDate=" + yochengDate
				+ ", yochengSayu=" + yochengSayu + "]";
	}
	
}
