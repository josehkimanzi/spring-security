package com.joetech.spring.mvc.security.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.joetech.spring.mvc.security.validation.group.Creation;
import com.joetech.spring.mvc.security.validation.group.Update;

public class Student {
	private int id;
	@NotNull(groups = { Creation.class })
    @Size(min = 2, max = 20, groups = { Creation.class, Update.class })
	private String name;
	@NotNull(groups = { Creation.class, Update.class })
	private Long mobile;
	@NotNull(groups = { Creation.class })
    @Size(min = 2, max = 20, groups = { Creation.class, Update.class })
	private String country;
	@NotNull(groups = { Creation.class, Update.class })
	@Size(min = 2, max = 20, groups = { Creation.class, Update.class })
	private String idno;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIdno() {
		return idno;
	}

	public void setIdno(String idno) {
		this.idno = idno;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", mobile=" + mobile + ", country=" + country + ", idno=" + idno
				+ "]";
	}
	
	
	

}
