package com.example.creditcardapplication.service;

import com.example.creditcardapplication.dao.UserInfoRepository;
import com.example.creditcardapplication.entity.UserInfo;
import org.springframework.stereotype.Service;
import com.example.creditcardapplication.request.UserInforRequest;
import com.example.creditcardapplication.response.APIResponse;
import com.example.creditcardapplication.response.UserResponse;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public APIResponse createUser(UserInforRequest user) {


        if(userInfoRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("User already exists");
        }


        UserInfo userInfo = getUserInfo(user);

        UserInfo saved = userInfoRepository.save(userInfo);

        return new APIResponse(
                "SUCCESS",
                new UserResponse(
                        saved.getUserId(),
                        "application submitted Successfully"
                ));
    }

    private static UserInfo getUserInfo(UserInforRequest user) {
        UserInfo userInfo = new UserInfo();

        userInfo.setFirstName(user.getFirstName());
        userInfo.setLastName(user.getLastName());
        userInfo.setEmail(user.getEmail());
        userInfo.setContact(user.getContact());
        userInfo.setDateOfBirth(user.getDateOfBirth());
        userInfo.setEmpSalary(user.getEmpSalary());
        userInfo.setMiddleName(user.getMiddleName());

        userInfo.setIdentityDocName(user.getIdentityDocName());
        userInfo.setIdentityDocNumber(user.getIdentityDocNumber());
        return userInfo;
    }
}
