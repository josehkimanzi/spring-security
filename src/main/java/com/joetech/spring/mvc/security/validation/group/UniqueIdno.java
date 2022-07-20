package com.joetech.spring.mvc.security.validation.group;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueIdnoValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueIdno {
	String message() default "User is already registered";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

}
