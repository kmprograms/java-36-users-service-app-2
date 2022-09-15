package com.app.model.dto;

import com.app.model.role.Role;

public record AuthDataDto(String username, Role role) {
}
