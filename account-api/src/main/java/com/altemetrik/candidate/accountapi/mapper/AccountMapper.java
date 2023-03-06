package com.altemetrik.candidate.accountapi.mapper;

import com.altemetrik.candidate.accountapi.entity.AccountDTO;
import com.altemetrik.candidate.accountapi.entity.AccountEntity;

public class AccountMapper {

    //convert JPA entity to DTO
    public static AccountDTO mapToAccountDto(AccountEntity account){
        AccountDTO accountDTO = new AccountDTO(
                account.getId(),
                account.getEmail(),
                account.getPassword(),
                account.getBalance()
        );
        return accountDTO;
    }

    //convert DTO to JPA entity
    public static AccountEntity mapToAccountJpa(AccountDTO accountDTO) {
        AccountEntity accountEntity = new AccountEntity(
                accountDTO.getId(),
                accountDTO.getEmail(),
                accountDTO.getPassword(),
                accountDTO.getBalance()
        );
        return accountEntity;
    }
}
