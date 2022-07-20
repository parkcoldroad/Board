package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class PostController {

    private final PostService postService;

    @Autowired
    PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/post")//http post 메소드와 바인딩됨
    public void writePost(@RequestBody PostDto postDto){
        postService.writePost(postDto);
    }
    //@PathVariable annotation = {}안에 있는 매개 변수를 받아서 전해주는 것
    //@RequestedParam annotation = query 매개 변수 / 필터링 가능
    @GetMapping("/post/{postId}")
    public Post getPost(@PathVariable int postId){
        Post post = postService.getPost(postId);
        return post;
    }

    @DeleteMapping("/post/{postId}")
    public void deletePost(@PathVariable int postId){
        postService.deletePost(postId);
    }

    @PutMapping("/post/{postId}")
    public void updatePost(@PathVariable int postId,@RequestBody PostDto dto){
        postService.updatePost(postId,dto);
    }
}
