package com.example.socialmedia.serviceImpl;

import com.example.socialmedia.entity.UserInfo;
import com.example.socialmedia.exception.UserException;
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

        String ex;

        try {
            if(userInfo==null){
                ex="Please User information";
                throw new UserException(ex);
            } else if (userInfo.getuAge()==null) {
                ex="Please Enter Age";
                throw new UserException(ex);
            } else if (userInfo.getuName()==null) {
                ex="Please Enter Name";
                throw new UserException(ex);
            }
        }catch (Exception e){
            System.out.println("Exception Occured :"+e.toString());
        }


        UserInfo userInfoResult=userRepository.save(userInfo);
        return userInfoResult;
    }
}
