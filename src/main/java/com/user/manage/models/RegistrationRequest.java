package com.user.manage.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistrationRequest {
    @JsonProperty("first_name")
    @NotBlank(message = "First name is required.")
    private String firstName;

    @JsonProperty("last_name")
    @NotBlank(message = "Last name is required.")
    private String lastName;

    @Email
    @JsonProperty("email")
    @NotBlank(message = "Email is required.")
    private String email;

    @JsonProperty("password")
    @NotBlank(message = "Password is required.")
    private String password;

    @JsonProperty("confirm_password")
    @NotBlank(message = "Confirm Password is required.")
    private String confirmPassword;
}
