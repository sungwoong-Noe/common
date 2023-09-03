package com.example.common.user;

import com.example.common.domain.account.Account;
import com.example.common.dto.Response;
import com.example.common.dto.account.request.AccountJoinRequest;
import com.example.common.user.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final AccountService accountService;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody AccountJoinRequest request) {
        Response<Account> accountResponse = accountService.saveUser(request);

        return ResponseEntity.ok().body(accountResponse.getResult());
    }


}
