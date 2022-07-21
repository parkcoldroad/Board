package com.example.demo.service;

import com.example.demo.domain.Post;
import dto.PostDto;

import java.util.List;

public interface PostService {

    public Post getPost(int postId);

    public void writePost(PostDto dto);

    public void deletePost(int postId);

    public void updatePost(int postId, PostDto dto);

    public List<Post> getAllPost();
}
