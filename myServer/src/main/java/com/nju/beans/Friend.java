package com.nju.beans;

//import java.util.List;

public class Friend {
	private Integer userId;
	private Integer friendId;
	private String friendName;
	private String friendGender;
	private Integer friendAge;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getFriendGender() {
		return friendGender;
	}

	public void setFriendGender(String friendGender) {
		this.friendGender = friendGender;
	}

	public Integer getFriendAge() {
		return friendAge;
	}

	public void setFriendAge(Integer friendAge) {
		this.friendAge = friendAge;
	}
}
