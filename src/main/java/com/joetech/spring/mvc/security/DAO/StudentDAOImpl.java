package com.joetech.spring.mvc.security.DAO;


import java.util.List;

import javax.sql.DataSource;

import com.joetech.spring.mvc.security.rowmapper.PrivilegeRowMapper;
import com.joetech.spring.mvc.security.rowmapper.RolePrivilegeRowMapper;
import com.joetech.spring.mvc.security.rowmapper.RoleRowMapper;
import com.joetech.spring.mvc.security.rowmapper.StudentRowMapper;
import com.joetech.spring.mvc.security.rowmapper.UserRoleRowMapper;
import com.joetech.spring.mvc.security.rowmapper.UserRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joetech.spring.mvc.security.api.Privilege;
import com.joetech.spring.mvc.security.api.Role;
import com.joetech.spring.mvc.security.api.RolePrivilege;
import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.api.User;
import com.joetech.spring.mvc.security.api.UserRole;
@Repository
public class StudentDAOImpl implements StudentDAO {
	   private static final Logger LOGGER   = LoggerFactory
	            .getLogger(StudentDAOImpl.class);
	   
	   JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());

		public DataSource dataSource(){
			DriverManagerDataSource dataSource= new DriverManagerDataSource();
			//set the db info to thr datasource object
			LOGGER.info("We are inside dataSource collecting DB credientials");
			dataSource.setUsername("root");
			dataSource.setPassword("root");
			dataSource.setUrl("jdbc:mysql://localhost:3306/seleniumexpress?useSSL=false");
			dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
			return dataSource;
			
			
		}
		
		@Override
		public List<UserRole> getUserRoles(int id) {
				
			
			//I will write some logic to get me the student data
					//from the DB
			 LOGGER.info("We are inside StudentDAOImpl about to make a select query");
			String sql="SELECT * FROM user_roles INNER JOIN roles ON user_roles.role_id=roles.id where user_id = " +id;
			LOGGER.info("We are inside StudentDAOImpl past select query: " +sql);
			List<UserRole> theListOfUserRoles=jdbcTemplate.query(sql, new UserRoleRowMapper());
			LOGGER.info("We are about to return theListOfUserRoles");
			return theListOfUserRoles;
		}
		
		@Override
		public List<RolePrivilege> getRolePrivilege(int id) {			
			
			//I will write some logic to get me the student data
					//from the DB
			 LOGGER.info("We are inside StudentDAOImpl about to make a select query");
			//String sql="SELECT * FROM role_privileges INNER JOIN privileges on role_privileges.privilege_id=privileges.id where role_id = " +id;
			String sql="SELECT rp.role_id, rp.privilege_id, r.name as role_name, p.name as privilege_name FROM role_privileges AS rp INNER JOIN privileges AS p ON rp.privilege_id=seleniumexpress.p.id INNER JOIN seleniumexpress.roles as r ON seleniumexpress.rp.role_id=seleniumexpress.r.id  where role_id = "+id;
			LOGGER.info("We are inside StudentDAOImpl past select query: " +sql);
			List<RolePrivilege> theListOfRolePrivileges=jdbcTemplate.query(sql, new RolePrivilegeRowMapper());
			LOGGER.info("We are about to return theListOfRolePrivileges");
			return theListOfRolePrivileges;
		}

		@Override
		public Role getRole(int id) {

			 LOGGER.info("We are inside StudentDAOImpl about to make a select query");
			String sql="SELECT * FROM roles where id = ?";
			LOGGER.info("We are inside StudentDAOImpl past select query: " +sql);
			Role role=jdbcTemplate.queryForObject(sql, new RoleRowMapper(), id);
			LOGGER.info("We are about to retun role");
			return role;
		}
		@Override
		public Privilege getPrivilege(int id) {

			 LOGGER.info("We are inside StudentDAOImpl about to make a select query");
			String sql="SELECT * FROM privileges where id = ?";
			LOGGER.info("We are inside StudentDAOImpl past select query: " +sql);
			Privilege privilege=jdbcTemplate.queryForObject(sql, new PrivilegeRowMapper(), id);
			LOGGER.info("We are about to retun privilege");
			return privilege;
		}

	@Override
	public List<Student> loadStudents() {
			
		
		//I will write some logic to get me the student data
				//from the DB
		 LOGGER.info("We are inside StudentDAOImpl about to make a select query");
		String sql="SELECT * FROM STUDENTS";
		LOGGER.info("We are inside StudentDAOImpl past select query");
		List<Student> theListOfStudents=jdbcTemplate.query(sql, new StudentRowMapper());
		LOGGER.info("We are about to return theListOfStudents");
		return theListOfStudents;
	}
	@Override
	public List<User> loadUsers() {
			
		
		//I will write some logic to get me the student data
				//from the DB
		 LOGGER.info("We are inside StudentDAOImpl about to make a select query");
		String sql="SELECT * FROM USERS";
		LOGGER.info("We are inside StudentDAOImpl past select query");
		List<User> theListOfUsers=jdbcTemplate.query(sql, new UserRowMapper());
		LOGGER.info("We are about to return theListOfUsers");
		return theListOfUsers;
	}
	@Override
	public List<Role> loadRoles() {
			
		
		//I will write some logic to get me the student data
				//from the DB
		 LOGGER.info("We are inside StudentDAOImpl about to make a select query");
		String sql="SELECT * FROM roles";
		LOGGER.info("We are inside StudentDAOImpl past select query");
		List<Role> theListOfRoles=jdbcTemplate.query(sql, new RoleRowMapper());
		LOGGER.info("We are about to return theListOfRoles");
		return theListOfRoles;
	}
	@Override
	public List<Privilege> loadPrivileges() {
			
		
		//I will write some logic to get me the student data
				//from the DB
		 LOGGER.info("We are inside StudentDAOImpl about to make a select query");
		String sql="SELECT * FROM rivileges";
		LOGGER.info("We are inside StudentDAOImpl past select query");
		List<Privilege> theListOfPrivileges=jdbcTemplate.query(sql, new PrivilegeRowMapper());
		LOGGER.info("We are about to return theListOfPrivileges");
		return theListOfPrivileges;
	}

	@Override
	public void saveStudent(Student student) {
		// write the logic to store the student object into the database
	Object[] sqlParameters=	{student.getName(),student.getMobile(),student.getCountry(),student.getIdno()};
	String sql="insert into students(name,mobile,country,idno) values(?,?,?,?)";
	jdbcTemplate.update(sql, sqlParameters);
	System.out.println("1 record inserted...");
		
	}

	@Override
	public void saveUser(User user) {
		// write the logic to store the user object into the database
		Object[] sqlParameters=	{user.getName() ,user.getEmail(),user.getCredentials_expired(),user.getExpired(),user.getEnabled(),user.getLocked(),user.getPassword()};
		String sql="insert into users(name,email,credentials_expired,expired,enabled,locked,password) values(?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, sqlParameters);
		System.out.println("1 record inserted...");
		LOGGER.info("1 record inserted to users table...");
		
	}

	@Override
	public Student getStudent(int id) {
		String sql="SELECT * FROM students WHERE id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
		return student;
	}
	@Override
	public User getUser(int id) {
		String sql="SELECT * FROM users WHERE id = ?";
		User user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), id);
		return user;
	}


	@Override
	public void update(Student student) {
		
		String sql="UPDATE students set name =?, mobile=?, country=?, idno=? WHERE id =?";
		jdbcTemplate.update(sql, student.getName(),student.getMobile(),student.getCountry(),student.getIdno(),student.getId());
		System.out.println("1 record updated...");
		
		
		
	}
	@Override
	public void updateUser(User user) {
		
		String sql="UPDATE users set name =?, password=?, enabled=?, locked=?, expired=? WHERE id =?";
		jdbcTemplate.update(sql, user.getName(),user.getPassword() ,user.getEnabled(),user.getLocked(),user.getExpired(),user.getId());
		System.out.println("1 user record updated...");
		
		
		
	}

	@Override
	public void deleteStudent(int id) {
		//sql statements are not case sensitive
		String sql="DELETE from students where id=?";
		jdbcTemplate.update(sql, id);
		System.out.println("1 record deleted...");
		
	}
	@Override
	public void deleteUser(int id) {
		//sql statements are not case sensitive
		String sql="DELETE from users where id=?";
		jdbcTemplate.update(sql, id);
		System.out.println("1 user record deleted...");
		
	}


}
