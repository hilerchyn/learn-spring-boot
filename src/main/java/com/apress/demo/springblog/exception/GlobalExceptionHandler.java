package com.apress.demo.springblog.exception;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SpringBlogException.class)
    public String servletRequestBindingException(ServletRequestBindingException e) {
        System.out.println("SpringBlogException occurred: " + e.getMessage());

        return "error";
    }
}
