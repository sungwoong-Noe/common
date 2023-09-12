package com.example.common.security.service;

import com.example.common.domain.account.Account;
import com.example.common.security.service.user.UserPrincipal;
import com.example.common.user.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value="userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username + "정보를 찾을 수 없습니다."));

        UserDetails userPrincipal = new UserPrincipal(account.getUsername(), account.getPassword(), account.getId());

        log.info("{}님 Login Success", account.getUsername());

        return userPrincipal;
    }
}
