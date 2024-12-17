package com.example.socialmedia.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "notification_tbl")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer nId;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    private String time;

    public Notification() {
    }

    public Notification(Integer nId, UserInfo user, Post post, String time) {
        this.nId = nId;
        this.user = user;
        this.post = post;
        this.time = time;
    }

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
