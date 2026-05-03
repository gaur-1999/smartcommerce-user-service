package com.prince.SmartCommerce.usersercvice.controller;



import com.prince.SmartCommerce.usersercvice.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class ProfileController {
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> getProfile(@AuthenticationPrincipal User currentUser) {

        Map<String, Object> response = new HashMap<>();
        response.put("id", currentUser.getId());
        response.put("name", currentUser.getName());
        response.put("email", currentUser.getEmail());
        response.put("role", currentUser.getRole());
        return ResponseEntity.ok(response);
    }
}
