package com.apress.demo.springblog.validation;

import org.thymeleaf.util.StringUtils;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.service.PostService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public record BlogPostTitleValidator(PostService postService) implements ConstraintValidator<BlogPostTitleAlreadyExists, Post> {

  @Override
  public void initialize(BlogPostTitleAlreadyExists constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(Post post, ConstraintValidatorContext constraintValidatorContext) {
    if(!StringUtils.isEmpty(post.getTitle()) && postService.postExistsWithTitle(post.getTitle())){
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext.buildConstraintViolationWithTemplate("Title Already Exists")
        .addPropertyNode("title")
        .addConstraintViolation();

      return false;
    }

    return true;
  }
}
