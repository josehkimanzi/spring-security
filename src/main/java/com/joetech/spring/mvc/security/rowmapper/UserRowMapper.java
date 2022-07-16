package com.joetech.spring.mvc.security.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.joetech.spring.mvc.security.api.User;

public class UserRowMapper  implements RowMapper<User> {
	private static final Logger LOGGER   = LoggerFactory
            .getLogger(UserRowMapper.class);

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		 LOGGER.info("We are inside UserRowMapper");
		User user=new User();
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setCredentials_expired(rs.getBoolean("credentials_expired"));
		user.setEnabled(rs.getBoolean("enabled"));
		user.setExpired(rs.getBoolean("expired"));
		user.setLocked(rs.getBoolean("locked"));
		return user;
	}

}
