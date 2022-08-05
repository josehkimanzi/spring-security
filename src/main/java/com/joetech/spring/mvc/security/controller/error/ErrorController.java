package com.joetech.spring.mvc.security.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for error views.
 * 
 * @author Joe
 */
@Controller
public class ErrorController {

    /**
     * Default constructor.
     */
    public ErrorController() {
        super();
    }

    /**
     * Shows the 404 error view.
     * 
     * @return the 404 error view
     */
    @RequestMapping("/404")
    public String show404() {
        return "404";
    }

    /**
     * Shows the 500 error view.
     * 
     * @return the 500 error view
     */
    @RequestMapping("/500")
    public String show500() {
        return "500";
    }

}
