package com.example.socialmedia.controller;

import com.example.socialmedia.entity.Post;
import com.example.socialmedia.serviceImpl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    @Autowired
    private PostServiceImpl postService;


    @PostMapping("/addPost")
    public Post addPost(@RequestBody Post post, @RequestParam("userId") Integer userId){

        Post postResult=postService.addPost(post,userId);
        return postResult;
    }

    @PutMapping("/likePost")
    public Post likePost(@RequestParam("postId") Integer postId,@RequestParam("userId") Integer userId){
        Post postResult= postService.likePost(postId,userId);
        return postResult;
    }
}

