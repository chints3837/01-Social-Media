package com.example.socialmedia.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_tbl")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pId;

    private String pContent;
    private String pTime;

    @ManyToOne
    @JoinColumn(name = "uId")
    @JsonBackReference
    private UserInfo user;

    private int likes;

    public Post() {
    }

    public Post(Long pId, String pContent, String pTime, UserInfo user, int likes) {
        this.pId = pId;
        this.pContent = pContent;
        this.pTime = pTime;
        this.user = user;
        this.likes = likes;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public String getpTime() {
        return pTime;
    }

    public void setpTime(String pTime) {
        this.pTime = pTime;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
