package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PostController {

    private final PostService postService;

    @Autowired
    PostController(PostService postService){
      this.postService = postService;
    }

    @GetMapping("/post/{postId}")
    public Post getPost(@PathVariable int postId){
        Post post = postService.getPost(postId);
        return post;
    }
}
