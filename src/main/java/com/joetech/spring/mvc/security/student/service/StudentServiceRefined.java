package com.joetech.spring.mvc.security.student.service;

import javax.transaction.Transactional;

import org.springframework.security.access.prepost.PreAuthorize;
import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.user.model.persistence.PersistentStudent;

@Transactional
public interface StudentServiceRefined {
	 @PreAuthorize("hasAuthority('READ_STUDENT')")
	    public Iterable<? extends PersistentStudent> getAllStudents();
	   @PreAuthorize("hasAuthority('READ_STUDENT')")
	    public PersistentStudent getStudent(final int id);
	   @PreAuthorize("hasAuthority('CREATE_STUDENT')")
	    public void createStudent(final Student student);
	   @PreAuthorize("hasAuthority('UPDATE_STUDENT')")
	    public void updateStudent(final Student student);
	   @PreAuthorize("hasAuthority('DELETE_STUDENT')")
	    public void deleteStudent(int id);
	   public PersistentStudent getStudentIdno(final String idno);
	

}
