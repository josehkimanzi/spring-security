package com.joetech.spring.mvc.security.validation.group;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.joetech.spring.mvc.security.student.repository.PersistentStudentRepository;

@Component
public class UniqueIdnoValidator implements ConstraintValidator<UniqueIdno, String> {
	private static final Logger LOGGER   = LoggerFactory.getLogger(UniqueIdnoValidator.class);
	//@Autowired
	 //private final PersistentStudentRepository studentRepository;
    
//	public UniqueIdnoValidator(final PersistentStudentRepository studentRepo) {
//		super();
//		 studentRepository = checkNotNull(studentRepo,
//	                "Received a null pointer as students repository");
//		
//	}

//	public UniqueIdnoValidator(final PersistentStudentRepository studentRepo) {
//		super();
//		 LOGGER.info("Inside UniqueIdnoValidator constructor setting studentRepo ");
//		 studentRepository = checkNotNull(studentRepo,
//	                "Received a null pointer as students repository");
//	}

	@Override
	public boolean isValid(String idno, ConstraintValidatorContext context) {
		 LOGGER.info("Inside UniqueIdnoValidator");
		return true;
		
		//return studentRepository.existsByIdno(idno);
	}

}
