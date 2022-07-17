package com.joetech.spring.mvc.security.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joetech.spring.mvc.security.api.RolePrivilege;
import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.api.User;
import com.joetech.spring.mvc.security.api.UserRole;
import com.joetech.spring.mvc.security.student.service.StudentService;
import com.joetech.spring.mvc.security.user.model.form.DefaultUserForm;
import com.joetech.spring.mvc.security.validation.group.Creation;


@Controller
public class StudentController{
	private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
	private static final Logger LOGGER   = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;
	@GetMapping("/showStudent")
	public String showStudentList(Model model) {
		// call the service to get the data
		List<Student> studentList = studentService.loadStudents();

		for (Student tempStudent : studentList) {
			System.out.println(tempStudent);

		}

		model.addAttribute("students", studentList);
		return "student/student-list";

	}
	@GetMapping("/showUser")
	public String showUserList(Model model) {
		// call the service to get the data
		List<User> userList = studentService.loadUsers();

		for (User tempUser : userList) {
			System.out.println(tempUser);
			List<UserRole> userRoleList= studentService.getUserRoles(tempUser.getId());
			for (UserRole tempUserRole : userRoleList) {
			//	System.out.println(tempUser.getName()+ " : "+ tempUserRole + studentService.getRole(tempUserRole.getRole_id()));
				System.out.println(tempUser.getName()+ " : "+ tempUserRole);
				List<RolePrivilege> rolePrivilegeList= studentService.getRolePrivilege(tempUserRole.getRole_id());
				for (RolePrivilege tempRolePrivilege : rolePrivilegeList) {
					//System.out.println(tempRolePrivilege.getPrivilege_id() + " : "+ tempRolePrivilege+ studentService.getPrivilege(tempRolePrivilege.getPrivilege_id()));
					System.out.println(tempRolePrivilege.getPrivilege_id() + " : "+ tempRolePrivilege);
				}
				
				
			}
			

		}

		model.addAttribute("users", userList);
		return "user/user-list";

	}
	@PostMapping("/save-student")
	public String saveStudent(final ModelMap model,
            @ModelAttribute("student") @Validated(Creation.class) final Student student,
            final BindingResult bindingResult,
            final HttpServletResponse response,RedirectAttributes attributes) {
//		Student student=new Student();
//		student.setId(14);
//		student.setName("Joseph");
//		student.setCountry("Kenyas");
//		student.setMobile((long) 8988);
//		student.setIdno("8988");
		 final String path;
		if(student.getId()== 0) 
		{
			 if (bindingResult.hasErrors()) {
		            // Invalid form data

		            // Returns to the form view
		            path = "student/add-student";

		            // Marks the response as a bad request
					attributes.addFlashAttribute("error", "New Student Record could not be saved");
		            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		        } else {
		        	//insert a new record
					System.out.println(student);
					 LOGGER.info("Student is : "+student);
					studentService.saveStudent(student);
					attributes.addFlashAttribute("success", "New Student ["+student.getName()+"] Added successfully");

					path= "redirect:/showStudent";
		        }
			
		}
		else {
			 if (bindingResult.hasErrors()) {
		            // Invalid form data

		            // Returns to the form view
		            path = "student/add-student";

		            // Marks the response as a bad request
		            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		        } else {
		    		//update an existing record
					System.out.println(student);
					 LOGGER.info("Student is : "+student);
					studentService.update(student);
					attributes.addFlashAttribute("success", "Student ["+student.getName()+"] Updated successfully");
					path= "redirect:/showStudent";
		        }
	
			
		}

//		return "student/student-list";
		return path;

	}
	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		Student student= new Student();
		model.addAttribute("student",student);
		
