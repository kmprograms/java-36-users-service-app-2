package com.app.repository;

import com.app.model.User;

import java.util.Optional;

public interface UserRepository {
    String save(User user);
    Optional<User> findByUsername(String username);
}
