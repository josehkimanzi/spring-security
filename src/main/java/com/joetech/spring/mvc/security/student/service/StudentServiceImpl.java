package com.joetech.spring.mvc.security.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joetech.spring.mvc.security.DAO.StudentDAO;
import com.joetech.spring.mvc.security.api.Privilege;
import com.joetech.spring.mvc.security.api.Role;
import com.joetech.spring.mvc.security.api.RolePrivilege;
import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.api.User;
import com.joetech.spring.mvc.security.api.UserRole;

@Service
public class StudentServiceImpl implements StudentService {
@Autowired
private StudentDAO studentDAO;
	@Override
	public List<Student> loadStudents() {
		List<Student> studentList = studentDAO.loadStudents();
		return studentList;
	}

	@Override
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);

	}

	@Override
	public void saveUser(User user) {
		studentDAO.saveUser(user);

	}

	@Override
	public Student getStudent(int id) {
		return studentDAO.getStudent(id);
	}

	@Override
	public User getUser(int id) {
		return studentDAO.getUser(id);
	}

	@Override
	public void update(Student student) {
		studentDAO.update(student);
		

	}

	@Override
	public void updateUser(User user) {
		studentDAO.updateUser(user);

	}

	@Override
	public void deleteStudent(int id) {
		studentDAO.deleteStudent(id);		

	}

	@Override
	public void deleteUser(int id) {
		studentDAO.deleteUser(id);

	}

	@Override
	public List<User> loadUsers() {
		List<User> userList =studentDAO.loadUsers();
		return userList;
	}

	@Override
	public List<Role> loadRoles() {
		List<Role> roleList =studentDAO.loadRoles();
		return roleList;
	}

	@Override
	public List<Privilege> loadPrivileges() {
		List<Privilege> privilegeList=studentDAO.loadPrivileges();
		return privilegeList;
	}

	@Override
	public List<UserRole> getUserRoles(int id) {
		List<UserRole> userRoleList=studentDAO.getUserRoles(id);
		return userRoleList;
	}

	@Override
	public List<RolePrivilege> getRolePrivilege(int id) {
		List<RolePrivilege> rolePrivilegeList=studentDAO.getRolePrivilege(id);
		return rolePrivilegeList;
	}

	@Override
	public Role getRole(int id) {
		return studentDAO.getRole(id);
	}

	@Override
	public Privilege getPrivilege(int id) {
		return studentDAO.getPrivilege(id);
	}

}
