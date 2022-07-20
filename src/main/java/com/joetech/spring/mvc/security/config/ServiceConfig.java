
package com.joetech.spring.mvc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.joetech.spring.mvc.security.user.repository.PersistentRoleRepository;
import com.joetech.spring.mvc.security.student.repository.PersistentStudentRepository;
import com.joetech.spring.mvc.security.student.service.StudentServiceRefined;
import com.joetech.spring.mvc.security.student.service.StudentServiceRefinedImpl;
import com.joetech.spring.mvc.security.user.repository.PersistentUserRepository;
import com.joetech.spring.mvc.security.user.service.DefaultUserService;
import com.joetech.spring.mvc.security.user.service.UserService;
import com.joetech.spring.mvc.security.user.service.UserServiceRefined;
import com.joetech.spring.mvc.security.user.service.UserServiceRefinedImpl;
import com.joetech.spring.mvc.security.validation.group.UniqueIdnoValidator;

/**
 * Service configuration.
 * 
 * @author Joe
 *
 */
@Configuration
public class ServiceConfig {

    public ServiceConfig() {
        super();
    }

    @Bean("userService")
    public UserService getUserService(final PersistentUserRepository userRepo,
            final PersistentRoleRepository roleRepo,
            final PasswordEncoder passEncoder) {
        return new DefaultUserService(userRepo,roleRepo, passEncoder);
    }
    @Bean("studentService")
    public StudentServiceRefined getStudentService(final PersistentStudentRepository studentRepo
           ) {
        return new StudentServiceRefinedImpl(studentRepo);
    }
    
    @Bean("userServiceRefined")
    public UserServiceRefined getUserService(final PersistentUserRepository userRepo) {
        return new UserServiceRefinedImpl(userRepo);
    }
//    @Bean("studentValidator")
//    public UniqueIdnoValidator getstudentValidator(final PersistentStudentRepository studentRepo
//           ) {
//        return new UniqueIdnoValidator(studentRepo);
//    }


}
