package com.altimetrik.candidate.testapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import com.altimetrik.candidate.testapi.entity.UserDto;
import com.altimetrik.candidate.testapi.entity.UserEntity;
import com.altimetrik.candidate.testapi.mapper.UserMapper;
import com.altimetrik.candidate.testapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.altimetrik.candidate.testapi.exception.userException;

/**
 * User Service Implementation Class to define Business logic methods implemented in the Interface UserService.
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	
	private UserRepository uRepo;


	@Override
	public UserDto saveUser(UserDto userDto) throws userException, ConstraintViolationException {
		UserEntity user = UserMapper.mapToEntity(userDto);
		Optional<UserEntity> email = uRepo.findByEmail(user.getEmail());
		if(email.isPresent())
		{
			throw new userException(userException.EmailExists(user.getEmail()));
		}
		UserEntity savedUser = uRepo.save(user);
		return UserMapper.mapToUserDto(savedUser);
	}

	@Override
	public UserDto getByEmail(String email) throws userException {
		Optional<UserEntity> found = uRepo.findByEmail(email);
		if(!found.isPresent()) {
			throw new userException(userException.NotFoundException(email));
		}
		UserEntity user = found.get();
		return UserMapper.mapToUserDto(found.get());
	}

	@Override
	public List<UserDto> getAllUsers() throws userException{
		List<UserEntity> allusers = uRepo.findAll();
		if (allusers.isEmpty()) {
			throw new userException(userException.EmptyDB());
		}
		else {
			return new ArrayList<>(allusers.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList()));
		}
	}

	@Override
	@Transactional
	public void deleteUser(String email) throws userException {
		Optional<UserEntity> found = uRepo.findByEmail(email);
		if(!found.isPresent())
		{
			throw new userException(userException.NotFoundException(email));
		}
		else
		{
			uRepo.deleteByEmail(email);
		}
		
		
	}

	
}

