package com.example.common.dto.account.response;


import com.example.common.domain.account.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {
    private String username;
    private String email;

    @Builder
    public AccountResponse(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public static AccountResponse toResponseDTO(Account account) {
        return AccountResponse.builder()
                .username(account.getUsername())
                .email(account.getEmail())
                .build();
    }
}
