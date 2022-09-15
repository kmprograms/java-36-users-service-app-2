package com.app.model.dto;

import com.app.model.User;
import com.app.model.role.Role;

public record CreateUserDto(String username, String password, Role role) {
    public User toUser() {
        return User
                .builder()
                .username(username)
                .password(password)
                .role(role)
                .build();
    }
}
