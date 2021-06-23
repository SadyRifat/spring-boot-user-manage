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
public class LoginRequest {
	@Email
	@NotBlank(message = "Email can not be blank")
	@JsonProperty("user_email")
	private String userEmail;

	@NotBlank(message = "Password can not be blank")
	@JsonProperty("password")
	private String password;
}
