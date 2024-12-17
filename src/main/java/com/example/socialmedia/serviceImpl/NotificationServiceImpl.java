package com.example.socialmedia.serviceImpl;

import com.example.socialmedia.entity.Notification;
import com.example.socialmedia.entity.Post;

import com.example.socialmedia.repository.NotificationRepository;
import com.example.socialmedia.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification sendNotification(Post post, Integer userId) {

        Notification notification=new Notification();

        notification.setPost(post);
        notification.setUser(post.getUser());
        //notification.setTime("2024-12-17T10:00:00");

        Notification notificationResult=notificationRepository.save(notification);
        return notificationResult;
    }


}
