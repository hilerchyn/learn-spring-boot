package com.apress.demo.springblog.domain;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment{
    private Integer id;

    @NotNull
    @Size(min = 3, max = 50, message = "Title must be minimum 3 characters, and maximum 50 characters long")
    private String title;

    @NotNull
    private String authorName;

    @NotNull
    @Size(min = 3, max = 100, message = "Body must be minimum 3 characters, and maximum 100 characters long")
    private String body;

    private LocalDate createdOn;
    private LocalDate updatedOn;
}
