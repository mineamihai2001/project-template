package com.foodmanager.api.dtos.authentication;

import java.util.List;
import java.util.Set;

public class RegisterUserDto {
    public String email;
    public String password;
    public List<Long> kitchenIds;

    public RegisterUserDto(String email, String password, List<Long> kitchenIds) {
        this.email = email;
        this.password = password;
        this.kitchenIds = kitchenIds;
    }
}
