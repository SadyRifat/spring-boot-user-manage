package com.user.manage.service;

import com.user.manage.entity.Role;
import com.user.manage.entity.User;
import com.user.manage.entity.UserProfile;
import com.user.manage.enums.ERole;
import com.user.manage.models.AccessToken;
import com.user.manage.models.LoginRequest;
import com.user.manage.models.RegistrationRequest;
import com.user.manage.repository.RoleRepository;
import com.user.manage.repository.UserCredentialRepository;
import com.user.manage.repository.UserProfileRepository;
import com.user.manage.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {
    @Value("${user.manage.jwtExpirationMs}")
    private int jwtExpiration;

    @Autowired private JWTService jwtService;
    @Autowired private RoleRepository roleRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private AuthenticationManager authenticationManager;
    @Autowired private UserProfileRepository userProfileRepository;
    @Autowired private UserCredentialRepository userCredentialRepository;

    public AccessToken requestAccessToken(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUserEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtService.generateToken(authentication);

        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(jwtToken);
        accessToken.setExpireAt(new Date((new Date()).getTime() + jwtExpiration));
        return accessToken;
    }

    public void userRegistration(RegistrationRequest registrationRequest) throws Exception {
        if (userCredentialRepository.findByUserEmail(registrationRequest.getEmail()).isEmpty()) {
            String userID = UUID.randomUUID().toString();
            UserProfile userProfile = new UserProfile();
            userProfile.setUserID(userID);
            userProfile.setFirstName(registrationRequest.getFirstName());
            userProfile.setLastName(registrationRequest.getLastName());
            userProfileRepository.save(userProfile);

            User user = new User();
            user.setId(userID);
            user.setEmail(registrationRequest.getEmail());
            user.setUsername(registrationRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setEnabled(true);

            Role role_user = roleRepository.getRoleByName(ERole.ROLE_USER);
            Set<Role> roles = user.getRoles();
            roles.add(role_user);

            userCredentialRepository.save(user);
        } else {
            throw new Exception("User Already exists. Please login.");
        }
    }
}
