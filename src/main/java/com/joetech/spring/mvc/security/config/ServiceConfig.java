/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2017-2020 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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

}
