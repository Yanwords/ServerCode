package com.nju.beans;

import java.util.Date;

public class ScenicEvaluation {
    private Integer evalId;
    private Integer userId;
    private User user;
    private Integer scenicId;
    private ScenicSpot scenicSpot;
    private String evalContent;
    private String evalDate;
    public Integer getEvalId() {
		return evalId;
	}
	public void setEvalId(Integer evalId) {
		this.evalId = evalId;
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
	public Integer getScenicId() {
		return scenicId;
	}
	public void setScenicId(Integer scenicId) {
		this.scenicId = scenicId;
	}
	public ScenicSpot getScenicSpot() {
		return scenicSpot;
	}
	public void setScenicSpot(ScenicSpot scenicSpot) {
		this.scenicSpot = scenicSpot;
	}
	public String getEvalContent() {
		return evalContent;
	}
	public void setEvalContent(String evalContent) {
		this.evalContent = evalContent;
	}

	public String getEvalDate() {
		return evalDate;
	}
	public void setEvalDate(String evalDate) {
		this.evalDate = evalDate;
	}

	Date date;
}
