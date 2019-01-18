package com.nju.beans;

//import java.util.Date;

public class ShareExperience {
    private Integer experId;
    private Integer userId;
    private User user;
    private String experContent;
    private String experDate;
	public Integer getExperId() {
		return experId;
	}
	public void setExperId(Integer experId) {
		this.experId = experId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getExperContent() {
		return experContent;
	}
	public void setExperContent(String experContent) {
		this.experContent = experContent;
	}
	public String getExperDate() {
		return experDate;
	}
	public void setExperDate(String experDate) {
		this.experDate = experDate;
	}
}
