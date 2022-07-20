package com.joetech.spring.mvc.security.user.service;

import javax.transaction.Transactional;

import org.springframework.security.access.prepost.PreAuthorize;

import com.joetech.spring.mvc.security.api.User;
import com.joetech.spring.mvc.security.user.model.persistence.PersistentStudent;
import com.joetech.spring.mvc.security.user.model.persistence.PersistentUser;

@Transactional
public interface UserServiceRefined {
	 @PreAuthorize("hasAuthority('READ_USER')")
	    public Iterable<? extends PersistentUser> getAllUsers();
	  @PreAuthorize("hasAuthority('READ_STUDENT')")
	    public PersistentUser getUser(final int id);
	   @PreAuthorize("hasAuthority('CREATE_USER')")
	    public void createUser(final User user);
	   public void createUserSelf(final User user);
	   @PreAuthorize("hasAuthority('UPDATE_USER')")
	    public void updateUser(final User user);
	   @PreAuthorize("hasAuthority('DELETE_USER')")
	    public void deleteUser(int id);

}
