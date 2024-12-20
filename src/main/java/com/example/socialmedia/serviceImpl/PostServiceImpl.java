package com.example.socialmedia.serviceImpl;

import com.example.socialmedia.entity.Notification;
import com.example.socialmedia.entity.Post;
import com.example.socialmedia.entity.UserInfo;
import com.example.socialmedia.exception.UserException;
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
        String ex;

        try{
            if(userId==null){
                ex="please enter userId";
                throw new UserException(ex);
            } else if (post==null) {
                ex="please enter post data";
                throw new UserException(ex);
            } else if (post.getpContent()==null) {
                ex="Post content not found";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        Optional<UserInfo> userInfoTemp=userRepository.findById(userId);
        try{
            if(userInfoTemp.get()==null){
                ex="User Not Found !!";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }


        post.setUser(userInfoTemp.get());

        Post postResult=postRepository.save(post);
        return postResult;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) {

        String ex;
        try{
            if(postId==null){
                ex="Please enter post id";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }

        Optional<Post> postTemp=postRepository.findById(postId);

        try{
            if(postTemp.get()==null){
                ex="Post not Found !";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }


        postTemp.get().setLikes(postTemp.get().getLikes() + 1);
        Post postResult= postRepository.save(postTemp.get());

        Notification notification= notificationService.sendNotification(postTemp.get(), userId); // Send notification for like
        return postResult;

    }
}
