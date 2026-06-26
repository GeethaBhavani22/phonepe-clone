package com.phonepe.controller;

import com.phonepe.dto.LoginRequest;
import com.phonepe.dto.UserRegistrationRequest;
import com.phonepe.entity.User;
import com.phonepe.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(
            @RequestBody UserRegistrationRequest request
    ) {
        User user = userService.registerUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(
            @RequestBody LoginRequest request
    ) {
        User user = userService.login(request);
        return ResponseEntity.ok(user);
    }
}
