package com.example.common.user.service;

import com.example.common.domain.account.Account;
import com.example.common.dto.Response;
import com.example.common.dto.account.request.AccountJoinRequest;
import com.example.common.dto.account.response.AccountResponse;
import com.example.common.dto.error.ErrorCode;
import com.example.common.exception.account.UsernameDuplicateException;
import com.example.common.user.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Slf4j
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
    public Response<AccountResponse> saveUser(AccountJoinRequest joinRequest) {

        Optional<Account> byUsername = accountRepository.findByUsername(joinRequest.getUsername());


        if(byUsername.isPresent()){
            throw new UsernameDuplicateException(ErrorCode.DUPLICATED_USERNAME, String.format("Username: ", joinRequest.getUsername()));
        }

        Account account = joinRequest.toEntity();
        accountRepository.save(account);

        AccountResponse response = AccountResponse.toResponseDTO(account);

        return Response.success(response);
    }
}
