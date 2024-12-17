package com.example.socialmedia.serviceImpl;

import com.example.socialmedia.entity.Notification;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.UserInfo;
import com.example.socialmedia.repository.PostRepository;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationServiceImpl notificationService;

    @Override
    public Post addPost(Post post,Integer userId) {

        Optional<UserInfo> userInfoTemp=userRepository.findById(userId);

        post.setUser(userInfoTemp.get());

        Post postResult=postRepository.save(post);
        return postResult;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) {

        Optional<Post> postTemp=postRepository.findById(postId);

        postTemp.get().setLikes(postTemp.get().getLikes() + 1);
        Post postResult= postRepository.save(postTemp.get());

        Notification notification= notificationService.sendNotification(postTemp.get(), userId); // Send notification for like
        return postResult;

    }
}
