package com.user.manage.service;

import com.user.manage.models.AccessToken;
import com.user.manage.models.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    @Value("${user.manage.jwtExpirationMs}")
    private int jwtExpiration;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTService jwtService;

    public AccessToken requestAccessToken(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtService.generateToken(authentication);

        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(jwtToken);
        accessToken.setExpireAt(new Date((new Date()).getTime() + jwtExpiration));
        return accessToken;
    }
}
