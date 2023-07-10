package com.foodmanager.api.controllers;

import com.foodmanager.api.dtos.account.AddKitchenToUser;
import com.foodmanager.infrastructure.repositories.KitchensRepository;
import com.foodmanager.infrastructure.repositories.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {
    private final UsersRepository usersRepository;
    private final KitchensRepository kitchensRepository;

    public AccountController(UsersRepository usersRepository, KitchensRepository kitchensRepository) {
        this.usersRepository = usersRepository;
        this.kitchensRepository = kitchensRepository;
    }

    @PostMapping("add")
    public ResponseEntity<Void> addKitchenToUser(@RequestBody AddKitchenToUser dto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}
