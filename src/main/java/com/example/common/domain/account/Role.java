package com.example.common.domain.account;

public enum Role {
    ROLE_ADMIN("관리자", "ROLE_ADMIN"), ROLE_USER("사용자", "ROLE_USER");
    private String description;
    private String role;
    Role(String description, String role) {
        this.description = description;
        this.role = role;
    }
}
