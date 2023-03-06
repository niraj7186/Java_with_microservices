package com.altimetrik.candidate.testapi.repository;

import java.util.Optional;

import com.altimetrik.candidate.testapi.entity.UserDto;
import com.altimetrik.candidate.testapi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User Repository Interface to use all JPA Repository methods.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {


	Optional<UserEntity> findByEmail(String email);

	void deleteByEmail(String email);

}
