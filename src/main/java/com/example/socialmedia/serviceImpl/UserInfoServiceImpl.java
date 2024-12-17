package com.example.socialmedia.serviceImpl;

import com.example.socialmedia.entity.UserInfo;
import com.example.socialmedia.repository.UserRepository;
import com.example.socialmedia.service.UserInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInformation {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserInfo addUser(UserInfo userInfo) {
     UserInfo userInfoResult=userRepository.save(userInfo);
     return userInfoResult;
    }
}
