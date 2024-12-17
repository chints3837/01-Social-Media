package com.example.socialmedia.repository;

import com.example.socialmedia.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {

//    List<Notification> findByUserId(Integer userId);

    // List<Notification> findByUser(Integer userId);



}
