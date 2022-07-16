package com.joetech.spring.mvc.security.DAO;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.joetech.spring.mvc.security.api.Privilege;
import com.joetech.spring.mvc.security.api.Role;
import com.joetech.spring.mvc.security.api.RolePrivilege;
import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.api.User;
import com.joetech.spring.mvc.security.api.UserRole;

public interface StudentDAO {
	@PreAuthorize("hasAuthority('READ_STUDENT')")
	List<Student> loadStudents();
	@PreAuthorize("hasAuthority('CREATE_STUDENT')")
	void saveStudent(Student student);
//	@PreAuthorize("hasAuthority('CREATE_USER')")
	void saveUser(User user);
	@PreAuthorize("hasAuthority('READ_STUDENT')")
	Student getStudent(int id);
	@PreAuthorize("hasAuthority('READ_USER')")
	User getUser(int id);
	@PreAuthorize("hasAuthority('UPDATE_STUDENT')")
	void update(Student student);
	@PreAuthorize("hasAuthority('CREATE_USER')")
	void updateUser(User user);
	@PreAuthorize("hasAuthority('DELETE_STUDENT')")
	void deleteStudent(int id);
	@PreAuthorize("hasAuthority('DELETE_USER')")
	void deleteUser(int id);
	@PreAuthorize("hasAuthority('READ_USER')")
	List<User> loadUsers();
	List<Role> loadRoles();
	List<Privilege> loadPrivileges();
	List<UserRole> getUserRoles(int id);
	List<RolePrivilege> getRolePrivilege(int id);
	Role getRole(int id);
	Privilege getPrivilege(int id);
	
	

}
