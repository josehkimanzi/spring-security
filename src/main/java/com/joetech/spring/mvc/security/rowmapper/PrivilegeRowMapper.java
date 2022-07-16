package com.joetech.spring.mvc.security.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;

import com.joetech.spring.mvc.security.api.Privilege;

public class PrivilegeRowMapper  implements RowMapper<Privilege>  {
	private static final Logger LOGGER   = LoggerFactory
            .getLogger(RoleRowMapper.class);

	@Override
	public Privilege mapRow(ResultSet rs, int rowNum) throws SQLException {
		LOGGER.info("We are inside PrivilegeRowMapper");
		Privilege privilege=new Privilege();
		privilege.setId(rs.getInt("id"));
		privilege.setName(rs.getString("name"));
		return privilege;
		
	}

}
