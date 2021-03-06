package com.joetech.spring.mvc.security.DAO;

import java.util.List;


import com.joetech.spring.mvc.security.api.Privilege;
import com.joetech.spring.mvc.security.api.Role;
import com.joetech.spring.mvc.security.api.RolePrivilege;
import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.api.User;
import com.joetech.spring.mvc.security.api.UserRole;

public interface StudentDAO {
	List<Student> loadStudents();
	void saveStudent(Student student);
	void saveUser(User user);
	Student getStudent(int id);
	User getUser(int id);
	void update(Student student);
	void updateUser(User user);
	void deleteStudent(int id);
	void deleteUser(int id);
	List<User> loadUsers();
	List<Role> loadRoles();
	List<Privilege> loadPrivileges();
	List<UserRole> getUserRoles(int id);
	List<RolePrivilege> getRolePrivilege(int id);
	Role getRole(int id);
	Privilege getPrivilege(int id);
	
	

}
