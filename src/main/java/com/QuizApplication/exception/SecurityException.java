package com.QuizApplication.exception;

public class SecurityException extends RuntimeException {
    public SecurityException(String id) {
     super("profile not found with id " + id);
    }

    }

