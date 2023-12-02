package com.yjg.api.model;

public class GoodsMessage {
	private Integer goodsMid;
	private Integer userId;
	private String userName;
	private Integer goodsId;
	private String manyd;
	private String goodsMDetail;
	private String createDate;
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Integer getGoodsMid() {
		return goodsMid;
	}
	public void setGoodsMid(Integer goodsMid) {
		this.goodsMid = goodsMid;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getManyd() {
		return manyd;
	}
	public void setManyd(String manyd) {
		this.manyd = manyd;
	}
	public String getGoodsMDetail() {
		return goodsMDetail;
	}
	public void setGoodsMDetail(String goodsMDetail) {
		this.goodsMDetail = goodsMDetail;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsMessage [goodsMid=");
		builder.append(goodsMid);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", userName=");
		builder.append(userName);
		builder.append(", goodsId=");
		builder.append(goodsId);
		builder.append(", manyd=");
		builder.append(manyd);
		builder.append(", goodsMDetail=");
		builder.append(goodsMDetail);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append("]");
		return builder.toString();
	}
	
}
