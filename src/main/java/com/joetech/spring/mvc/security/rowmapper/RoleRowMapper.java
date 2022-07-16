package com.joetech.spring.mvc.security.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.joetech.spring.mvc.security.api.Role;

public class RoleRowMapper implements RowMapper<Role> {
	private static final Logger LOGGER   = LoggerFactory
            .getLogger(RoleRowMapper.class);

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("We are inside RoleRowMapper");
		Role role=new Role();
		role.setId(rs.getInt("id"));
		role.setName(rs.getString("name"));
		return role;
	}

}
