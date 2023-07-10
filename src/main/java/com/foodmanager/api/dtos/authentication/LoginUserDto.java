package com.foodmanager.api.dtos.authentication;

public class LoginUserDto {
    public String email;
    public String password;

    public LoginUserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
