package com.foodmanager.infrastructure.repositories;

import com.foodmanager.domain.User;
import com.foodmanager.infrastructure.IRepository;

import java.util.List;

public interface UsersRepository extends IRepository<User> {
    User findByEmail(String email);
}
