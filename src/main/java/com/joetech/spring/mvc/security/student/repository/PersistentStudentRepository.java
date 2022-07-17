package com.joetech.spring.mvc.security.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joetech.spring.mvc.security.user.model.persistence.PersistentStudent;

public interface PersistentStudentRepository extends JpaRepository<PersistentStudent, Long> {
	public Optional<PersistentStudent> findOneById(final int id);
	public Optional<PersistentStudent> findOneByName(final String name);

}
