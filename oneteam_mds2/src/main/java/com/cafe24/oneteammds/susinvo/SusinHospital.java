package com.cafe24.oneteammds.susinvo;

public class SusinHospital {
	//SusinHospital DB 컬럼 값 vo
	//private 접근 지정자 설정 후 각각의 변수 입력
	private String susinCode;
	private String hospitalId;
	private String hospitalName;
	private String patientId;
	private String patientName;
	private String susinJinlyoCode;
	private String susinDate;
	private String susinSayu;
	//getter setter 입력
	public String getSusinCode() {
		return susinCode;
	}
	public void setSusinCode(String susinCode) {
		this.susinCode = susinCode;
	}
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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
	public String getSusinJinlyoCode() {
		return susinJinlyoCode;
	}
	public void setSusinJinlyoCode(String susinJinlyoCode) {
		this.susinJinlyoCode = susinJinlyoCode;
	}
	public String getSusinDate() {
		return susinDate;
	}
	public void setSusinDate(String susinDate) {
		this.susinDate = susinDate;
	}
	public String getSusinSayu() {
		return susinSayu;
	}
	public void setSusinSayu(String susinSayu) {
		this.susinSayu = susinSayu;
	}
	//toString 입력
	//어노테이션 override
	@Override
	public String toString() {
		return "SusinAdmin [susinCode=" + susinCode + ", hospitalId=" + hospitalId + ", hospitalName=" + hospitalName
				+ ", patientId=" + patientId + ", patientName=" + patientName + ", susinJinlyoCode=" + susinJinlyoCode
				+ ", susinDate=" + susinDate + ", susinSayu=" + susinSayu + "]";
	}
	

}
