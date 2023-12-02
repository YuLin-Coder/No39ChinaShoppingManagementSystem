package com.yjg.api.model;

//¹ºÎï³µ
public class Cart {
	private Integer cartId;
	private Integer userId;
	private Integer goodsNum;
	private String createDate;
	private String modeDate;
	private Integer goodsId;
	private Goods goods;
	
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
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
		builder.append("Cart [cartId=");
		builder.append(cartId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", goodsNum=");
		builder.append(goodsNum);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", modeDate=");
		builder.append(modeDate);
		builder.append(", goodsId=");
		builder.append(goodsId);
		builder.append(", goods=");
		builder.append(goods);
		builder.append("]");
		return builder.toString();
	}

	
}
