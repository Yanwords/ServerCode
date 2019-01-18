package com.nju.beans;

//import java.util.Date;

public class TravelRecord {
    private Integer travelId;
    private String travelContent;
    private String travelDate;
    private Integer userId;
    private User user;
	public Integer getTravelId() {
		return travelId;
	}
	public void setTravelId(Integer travelId) {
		this.travelId = travelId;
	}
	public String getTravelContent() {
		return travelContent;
	}
	public void setTravelContent(String travelContent) {
		this.travelContent = travelContent;
	}
	public String getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
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
}
