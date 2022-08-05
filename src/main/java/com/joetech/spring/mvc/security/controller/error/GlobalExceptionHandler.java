package com.joetech.spring.mvc.security.controller.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import com.joetech.spring.mvc.security.student.service.StudentServiceRefined;


/**
 * Captures and handles exceptions for all the controllers.
 * 
 * @author Joe
 */
@ControllerAdvice
public final class GlobalExceptionHandler
        extends AbstractHandlerExceptionResolver {
	@Autowired
	private StudentServiceRefined studentServiceRefined;

    /**
     * Logger for the exception handler.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(GlobalExceptionHandler.class);

    /**
     * Default constructor.
     */
    public GlobalExceptionHandler() {
        super();
    }

    @Override
    protected ModelAndView doResolveException(final HttpServletRequest request,
            final HttpServletResponse response, final Object handler,
            final Exception ex) {
        final ModelAndView modelView;

       //LOGGER.error(ex.getMessage(), ex);
        LOGGER.error(ex.getMessage());
        //LOGGER.error(request.getHeader("Referer"));
        //String referer =request.getHeader("Referer");
  
/*        
        //modelView = new ModelAndView("welcome");
         modelView = new ModelAndView("student/student-list");
          modelView.getModel().put("students", studentServiceRefined.getAllStudents());

        modelView.getModel().put("code",
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        modelView.getModel().put("error", ex.getMessage());*/
        
        
        

        modelView = new ModelAndView(ErrorViews.EXCEPTION);
        modelView.getModel().put("code",
                HttpStatus.INTERNAL_SERVER_ERROR.value());
        modelView.getModel().put("message", ex.getMessage());

        return modelView;
    }

}
