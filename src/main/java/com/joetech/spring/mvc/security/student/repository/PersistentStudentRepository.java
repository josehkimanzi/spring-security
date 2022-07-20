package com.joetech.spring.mvc.security.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joetech.spring.mvc.security.user.model.persistence.PersistentStudent;

@Repository
public interface PersistentStudentRepository extends JpaRepository<PersistentStudent, Long> {
	public Optional<PersistentStudent> findOneById(final int id);
	public Optional<PersistentStudent> findOneByName(final String name);
	public Optional<PersistentStudent> findOneByIdno(final String name);
	public boolean existsByIdno(final String idno);

}
