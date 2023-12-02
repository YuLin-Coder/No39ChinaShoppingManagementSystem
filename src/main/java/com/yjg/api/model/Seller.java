package com.yjg.api.model;

import org.springframework.web.multipart.MultipartFile;

public class Seller {
	private Integer sellerId;
	private Integer userId;
	private String tUserName;
	private String tPhoneNum;
	private String tIdCard;
	private String tEmail;
	private String tIdCardUrl1;
	private String tIdCardUrl2;
	private String tStatus;  //10´ýÉóºË  20ÉóºËÍ¨¹ý
	private String createDate;
	private String modeDate;
	private MultipartFile file1;
	private MultipartFile file2;
	
	
	
	public MultipartFile getFile1() {
		return file1;
	}
	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}
	public MultipartFile getFile2() {
		return file2;
	}
	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSellerId() {
		return sellerId;
	}
	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}
	public String gettUserName() {
		return tUserName;
	}
	public void settUserName(String tUserName) {
		this.tUserName = tUserName;
	}
	public String gettPhoneNum() {
		return tPhoneNum;
	}
	public void settPhoneNum(String tPhoneNum) {
		this.tPhoneNum = tPhoneNum;
	}
	public String gettIdCard() {
		return tIdCard;
	}
	public void settIdCard(String tIdCard) {
		this.tIdCard = tIdCard;
	}
	public String gettEmail() {
		return tEmail;
	}
	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}
	public String gettIdCardUrl1() {
		return tIdCardUrl1;
	}
	public void settIdCardUrl1(String tIdCardUrl1) {
		this.tIdCardUrl1 = tIdCardUrl1;
	}
	public String gettIdCardUrl2() {
		return tIdCardUrl2;
	}
	public void settIdCardUrl2(String tIdCardUrl2) {
		this.tIdCardUrl2 = tIdCardUrl2;
	}
	public String gettStatus() {
		return tStatus;
	}
	public void settStatus(String tStatus) {
		this.tStatus = tStatus;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Seller [sellerId=");
		builder.append(sellerId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", tUserName=");
		builder.append(tUserName);
		builder.append(", tPhoneNum=");
		builder.append(tPhoneNum);
		builder.append(", tIdCard=");
		builder.append(tIdCard);
		builder.append(", tEmail=");
		builder.append(tEmail);
		builder.append(", tIdCardUrl1=");
		builder.append(tIdCardUrl1);
		builder.append(", tIdCardUrl2=");
		builder.append(tIdCardUrl2);
		builder.append(", tStatus=");
		builder.append(tStatus);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", modeDate=");
		builder.append(modeDate);
		builder.append(", file1=");
		builder.append(file1);
		builder.append(", file2=");
		builder.append(file2);
		builder.append("]");
		return builder.toString();
	}

	
}
