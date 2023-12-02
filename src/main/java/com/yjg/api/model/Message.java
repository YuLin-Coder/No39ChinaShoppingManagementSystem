package com.yjg.api.model;

public class Message {
	private Integer messageId;
	private String mName;
	private String mEmail;
	private String mPhone;
	private String mDetail;
	private String createDate;   //创建时间
	private String handleDate;   //处理时间
	private String handleName;   //处理时间
	private Integer handleId;     //处理人Id
	private String mStatus; //待处理or 已处理
	
	
	
	public String getHandleName() {
		return handleName;
	}
	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmEmail() {
		return mEmail;
	}
	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}
	public String getmPhone() {
		return mPhone;
	}
	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}
	public String getmDetail() {
		return mDetail;
	}
	public void setmDetail(String mDetail) {
		this.mDetail = mDetail;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getHandleDate() {
		return handleDate;
	}
	public void setHandleDate(String handleDate) {
		this.handleDate = handleDate;
	}
	
	
	public Integer getHandleId() {
		return handleId;
	}
	public void setHandleId(Integer handleId) {
		this.handleId = handleId;
	}
	public String getmStatus() {
		return mStatus;
	}
	public void setmStatus(String mStatus) {
		this.mStatus = mStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Message [messageId=");
		builder.append(messageId);
		builder.append(", mName=");
		builder.append(mName);
		builder.append(", mEmail=");
		builder.append(mEmail);
		builder.append(", mPhone=");
		builder.append(mPhone);
		builder.append(", mDetail=");
		builder.append(mDetail);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", handleDate=");
		builder.append(handleDate);
		builder.append(", handleName=");
		builder.append(handleName);
		builder.append(", handleId=");
		builder.append(handleId);
		builder.append(", mStatus=");
		builder.append(mStatus);
		builder.append("]");
		return builder.toString();
	}	
}
