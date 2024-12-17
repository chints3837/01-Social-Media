package com.example.socialmedia.service;

import com.example.socialmedia.entity.Post;

public interface PostService {

    Post addPost(Post post,Integer userId);

    Post likePost(Integer postId,Integer userId);
}
