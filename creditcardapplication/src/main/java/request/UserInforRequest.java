package request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{10}$")
    private String contact;

    @NotBlank
    private LocalDate dateOfBirth;

    @NotBlank
    private String indentityDocName;

    @NotBlank
    private String identityDocNumber;

    @NotBlank
    private double empSalary;





}
