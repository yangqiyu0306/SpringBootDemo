package com.yqy.model;

import java.io.Serializable;

public class User implements Serializable{
	
	private static final long serialVersionUID = 4682521591909533198L;
	
	private String id;
	private String userName;
	private String userPass;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPass=" + userPass + "]";
	}

}
