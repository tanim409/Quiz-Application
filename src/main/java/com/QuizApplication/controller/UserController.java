package com.QuizApplication.controller;

import com.QuizApplication.model.User;
import com.QuizApplication.service.registerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@Tag(name="Oauth APIs")
public class UserController {
    @Autowired
    registerService RegisterService;

    @PostMapping("/register")
    User Register(@RequestBody User user) {
        return RegisterService.Register(user);
    }

    @PostMapping("/login")
    String varify(@RequestBody User user) throws NoSuchAlgorithmException, InvalidKeySpecException {
        return RegisterService.verify(user);
    }
}
