package com.yjg.api.model;

public class ChinaTypeD {
	private Integer typeDid;
	private Integer typeId;
	private String name;
	private String createDate;
	private String createPer;
	private Integer createId;
	private String modeDate;
	private String modePer;
	private Integer modeId;
	
	
	
	
	public String getCreatePer() {
		return createPer;
	}
	public void setCreatePer(String createPer) {
		this.createPer = createPer;
	}
	public String getModePer() {
		return modePer;
	}
	public void setModePer(String modePer) {
		this.modePer = modePer;
	}
	public Integer getCreateId() {
		return createId;
	}
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}
	public Integer getModeId() {
		return modeId;
	}
	public void setModeId(Integer modeId) {
		this.modeId = modeId;
	}
	public String getModeDate() {
		return modeDate;
	}
	public void setModeDate(String modeDate) {
		this.modeDate = modeDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public Integer getTypeDid() {
		return typeDid;
	}
	public void setTypeDid(Integer typeDid) {
		this.typeDid = typeDid;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChinaTypeD [typeDid=");
		builder.append(typeDid);
		builder.append(", typeId=");
		builder.append(typeId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", createPer=");
		builder.append(createPer);
		builder.append(", createId=");
		builder.append(createId);
		builder.append(", modeDate=");
		builder.append(modeDate);
		builder.append(", modePer=");
		builder.append(modePer);
		builder.append(", modeId=");
		builder.append(modeId);
		builder.append("]");
		return builder.toString();
	}

}
