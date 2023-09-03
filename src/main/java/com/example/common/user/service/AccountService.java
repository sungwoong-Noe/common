package com.example.common.user.service;

import com.example.common.domain.account.Account;
import com.example.common.dto.Response;
import com.example.common.dto.account.request.AccountJoinRequest;
import com.example.common.dto.account.response.AccountResponse;

public interface AccountService {

    Account findByUsername(String username);

    Response<AccountResponse> saveUser(AccountJoinRequest joinRequest);

}
