package com.example.creditcardapplication.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInforRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    private String middleName;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{10}$")
    private String contact;

    @NotNull
    private LocalDate dateOfBirth;

    @NotBlank
    private String identityDocName;

    @NotBlank
    private String identityDocNumber;

    @Positive
    private double empSalary;





}
