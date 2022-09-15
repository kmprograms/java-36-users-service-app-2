package com.app.model;

import com.app.model.dto.AuthDataDto;
import com.app.model.role.Role;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
public class User {
    private final String username;
    private final String password;
    private final Role role;

    public User withPassword(String newPassword) {
        return User
                .builder()
                .username(username)
                .password(newPassword)
                .role(role)
                .build();
    }

    public AuthDataDto toAuthDataDto() {
        return new AuthDataDto(username, role);
    }

    @Override
    public String toString() {
        return "User %s [%s]".formatted(username, role.name());
    }
}
