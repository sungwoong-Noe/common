package com.example.common.security.service.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;

@Getter
public class UserPrincipal extends User  {

    private final Long accountId;
    public UserPrincipal(String username, String password, Long accountId) {
        super(username, password, List.of(new SimpleGrantedAuthority("ADMIN")));
        this.accountId = accountId;

    }
}
