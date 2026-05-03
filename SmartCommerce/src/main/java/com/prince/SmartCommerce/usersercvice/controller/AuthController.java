package com.prince.SmartCommerce.usersercvice.controller;

import com.prince.SmartCommerce.usersercvice.dto.AuthResponse;
import com.prince.SmartCommerce.usersercvice.dto.LoginRequest;
import com.prince.SmartCommerce.usersercvice.dto.RegisterRequest;
import com.prince.SmartCommerce.usersercvice.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request){
        return ResponseEntity.ok(authService.Login(request));
    }
}
