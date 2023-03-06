package com.altemetrik.candidate.accountapi.service;


import com.altemetrik.candidate.accountapi.entity.APIResponseDto;
import com.altemetrik.candidate.accountapi.entity.AccountDTO;
import com.altemetrik.candidate.accountapi.exception.AccountException;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getAllAccounts() throws AccountException;

    AccountDTO createAccount(AccountDTO accountDto, String email) throws AccountException;

    APIResponseDto getAccountAndUser(String email) throws AccountException;
}
