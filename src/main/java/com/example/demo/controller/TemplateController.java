package com.example.demo.controller;

import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    private final PostService postService;

    @Autowired
    TemplateController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String home(Model model) {
        model.addAttribute("posts", postService.getAllPost());
        return "home";
    }
}
