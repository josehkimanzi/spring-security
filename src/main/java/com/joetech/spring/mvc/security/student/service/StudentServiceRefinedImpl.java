package com.joetech.spring.mvc.security.student.service;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;

import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.student.repository.PersistentStudentRepository;
import com.joetech.spring.mvc.security.user.model.persistence.PersistentStudent;

public class StudentServiceRefinedImpl implements StudentServiceRefined {

    /**
     * Logger.
     */
    private static final Logger            LOGGER = LoggerFactory
            .getLogger(StudentServiceRefinedImpl.class);

    /**
     * Students repository.
     */
    private final PersistentStudentRepository studentRepository;
    
    

	public StudentServiceRefinedImpl(final PersistentStudentRepository studentRepo) {
		super();
		 studentRepository = checkNotNull(studentRepo,
	                "Received a null pointer as students repository");
		
	}



	@Override
//	@Cacheable("students")
	public Iterable<? extends PersistentStudent> getAllStudents() {
		 LOGGER.info("Making a call to studentRepository to retrieve all students");
		return studentRepository.findAll();
	}
	
	@Override
//    @Cacheable("student")
    public final PersistentStudent getStudent(final int id) {
        final Optional<PersistentStudent> read;
        final PersistentStudent student;

        checkNotNull(id);
        LOGGER.info("Making a call to studentRepository to retrieve a student");

        read = studentRepository.findOneById(id);
        LOGGER.info("Student details retrieved successfully");

        if (read.isPresent()) {
            student = read.get();
        } else {
            // TODO: Throw an exception maybe?
            LOGGER.warn("Student {} not found", id);
            student = null;
        }

        return student;
    }
	@Override
//  @Cacheable("student")
  public final PersistentStudent getStudentIdno(final String idno) {
      final Optional<PersistentStudent> read;
      final PersistentStudent persistentStudent;

      checkNotNull(idno);
      LOGGER.info("Making a call to studentRepository to retrieve a student with idno: "+idno);

      read = studentRepository.findOneByIdno(idno);
      LOGGER.info("Student details retrieved successfully");

      if (read.isPresent()) {
    	  persistentStudent = read.get();
      } else {
          // TODO: Throw an exception maybe?
          LOGGER.warn("Student {} not found", idno);
          persistentStudent = null;
      }

      return persistentStudent;
  }
	
    @Override
    public final void createStudent(final Student student) {
        final PersistentStudent entity;

        checkNotNull(student);
        LOGGER.info("Making a call to studentRepository to create a student");

        entity = new PersistentStudent();

        entity.setName(student.getName());
        entity.setMobile(student.getMobile());
        entity.setIdno(student.getIdno());
        entity.setCountry(student.getCountry());

        studentRepository.save(entity);
        LOGGER.info("Student Created Successfully");
    }
    @Override
    public final void updateStudent(final Student student) {
        final PersistentStudent entity;


        checkNotNull(student);
        LOGGER.info("Making a call to studentRepository to update a student");

        entity = studentRepository.findOneById(student.getId()).get();

        BeanUtils.copyProperties(student, entity);


        studentRepository.save(entity);
        LOGGER.info("Student Updated Successfully");
    }
    @Override
    public void deleteStudent(final int id) {
    	final PersistentStudent entity;
    	 LOGGER.info("Making a call to studentRepository to delete a student");
    	 entity = studentRepository.findOneById(id).get();
    	 studentRepository.delete(entity);
    	 LOGGER.info("Student Deleted Successfully");
    	
    }

}
