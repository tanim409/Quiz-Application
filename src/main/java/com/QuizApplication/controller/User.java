package com.QuizApplication.controller;

import com.QuizApplication.service.registerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@Tag(name="Oauth APIs")
public class User {
    @Autowired
    registerService RegisterService;

    @PostMapping("/register")
    com.QuizApplication.entities.User Register(@RequestBody com.QuizApplication.entities.User user) {
        return RegisterService.Register(user);
    }

    @PostMapping("/login")
    String varify(@RequestBody com.QuizApplication.entities.User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return RegisterService.verify(user);
    }
}
