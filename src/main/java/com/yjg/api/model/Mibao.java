package com.yjg.api.model;

public class Mibao {
	private Integer id;
	private Integer userId;
	private String uquestion;
	private String uanswer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUquestion() {
		return uquestion;
	}
	public void setUquestion(String uquestion) {
		this.uquestion = uquestion;
	}
	public String getUanswer() {
		return uanswer;
	}
	public void setUanswer(String uanswer) {
		this.uanswer = uanswer;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mibao [id=");
		builder.append(id);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", uquestion=");
		builder.append(uquestion);
		builder.append(", uanswer=");
		builder.append(uanswer);
		builder.append("]");
		return builder.toString();
	}

}
