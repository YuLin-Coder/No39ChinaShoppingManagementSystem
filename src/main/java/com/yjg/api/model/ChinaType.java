package com.yjg.api.model;

import java.util.List;

public class ChinaType {
	private Integer typeId;
	private String name;
	private String createDate;
	private Integer createId;
	private String createPer;
	private String modeDate;
	private Integer modeId; 
	private String modePer;
	private List<ChinaTypeD> list;
	
	
	
	
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
	
	public List<ChinaTypeD> getList() {
		return list;
	}
	public void setList(List<ChinaTypeD> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChinaType [typeId=");
		builder.append(typeId);
		builder.append(", name=");
		builder.append(name);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", createId=");
		builder.append(createId);
		builder.append(", createPer=");
		builder.append(createPer);
		builder.append(", modeDate=");
		builder.append(modeDate);
		builder.append(", modeId=");
		builder.append(modeId);
		builder.append(", modePer=");
		builder.append(modePer);
		builder.append(", list=");
		builder.append(list);
		builder.append("]");
		return builder.toString();
	}
	
	
}
