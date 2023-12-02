package com.yjg.api.model;
/**
 * 
 * @Title: User.java 
 * @Package com.yjg.api.model 
 * @author YJG  
 * @date 2017年3月10日 下午2:05:57 
 * @version V1.0
 */
public class User {
	private Integer userId;
	private String userName;
	private String gender;
	private String password;
	private String phoneNum;
	private String address;
	private String province;
	private String city;
	private String district;
	private String addressD;
	private String email;
	private String ifAdmin;
	private String createDate;
	private String createPer;
	private String modeDate;
	
	
	
	public String getCreatePer() {
		return createPer;
	}
	public void setCreatePer(String createPer) {
		this.createPer = createPer;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getModeDate() {
		return modeDate;
	}
	public void setModeDate(String modeDate) {
		this.modeDate = modeDate;
	}
	public String getIfAdmin() {
		return ifAdmin;
	}
	public void setIfAdmin(String ifAdmin) {
		this.ifAdmin = ifAdmin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAddressD() {
		return addressD;
	}
	public void setAddressD(String addressD) {
		this.addressD = addressD;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", password=");
		builder.append(password);
		builder.append(", phoneNum=");
		builder.append(phoneNum);
		builder.append(", address=");
		builder.append(address);
		builder.append(", province=");
		builder.append(province);
		builder.append(", city=");
		builder.append(city);
		builder.append(", district=");
		builder.append(district);
		builder.append(", addressD=");
		builder.append(addressD);
		builder.append(", email=");
		builder.append(email);
		builder.append(", ifAdmin=");
		builder.append(ifAdmin);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", modeDate=");
		builder.append(modeDate);
		builder.append("]");
		return builder.toString();
	}	
	
}
