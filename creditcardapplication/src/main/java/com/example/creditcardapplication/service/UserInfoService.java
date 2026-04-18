package com.example.creditcardapplication.service;

import jakarta.validation.Valid;
import com.example.creditcardapplication.request.UserInforRequest;
import com.example.creditcardapplication.response.APIResponse;

public interface UserInfoService {
    APIResponse createUser(@Valid UserInforRequest user);
}
