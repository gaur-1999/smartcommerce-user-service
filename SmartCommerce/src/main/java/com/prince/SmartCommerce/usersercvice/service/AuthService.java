package com.prince.SmartCommerce.usersercvice.service;

import com.prince.SmartCommerce.usersercvice.dto.AuthResponse;
import com.prince.SmartCommerce.usersercvice.dto.LoginRequest;
import com.prince.SmartCommerce.usersercvice.dto.RegisterRequest;
import com.prince.SmartCommerce.usersercvice.entity.User;
import com.prince.SmartCommerce.usersercvice.repository.UserRepository;
import com.prince.SmartCommerce.usersercvice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthResponse register(RegisterRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new RuntimeException("Email alreday Register:"+request.getEmail());
        }

        User user=User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(User.Role.USER)
                .build();

        userRepository.save(user);
        String token=jwtService.generateToken(user);
        return new AuthResponse(
                token,
                user.getEmail(),
                user.getRole().name(),
                "Registration Successful"
        );

    }

    public AuthResponse Login(LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        String token=jwtService.generateToken(user);

        return new AuthResponse(
                token,
                user.getEmail(),
                user.getRole().name(),
                "Login successfully"
        );
    }

}
