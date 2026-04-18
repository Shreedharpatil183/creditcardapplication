package com.example.creditcardapplication.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    private String firstName;
    private String middleName;
    private String lastName;

    private String email;

    private String contact;
    private LocalDate dateOfBirth;

    private String identityDocName;

    private String identityDocNumber;

    private String empOrgName;
    private String empOrgAddress;
    private double empSalary;




}
