package com.user.manage.controller;

import com.user.manage.models.AccessToken;
import com.user.manage.models.LoginRequest;
import com.user.manage.models.RegistrationRequest;
import com.user.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/app")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		AccessToken accessToken = userService.requestAccessToken(loginRequest);

		return ResponseEntity.ok(accessToken);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody RegistrationRequest registrationRequest) throws Exception {
		userService.userRegistration(registrationRequest);
		return new ResponseEntity<>("User Registered.", HttpStatus.OK);
	}
}
