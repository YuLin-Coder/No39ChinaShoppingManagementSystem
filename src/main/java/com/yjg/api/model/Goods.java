package com.yjg.api.model;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class Goods implements Serializable {
	private Integer goodsId;    //主键ID
	private Integer typeDid;
	private String goodsName;   //名字
	private Double goodsPrice;  //价格
	private Double goodsPriceZ; //折扣价格
	private String goodsFrom;   //来源
	private String goodsDesc;   //描述
	private Integer goodsNum;   //商品数量
	private String goodsUrl;   //图片url
	private String goodsUrl2;
	private String goodsUrl3;
	private String goodsUrl4;
	private String createDate;
	private Integer createId;
	private String modeDate;
	private Integer modeId;
	private String ifZK;  

	public Integer getTypeDid() {
		return typeDid;
	}
	public void setTypeDid(Integer typeDid) {
		this.typeDid = typeDid;
	}
	public Double getGoodsPriceZ() {
		return goodsPriceZ;
	}
	public void setGoodsPriceZ(Double goodsPriceZ) {
		this.goodsPriceZ = goodsPriceZ;
	}
	
	public String getIfZK() {
		return ifZK;
	}
	public void setIfZK(String ifZK) {
		this.ifZK = ifZK;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getCreateId() {
		return createId;
	}
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	public String getModeDate() {
		return modeDate;
	}
	public void setModeDate(String modeDate) {
		this.modeDate = modeDate;
	}
	public Integer getModeId() {
		return modeId;
	}
	public void setModeId(Integer modeId) {
		this.modeId = modeId;
	}
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsFrom() {
		return goodsFrom;
	}
	public void setGoodsFrom(String goodsFrom) {
		this.goodsFrom = goodsFrom;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public Integer getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}
	public String getGoodsUrl() {
		return goodsUrl;
	}
	public void setGoodsUrl(String goodsUrl) {
		this.goodsUrl = goodsUrl;
	}
	public String getGoodsUrl2() {
		return goodsUrl2;
	}
	public void setGoodsUrl2(String goodsUrl2) {
		this.goodsUrl2 = goodsUrl2;
	}
	public String getGoodsUrl3() {
		return goodsUrl3;
	}
	public void setGoodsUrl3(String goodsUrl3) {
		this.goodsUrl3 = goodsUrl3;
	}
	public String getGoodsUrl4() {
		return goodsUrl4;
	}
	public void setGoodsUrl4(String goodsUrl4) {
		this.goodsUrl4 = goodsUrl4;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Goods [goodsId=");
		builder.append(goodsId);
		builder.append(", typeDid=");
		builder.append(typeDid);
		builder.append(", goodsName=");
		builder.append(goodsName);
		builder.append(", goodsPrice=");
		builder.append(goodsPrice);
		builder.append(", goodsPriceZ=");
		builder.append(goodsPriceZ);
		builder.append(", goodsFrom=");
		builder.append(goodsFrom);
		builder.append(", goodsDesc=");
		builder.append(goodsDesc);
		builder.append(", goodsNum=");
		builder.append(goodsNum);
		builder.append(", goodsUrl=");
		builder.append(goodsUrl);
		builder.append(", goodsUrl2=");
		builder.append(goodsUrl2);
		builder.append(", goodsUrl3=");
		builder.append(goodsUrl3);
		builder.append(", goodsUrl4=");
		builder.append(goodsUrl4);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", createId=");
		builder.append(createId);
		builder.append(", modeDate=");
		builder.append(modeDate);
		builder.append(", modeId=");
		builder.append(modeId);
		builder.append(", ifZK=");
		builder.append(ifZK);
		builder.append("]");
		return builder.toString();
	}
	
}
