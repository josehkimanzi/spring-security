package com.joetech.spring.mvc.security.api;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.joetech.spring.mvc.security.user.model.Role;
import com.joetech.spring.mvc.security.user.model.persistence.PersistentRole;
import com.joetech.spring.mvc.security.validation.group.Creation;
import com.joetech.spring.mvc.security.validation.group.Update;
import com.google.common.collect.Iterables;

public class User {
	private Integer id;
	private String email;
	@NotNull(groups = { Creation.class })
    @Size(min = 3, max = 20, groups = { Creation.class })
	private String name;
	@NotNull(groups = { Creation.class, Update.class })
    @Size(min = 3, max = 20, groups = { Creation.class, Update.class })
	private String password;
	private Boolean credentials_expired;
	private Boolean enabled; 
	private Boolean expired;
	private Boolean locked;
	 private final Collection<Role> roles = new ArrayList<>();
	
	 public Collection<? extends Role> getRoles() {
	        return Collections.unmodifiableCollection(roles);
	    }
	  public void setRoles(final Iterable<PersistentRole> rls) {
	        roles.clear();

	        Iterables.addAll(roles, rls);
	    }
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getCredentials_expired() {
		return credentials_expired;
	}
	public void setCredentials_expired(Boolean credentials_expired) {
		this.credentials_expired = credentials_expired;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Boolean getExpired() {
		return expired;
	}
	public void setExpired(Boolean expired) {
		this.expired = expired;
	}
	public Boolean getLocked() {
		return locked;
	}
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", credentials_expired=" + credentials_expired + ", enabled=" + enabled + ", expired=" + expired
				+ ", locked=" + locked + "]";
	}
	
	
	 
 
	

}
