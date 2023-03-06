package com.altemetrik.candidate.accountapi.service;

import com.altemetrik.candidate.accountapi.entity.APIResponseDto;
import com.altemetrik.candidate.accountapi.entity.AccountDTO;
import com.altemetrik.candidate.accountapi.entity.AccountEntity;
import com.altemetrik.candidate.accountapi.entity.UserDto;
import com.altemetrik.candidate.accountapi.exception.AccountException;
import com.altemetrik.candidate.accountapi.mapper.AccountMapper;
import com.altemetrik.candidate.accountapi.repository.AccountRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {


    private AccountRepository accountRepository;

    //private RestTemplate restTemplate;
    private APIClient apiClient;


    @Override
    public List<AccountDTO> getAllAccounts() throws AccountException {
        List<AccountEntity> allAccounts = accountRepository.findAll();

        if (allAccounts.isEmpty()) {
            throw new AccountException(AccountException.EmptyDB());
        } else {

            return new ArrayList<>(allAccounts.stream().map(AccountMapper::mapToAccountDto)
                    .collect(Collectors.toList()));
        }
    }

    @CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultUser")
    @Override
    public AccountDTO createAccount(AccountDTO accountDto, String email) throws AccountException {
        Optional<AccountEntity> account_Found = accountRepository.findByEmail(email);

        //using API Client (open feign)
        UserDto userDto = apiClient.getUserByEmail(email);

        // using RestTemplate
//       ResponseEntity<UserDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/user/email/"+email,UserDto.class);
//       UserDto userDto = responseEntity.getBody();

        if (account_Found.isPresent()) {
            throw new AccountException(AccountException.AccountExists(email));
        } else if (!accountDto.getEmail().equals(email)) {
            throw new AccountException(AccountException.EmailMismatch(email));
        } else if (userDto.equals(email)) {
            throw new AccountException(AccountException.NotFoundException(email));
        } else {
            Double monthlySalary = userDto.getMonthlySalary();
            Double monthExp = userDto.getMonthlyExp();
            if (monthlySalary - monthExp >= 1000) {
                accountDto.setBalance(monthlySalary - monthExp);
                AccountEntity accEntity = AccountMapper.mapToAccountJpa(accountDto);
                AccountEntity savedAccount = accountRepository.save(accEntity);
                return AccountMapper.mapToAccountDto(savedAccount);
            } else {
                throw new AccountException(AccountException.BalanceLow(monthlySalary - monthExp));
            }
        }
    }

    @Override
    public APIResponseDto getAccountAndUser(String email) throws AccountException {

        Optional<AccountEntity> account_Found = accountRepository.findByEmail(email);

        if (!account_Found.isPresent()) {
            throw new AccountException(AccountException.NotFoundException(email));
        }
        //using API Client (open feign)
        UserDto userDto = apiClient.getUserByEmail(email);
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setAccount(AccountMapper.mapToAccountDto(account_Found.get()));
        apiResponseDto.setUser(userDto);
        return apiResponseDto;
    }


    public AccountDTO getDefaultUser(AccountDTO accountDto, String email, Exception exception) throws AccountException {
        Optional<AccountEntity> account_Found_Default = accountRepository.findByEmail(email);

        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setName("Default");
        userDto.setEmail("default@gmail.com");
        userDto.setMonthlySalary(5000.00);
        userDto.setMonthlyExp(2000.00);

        if (account_Found_Default.isPresent()) {
            throw new AccountException(AccountException.AccountExists(email));
        } else if (!accountDto.getEmail().equals(email)) {
            throw new AccountException(AccountException.EmailMismatch(email));
        } else if (userDto.equals(email)) {
            throw new AccountException(AccountException.NotFoundException(email));
        } else {
            Double monthlySalary = userDto.getMonthlySalary();
            Double monthExp = userDto.getMonthlyExp();
            if (monthlySalary - monthExp >= 1000) {
                accountDto.setBalance(monthlySalary - monthExp);
                AccountEntity accEntity = AccountMapper.mapToAccountJpa(accountDto);
                AccountEntity savedAccount = accountRepository.save(accEntity);
                return AccountMapper.mapToAccountDto(savedAccount);
            } else {
                throw new AccountException(AccountException.BalanceLow(monthlySalary - monthExp));
            }
        }
    }
}
