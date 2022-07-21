package com.example.demo.controller;

import com.example.demo.domain.Post;
import com.example.demo.service.PostService;
import dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // rest api 데이터를 돌려줄 때 데이터 형식이 JSON
//일반 Controller api, html을 리턴 값으로 받을 수 있음

public class PostController {//컨트롤러는 웹 브라우저에게 요청을 받아서 처리하는 부분

    private final PostService postService;

    @Autowired
    PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("/post")//http post 메소드와 바인딩됨
    public void writePost(@RequestBody PostDto postDto){//http 메소드 바디 부분에
        postService.writePost(postDto);
    }
    //예를 들어 로그인 할 때는 get이 아닌 post 메소드를 사용함, 왜냐 requestbody annotation이 http 프로토콜 바디 내부에 한번 싸여서 url에 노출되지 않기 때문에 보안적으로 안전하기 떄문에
    //@PathVariable annotation = {}안에 있는 매개 변수를 받아서 전해주는 것
    //@RequestedParam annotation = query 매개 변수 / 필터링 가능 / url에 ?를 사용하여 매개변수 매핑
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
