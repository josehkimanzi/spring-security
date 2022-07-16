package com.joetech.spring.mvc.security.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;


import com.joetech.spring.mvc.security.api.RolePrivilege;

public class RolePrivilegeRowMapper implements RowMapper<RolePrivilege> {
	private static final Logger LOGGER   = LoggerFactory
            .getLogger(RolePrivilegeRowMapper.class);
	@Override
	public RolePrivilege mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("We are inside RolePrivilegeRowMapper");
		RolePrivilege rolePrevilege=new RolePrivilege();
		rolePrevilege.setRole_id(rs.getInt("role_id"));
		rolePrevilege.setPrivilege_id(rs.getInt("privilege_id"));
		rolePrevilege.setRole_name(rs.getString("role_name"));
		rolePrevilege.setPrivilege_name(rs.getString("privilege_name"));
		return rolePrevilege;
	}

}
