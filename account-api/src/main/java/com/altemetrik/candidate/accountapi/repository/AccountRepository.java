package com.altemetrik.candidate.accountapi.repository;

import com.altemetrik.candidate.accountapi.entity.AccountDTO;
import com.altemetrik.candidate.accountapi.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByEmail(String email);
}
