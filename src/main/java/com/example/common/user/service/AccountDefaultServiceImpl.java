package com.example.common.user.service;

import com.example.common.domain.account.Account;
import com.example.common.dto.Response;
import com.example.common.dto.account.request.AccountJoinRequest;
import com.example.common.dto.error.ErrorCode;
import com.example.common.exception.account.UsernameDuplicateException;
import com.example.common.user.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Service("accountService")
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountDefaultServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username){



        Account account = accountRepository.findByUsername(username).orElse(null);

        return account;
    }

    @Override
    @Transactional
    public Response<Account> saveUser(AccountJoinRequest joinRequest) {
        Account findByUsername = findByUsername(joinRequest.getUsername());
        if(!Objects.isNull(findByUsername)){
            throw new UsernameDuplicateException(ErrorCode.DUPLICATED_USERNAME, String.format("Username: ", joinRequest.getUsername()));
        }
        Account account = joinRequest.toEntity();
        accountRepository.save(account);
        return Response.success(account);
    }
}
