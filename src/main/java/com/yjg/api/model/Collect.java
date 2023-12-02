package com.yjg.api.model;
// ’≤ÿ
public class Collect {
	private Integer collectId;
	private Integer userId;
	private Integer goodsId;
	private Goods goods;
	private String createDate;
	private String modeDate;
	
	
	public Integer getCollectId() {
		return collectId;
	}
	public void setCollectId(Integer collectId) {
		this.collectId = collectId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
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
		builder.append("Collect [collectId=");
		builder.append(collectId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", goodsId=");
		builder.append(goodsId);
		builder.append(", goods=");
		builder.append(goods);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", modeDate=");
		builder.append(modeDate);
		builder.append("]");
		return builder.toString();
	}
	
	

}
