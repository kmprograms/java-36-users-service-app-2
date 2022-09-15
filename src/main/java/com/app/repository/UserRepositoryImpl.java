package com.app.repository;

import com.app.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public String save(User user) {
        var username = user.getUsername();

        if (users.containsKey(username)) {
            throw new IllegalStateException("Username already exists");
        }

        users.put(username, user);
        return username;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.getOrDefault(username, null));
    }
}
