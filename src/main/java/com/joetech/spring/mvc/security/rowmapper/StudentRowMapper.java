package com.joetech.spring.mvc.security.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.RowMapper;
import com.joetech.spring.mvc.security.api.Student;
public class StudentRowMapper implements RowMapper<Student> {
	private static final Logger LOGGER   = LoggerFactory
            .getLogger(StudentRowMapper.class);
	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		 LOGGER.info("We are inside StudentRowMapper");
		Student student= new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setMobile(rs.getLong("mobile"));
		student.setCountry(rs.getString("country"));
		student.setIdno(rs.getString("idno"));
		return student;
	}

}
