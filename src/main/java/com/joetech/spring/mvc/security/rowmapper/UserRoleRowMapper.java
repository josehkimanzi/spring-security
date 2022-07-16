package com.joetech.spring.mvc.security.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.joetech.spring.mvc.security.api.UserRole;

public class UserRoleRowMapper  implements RowMapper<UserRole>{
	
	private static final Logger LOGGER   = LoggerFactory
            .getLogger(UserRoleRowMapper.class);

	@Override
	public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("We are inside UserRoleRowMapper");
		UserRole userRole=new UserRole();
		userRole.setUser_id(rs.getInt("user_id"));
		userRole.setRole_id(rs.getInt("role_id"));
		userRole.setName(rs.getString("name"));
		return userRole;
	}

}
