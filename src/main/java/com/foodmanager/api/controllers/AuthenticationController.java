package com.foodmanager.api.controllers;

import com.foodmanager.api.dtos.authentication.LoginUserDto;
import com.foodmanager.api.dtos.authentication.RegisterUserDto;
import com.foodmanager.domain.User;
import com.foodmanager.infrastructure.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody() LoginUserDto dto) {
        var user = this.authenticationService.login(dto.email, dto.password);

        return ResponseEntity
                .status(user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK)
                .body(user);
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody() RegisterUserDto dto) {
        var user = this.authenticationService.register(dto.email, dto.password, dto.kitchenIds);

        return ResponseEntity
                .status(user == null ? HttpStatus.BAD_REQUEST : HttpStatus.CREATED)
                .body(user);
    }
}
