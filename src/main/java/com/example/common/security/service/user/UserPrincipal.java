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


    //role : 역할 -> 관리자, 사용자, 매니저
    //authority: 권한 -> 글 쓰기, 글 읽기, 사용자 정지시키기

    public UserPrincipal(String username, String password, Long accountId) {
        super(username, password,
                List.of(
                        new SimpleGrantedAuthority("ROLE_USER")
//                        ,new SimpleGrantedAuthority("WRITE")
                ));
        this.accountId = accountId;
    }
}
