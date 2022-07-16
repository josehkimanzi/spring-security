package com.joetech.spring.mvc.security.api;

public class RolePrivilege {
	private Integer role_id;
	private Integer privilege_id;
	private String role_name;
	private String privilege_name;
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	public Integer getPrivilege_id() {
		return privilege_id;
	}
	public void setPrivilege_id(Integer privilege_id) {
		this.privilege_id = privilege_id;
	}
	
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getPrivilege_name() {
		return privilege_name;
	}
	public void setPrivilege_name(String privilege_name) {
		this.privilege_name = privilege_name;
	}
	@Override
	public String toString() {
		return "RolePrivilege [role_id=" + role_id + ", privilege_id=" + privilege_id + ", role_name=" + role_name
				+ ", privilege_name=" + privilege_name + "]";
	}

	

}
