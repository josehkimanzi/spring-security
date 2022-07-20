package com.joetech.spring.mvc.security.student.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.joetech.spring.mvc.security.api.Student;
import com.joetech.spring.mvc.security.student.service.StudentService;
import com.joetech.spring.mvc.security.student.service.StudentServiceRefined;
import com.joetech.spring.mvc.security.user.model.persistence.PersistentStudent;
import com.joetech.spring.mvc.security.validation.group.Creation;


@Controller
public class StudentController{
	private static final Logger LOGGER   = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentServiceRefined studentServiceRefined;
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

	@GetMapping("/updateStudent")
	//public String updateStudent(@RequestParam("userId") int id,@ModelAttribute("student") Student student) {
	public String updateStudent(@RequestParam("userId") int id,Model model) {
		//we should give a user object of who clicked on the update button
		System.out.println("Looking for the data of student having id : "+id);
		Student theStudent = studentService.getStudent(id);
		model.addAttribute("student", theStudent);
		return "student/add-student";

	}
	
	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int id,RedirectAttributes attributes) {
		//capture the id of the student whom you are trying to delete
		//once captured the id do a service call to dlete the student
		studentService.deleteStudent(id);
		attributes.addFlashAttribute("success", "Student Record Deleted successfully");
		return "redirect:/showStudent";

	}
	
	
	   @GetMapping(path = "/studentAdvanced")
	    public String showStudentsList(final ModelMap model) {
	        model.put("students", studentServiceRefined.getAllStudents());

	        return "student/student-list";
	    }
	   @GetMapping(path = "/edit2/{id}")
	    public String showStudentEdition(
	            @PathVariable("id") final int id,
	            @ModelAttribute("student") final Student student,
	            final ModelMap model) {
	        final PersistentStudent persistentStudent;

	        persistentStudent = studentServiceRefined.getStudent(id);
	        BeanUtils.copyProperties(persistentStudent, student);

	        model.put("student", student);

	        return "student/add-student";
	    }
	   @GetMapping(path = "/addStudentNew")
	    public String addStudentNew(final ModelMap model) {
		   Student student=new Student();
	        model.put("student", student);

	        return "student/add-student";
	   }

	    @PostMapping("/saveStudentNew")
	    public String saveUser(final ModelMap model,
	            @ModelAttribute("student") @Validated(Creation.class) final Student student,
	            final BindingResult bindingResult,
	            final HttpServletResponse response,RedirectAttributes attributes) {
	        final String path;
	        if(student.getId()== 0) {
	
	        if (bindingResult.hasErrors()) {
	            // Invalid form data

	            // Returns to the form view
	            path = "student/add-student";

	            // Marks the response as a bad request
	            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	            return path;
	        } else {
	        	//studentServiceRefined.getStudentIdno(student.getIdno());
	        	studentServiceRefined.createStudent(student);
	        	//StudentDAO.saveUser(form);
	        	attributes.addFlashAttribute("success", "New User Recorded added Successfully With New Implementation");

	        	 return "redirect:/studentAdvanced";
	        }
	    }
	        else {

		        if (bindingResult.hasErrors()) {
		            // Invalid form data

		            // Returns to the form view
		            path = "student/add-student";

		            // Marks the response as a bad request
		            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		            return path;
		        } else {
		        	studentServiceRefined.updateStudent(student);
		        	//StudentDAO.saveUser(form);
		        	attributes.addFlashAttribute("success", "New User Recorded Updated Successfully With New Implementation");

		        	 return "redirect:/studentAdvanced";
		        }
	        	
	        }
	        
	       // return path;

	       
	    }
	    @GetMapping("/deleteStudentAdvanced")
		public String deleteStudentAdvanced(@RequestParam("userId") int id,RedirectAttributes attributes) {
			//capture the id of the student whom you are trying to delete
			//once captured the id do a service call to dlete the student
	    	studentServiceRefined.deleteStudent(id);
			attributes.addFlashAttribute("success", "Student Record Deleted successfully using New Implementation");
			return "redirect:/studentAdvanced";

		}

	
	
	

}
