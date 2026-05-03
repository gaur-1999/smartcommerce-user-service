package com.prince.SmartCommerce.usersercvice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message="Name cannot be empty")
    private String name;

    @Email(message="Invalid Email Format")
    @NotBlank(message="Email cannot be Empty")
    private String email;

    @Size(min=6,message="Password must be atleast 6 characters")
    private String password;

}
