package com.joetech.spring.mvc.security.api;

public class UserRole {
	private Integer user_id;
	private Integer role_id;
	private String name;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "UserRole [user_id=" + user_id + ", role_id=" + role_id + ", name=" + name + "]";
	}
	

	

}
