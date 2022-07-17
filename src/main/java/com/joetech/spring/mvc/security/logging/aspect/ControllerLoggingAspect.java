package com.joetech.spring.mvc.security.logging.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Logging aspect for controllers. Will log arguments and returned values.
 * 
 * @author Joe
 */
@Component
@Aspect
public class ControllerLoggingAspect {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ControllerLoggingAspect.class);

    /**
     * Default constructor.
     */
    public ControllerLoggingAspect() {
        super();
    }

    /**
     * Logs the returned value after the method is called.
     * 
     * @param joinPoint
     *            point where the aspect is applied
     * @param returnValue
     *            returned value
     */
    @AfterReturning(
            value = "execution(* com.joetech.spring..*Controller*.*(..))",
            returning = "returnValue")
    public void afterCall(final JoinPoint joinPoint, final Object returnValue) {
        LOGGER.trace("Called {} and returning {}",
                joinPoint.getSignature().toShortString(), returnValue);
    }

    /**
     * Logs the received arguments before the method is called.
     * 
     * @param joinPoint
     *            point where the aspect is applied
     */
    @Before(value = "execution(* com.joetech.spring..*Controller*.*(..))",
            argNames = "joinPoint")
    public void beforeCall(final JoinPoint joinPoint) {
        LOGGER.trace("Calling {} with arguments {}",
                joinPoint.getSignature().toShortString(), joinPoint.getArgs());
    }

}
