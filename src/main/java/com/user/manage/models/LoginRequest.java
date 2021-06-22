package com.user.manage.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginRequest {
	@NotBlank
	@JsonProperty("user_name")
	private String username;

	@NotBlank
	@JsonProperty("password")
	private String password;
}
