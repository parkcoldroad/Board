package com.example.demo.service.Impl;

import com.example.demo.domain.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.PostService;
import dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // spring 컨테이너가 관리하는 bean 객체라고 선언
@RequiredArgsConstructor // final로 생성된 변수에 생성자를 자동으로 autowired 하게 해주는 annotation
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public Post getPost(int postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
        if (postOptional.isPresent()) {
            return postOptional.get();
        }
        return null;
    }

    @Override
    public void writePost(PostDto dto) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .build();
        postRepository.save(post);
    }

    @Override
    public void deletePost(int postId) {
        Optional<Post> postOptional = postRepository.findById(postId);
//       if(postOptional.isPresent()){
//           postRepository.delete(postOptional.get());
//       }
        postOptional.ifPresent(postRepository::delete);
    }

    @Override
    public void updatePost(int postId, PostDto dto) {
        Optional<Post> postOptional = postRepository.findById(postId);
        postOptional.ifPresent(post -> {
                    post.setTitle(dto.getTitle());
                    post.setContent(dto.getContent());
                    postRepository.save(post);
                }
        );
    }

}
