package com.example.common.dto.account.request;

import com.example.common.domain.account.Account;
import com.example.common.domain.account.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountJoinRequest {

    private String username;
    private String password;

    private String email;
    private Role role;


    @Builder
    public AccountJoinRequest(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Account toEntity() {
        return Account.builder()
                .username(this.username)
                .password(this.password)
                .email(this.email)
                .build();
    }
}
