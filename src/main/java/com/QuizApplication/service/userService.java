package com.QuizApplication.service;

import com.QuizApplication.model.User;
import com.QuizApplication.model.userSecurePrinciple;
import com.QuizApplication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class userService implements UserDetailsService {

    @Autowired
    private UserRepo securityRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User model = securityRepo.findByUsername(username);
        if (model == null) {
            throw new SecurityException(username);
        }

        return new userSecurePrinciple(model);
    }
}
