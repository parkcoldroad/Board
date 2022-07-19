package com.example.demo.service;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor // final로 생성된 변수에 생성자를 자동으로 autowired 하게
public class PostService {
    private final PostRepository postRepository;

    public Post getPost(int postId){
        Optional<Post> postOptional = postRepository.findById(postId);
        if(postOptional.isPresent()){
            return postOptional.get();
        }
        return null;
    }
}
