package com.foodmanager.infrastructure.services;

import com.foodmanager.domain.User;
import com.foodmanager.infrastructure.repositories.KitchensRepository;
import com.foodmanager.infrastructure.repositories.UsersRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.List;

@Service
public class AuthenticationService {
    private final UsersRepository usersRepository;
    private final KitchensRepository kitchensRepository;

    public AuthenticationService(UsersRepository usersRepository, KitchensRepository kitchensRepository) {
        this.usersRepository = usersRepository;
        this.kitchensRepository = kitchensRepository;
    }

    public User login(String email, String password) {
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        var user = this.usersRepository.findByEmail(email);
        if (user == null || !bc.matches(password, user.getPassword())) {
            return null;
        }
        return user;
    }

    public User register(String email, String password, List<Long> kitchenIds) {
        var kitchens = this.kitchensRepository.findAllById(kitchenIds);
        if (kitchens.isEmpty()) {
            return null;
        }
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(10, new SecureRandom());
        String hashedPassword = bc.encode(password);

        return this.usersRepository.save(new User(email, hashedPassword, new HashSet<>(kitchens)));
    }
}
