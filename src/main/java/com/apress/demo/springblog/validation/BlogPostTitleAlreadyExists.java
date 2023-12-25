package com.apress.demo.springblog.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BlogPostTitleValidator.class)
public @interface BlogPostTitleAlreadyExists {
    String message() default "Title Already Exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