		return "student/add-student";

	}
	@GetMapping("/showAddUserPage")
	public String addUser(Model model) {
		User user= new User();
		user.setEnabled(true);
		model.addAttribute("user",user);
		
		return "user/add-user";

	}
	@GetMapping("/register")
	public String addUserRegister(Model model) {
		User user= new User();
		user.setEnabled(true);
		model.addAttribute("user",user);
		
		return "user/add-user";

	}
	@GetMapping("/updateStudent")
	//public String updateStudent(@RequestParam("userId") int id,@ModelAttribute("student") Student student) {
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		//we should give a user object of who clicked on the update button
		System.out.println("Looking for the data of student having id : "+id);
		Student theStudent = studentService.getStudent(id);
		model.addAttribute("student", theStudent);
		return "student/add-student";

	}
	@GetMapping("/updateUser")
	//public String updateStudent(@RequestParam("userId") int id,@ModelAttribute("student") Student student) {
	public String updateUser(@RequestParam("userId") int id,Model model) {
		//we should give a user object of who clicked on the update button
		System.out.println("Looking for the data of user having id : "+id);
		User theUser = studentService.getUser(id);
		model.addAttribute("user", theUser);
		return "user/add-user";

	}
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id,RedirectAttributes attributes) {
		//capture the id of the student whom you are trying to delete
		//once captured the id do a service call to dlete the student
		studentService.deleteStudent(id);
		attributes.addFlashAttribute("success", "Student Record Deleted successfully");
		return "redirect:/showStudent";

	}
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int id,RedirectAttributes attributes) {
		//capture the id of the student whom you are trying to delete
		//once captured the id do a service call to delete the user
		studentService.deleteUser(id);
		attributes.addFlashAttribute("success", "User  Deleted successfully");
		return "redirect:/users";

	}
	@PostMapping("/users/registeruser")
	public String registerUser(final ModelMap model,
            @ModelAttribute("user") @Validated(Creation.class) final User user,
            final BindingResult bindingResult,
            final HttpServletResponse response,RedirectAttributes attributes) {
//		Student student=new Student();
//		student.setId(14);
//		student.setName("Joseph");
//		student.setCountry("Kenyas");
//		student.setMobile((long) 8988);
//		student.setIdno("8988");
		 final String path;
		 final String encodedPassword;
		if(user.getCredentials_expired()==null) {
			user.setCredentials_expired(false);
			
		}

        if (user.getPassword() == null) {
            // Let the persistence layer handle this error
            encodedPassword = null;
        } else {
            // Password is encoded
            encodedPassword = passwordEncoder.encode(user.getPassword());
        }
        user.setPassword(encodedPassword);
        System.out.println(user.getId());
        if( user.getId() ==null ) 
		{
		 if (bindingResult.hasErrors()) {
	            // Invalid form data

	            // Returns to the form view
	            path = "user/add-user";

	            // Marks the response as a bad request
	            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        } else {
	        	//insert a new record
				System.out.println(user);
				//default some field because its self registration
				user.setEnabled(true);
				user.setLocked(false);
				user.setExpired(false);
				studentService.saveUser(user);
//				path= "redirect:/showUser";
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if (!(authentication instanceof AnonymousAuthenticationToken)) {
				   // String currentUserName = authentication.getName();
				   // return currentUserName;
					attributes.addFlashAttribute("success", "New User ["+user.getName()+"] added Successfully");
					path= "redirect:/users";
					
				}
				else {
					attributes.addFlashAttribute("success", "Registration was Successfull : Username is ["+ user.getName()+"]");
					path= "redirect:/login";

					
				}
				
	        }
		
		 
		}
        else {
        	 if (bindingResult.hasErrors()) {
 	            // Invalid form data

 	            // Returns to the form view
 	            path = "user/add-user";

 	            // Marks the response as a bad request
 	            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
 	        } else {
 	        	//update an existing record
				System.out.println(user);
				 LOGGER.info("User is : "+user);
				//default some field because its self registration
					user.setEnabled(true);
					user.setLocked(false);
					user.setExpired(false);
				 attributes.addFlashAttribute("success", "User ["+user.getName()+"] Updated successfully");
				studentService.updateUser(user);
				path= "redirect:/users";
 	        }
        	 
        }
        return path;
		
		
			
			
		}

	
	
	

}
