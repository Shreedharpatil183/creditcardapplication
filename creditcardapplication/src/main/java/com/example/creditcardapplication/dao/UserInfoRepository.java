package com.example.creditcardapplication.dao;

import com.example.creditcardapplication.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {

    boolean existsByEmail(String email);
}
