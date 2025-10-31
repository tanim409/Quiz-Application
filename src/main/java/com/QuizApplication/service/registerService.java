package com.QuizApplication.service;
import com.QuizApplication.exception.SecurityException;
import com.QuizApplication.entities.User;
import com.QuizApplication.repo.UserRepo;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Service
public class registerService {
    @Autowired
    JwtService jwtService;
    @Autowired
    UserRepo repo;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    BCryptPasswordEncoder passwordEncoder;


    public User Register(User Securitymodel) {
        Securitymodel.setPassword(passwordEncoder.encode(Securitymodel.getPassword()));
        if (repo.findByUsername(Securitymodel.getUsername()) != null) {
            throw new SecurityException("Username Already Exists");
        }
        repo.save(Securitymodel);
        return Securitymodel;
    }

    public String verify(User Securitymodel) throws NoSuchAlgorithmException, InvalidKeySpecException {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(Securitymodel.getUsername(), Securitymodel.getPassword()));
            if (authentication.isAuthenticated()) {
                return jwtService.generateJwtToken(Securitymodel.getUsername());
            }
            throw new SecurityException("Authentication Failed");
        } catch (BadCredentialsException e) {
            throw new SecurityException("Invalid credentials");
        }
    }
}
