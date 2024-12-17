package com.example.socialmedia.service;

import com.example.socialmedia.entity.Notification;
import com.example.socialmedia.entity.Post;

public interface NotificationService {

    Notification sendNotification(Post post, Integer userId);

}
