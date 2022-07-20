package com.joetech.spring.mvc.security.user.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.math.BigInteger;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.api.User;
import com.joetech.spring.mvc.security.student.repository.PersistentStudentRepository;
import com.joetech.spring.mvc.security.user.model.persistence.PersistentStudent;
import com.joetech.spring.mvc.security.user.model.persistence.PersistentUser;
import com.joetech.spring.mvc.security.user.repository.PersistentUserRepository;

public class UserServiceRefinedImpl implements UserServiceRefined {
	 private static final Logger            LOGGER = LoggerFactory
	            .getLogger(UserServiceRefinedImpl.class);
	
	           private final PersistentUserRepository userRepository;
	           
	  public UserServiceRefinedImpl(PersistentUserRepository userRepo) {
		  super();
		  userRepository = checkNotNull(userRepo,
	                "Received a null pointer as users repository");
	}
	  @Override
//		@Cacheable("users")
		public Iterable<? extends PersistentUser> getAllUsers() {
			 LOGGER.info("Making a call to userRepository to retrieve all users [advanced]");
			return userRepository.findAll();
		}
	  
		@Override
//	    @Cacheable("student")
	    public final PersistentUser getUser(final int id) {
	        final Optional<PersistentUser> read;
	        final PersistentUser user;

	        checkNotNull(id);
	        LOGGER.info("Making a call to user Repository to retrieve a user");
	        Long longId=(long) id;

	        read = userRepository.findById(longId);
	        LOGGER.info("User details retrieved successfully with New Implementation");

	        if (read.isPresent()) {
	            user = read.get();
	        } else {
	            // TODO: Throw an exception maybe?
	            LOGGER.warn("Users {} not found", id);
	            user = null;
	        }

	        return user;
	    }
	  
	@Override
	    public final void createUser(final User user) {
	        final PersistentUser entity;

	        checkNotNull(user);
	        LOGGER.info("Making a call to PersistentUserRepository to create a user");

	        entity = new PersistentUser();

	        entity.setUsername(user.getUsername());
	        entity.setEmail(user.getEmail());
	        entity.setPassword(user.getPassword());

	        userRepository.save(entity);
	        LOGGER.info("User Created Successfully with New Implementation");
	    }
	
	
	@Override
    public final void createUserSelf(final User user) {
		createUser(user);
        
    }
	   @Override
	    public final void updateUser(final User user) {
	        final PersistentUser entity;


	        checkNotNull(user);
	        LOGGER.info("Making a call to userRepository to update a user");
	        Long longId=(long) user.getId();

	        entity = userRepository.findById(longId).get();

	        BeanUtils.copyProperties(user, entity);


	        userRepository.save(entity);
	        LOGGER.info("User Updated Successfully with New Implementation");
	    }
	   @Override
	    public void deleteUser(final int id) {
	    	final PersistentUser entity;
	    	Long longId=(long) id;
	    	 LOGGER.info("Making a call to userRepository to delete a user");
	    	 entity = userRepository.findById(longId).get();
	    	 userRepository.delete(entity);
	    	 LOGGER.info("User Deleted Successfully with New Implementation");
	    	
	    }

}
