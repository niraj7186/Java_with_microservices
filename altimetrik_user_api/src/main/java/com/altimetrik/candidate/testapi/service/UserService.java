package com.altimetrik.candidate.testapi.service;

import java.util.List;

import com.altimetrik.candidate.testapi.entity.UserDto;
import com.altimetrik.candidate.testapi.entity.UserEntity;
import com.altimetrik.candidate.testapi.exception.userException;

/**
 * User Service Interface to declare Business logic methods.
 */
public interface UserService {

	public UserDto saveUser(UserDto user) throws userException;
	
	public UserDto getByEmail(String email) throws userException;
	
	public List<UserDto> getAllUsers() throws userException;
	
	public void deleteUser(String email) throws userException;
}
