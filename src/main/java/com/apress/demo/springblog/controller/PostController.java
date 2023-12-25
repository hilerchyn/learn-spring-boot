package com.apress.demo.springblog.controller;

import java.io.File;
import java.nio.file.Files;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.apress.demo.springblog.domain.Post;
import com.apress.demo.springblog.service.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController{
    private final PostService postService = new PostService();

    @GetMapping
    public String postPage(Model model) {
        model.addAttribute("posts", postService.findAllPosts());

        return "post";
    }

    @GetMapping("/add")
    public String addPostPage(Model model) {
        model.addAttribute("post", new Post());

        return "addPost";
    }

    @PostMapping
    public String addPost(@ModelAttribute("post") @Valid Post post, Errors errors) {
        if(errors.hasErrors()) {
            return "addPost";
        }

        postService.addPost(post);

        return "redirect:/posts";
    }

    @GetMapping("/fileUpload")
    public String fileUpload(Model model) {
        return "fileUpload";
    }

    @PostMapping("/uploadMyFile")
    public String handleFileUpload(@RequestParam("myFile") MultipartFile file) {

        if(!file.isEmpty()) {
            String name = file.getOriginalFilename();

            try {
                byte[] bytes = file.getBytes();
                Files.write(new File(name).toPath(), bytes);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "redirect:/posts/fileUpload";
    }
}
