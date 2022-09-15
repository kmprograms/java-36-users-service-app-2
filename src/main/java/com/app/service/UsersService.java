package com.app.service;

import com.app.encoder.PasswordEncoder;
import com.app.model.User;
import com.app.model.dto.AuthDataDto;
import com.app.model.dto.CreateUserDto;
import com.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public String register(CreateUserDto user) {
        return userRepository
                .save(user
                        .toUser()
                        .withPassword(passwordEncoder.encode(user.password())));
    }

    public AuthDataDto login(String username, String password) {
        return userRepository
                .findByUsername(username)
                .filter(user -> passwordEncoder.check(password, user.getPassword()))
                .map(User::toAuthDataDto)
                .orElseThrow(() -> new IllegalStateException("Authentication failed for username: %s!".formatted(username)));
    }
}
