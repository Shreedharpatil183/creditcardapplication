package com.example.creditcardapplication.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.creditcardapplication.request.UserInforRequest;
import com.example.creditcardapplication.response.APIResponse;
import com.example.creditcardapplication.service.UserInfoService;


@RestController
@RequestMapping("/newCreditCardApplication")
public class CrediCardApplicationController {


    private final UserInfoService userInfoService;

    public CrediCardApplicationController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    @PostMapping("/userInfo")
    public ResponseEntity<APIResponse> createUser(@Valid @RequestBody UserInforRequest user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userInfoService.createUser(user));
    }


}
