package com.altimetrik.candidate.testapi.controller;

import com.altimetrik.candidate.testapi.entity.UserDto;
import com.altimetrik.candidate.testapi.mapper.UserMapper;
import com.altimetrik.candidate.testapi.repository.UserRepository;
import com.altimetrik.candidate.testapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.altimetrik.candidate.testapi.entity.UserEntity;
import com.altimetrik.candidate.testapi.exception.userException;

import javax.validation.Valid;
import java.util.List;

/**
 * REST Controller for User and Account creation.
 */
@RestController
@AllArgsConstructor
public class UserController {


	private UserService uService;

	private final UserRepository userRepository;


	/**
	 * REST API to save user.
	 */
	@PostMapping(value = "/save-users")
	public ResponseEntity<?> saveUsers(@Valid @RequestBody UserDto userDto)
	{
		try {
			UserDto saverUser = uService.saveUser(userDto);
			return new ResponseEntity<>(saverUser,HttpStatus.CREATED);
		} catch (userException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * REST API to get user by EMAIL.
	 */
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email)
	{
		try {
			UserDto userDto = uService.getByEmail(email);
			return new ResponseEntity<>(userDto,HttpStatus.OK);
		} catch (userException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * REST API to get all user.
	 */
	@GetMapping("/")
	public ResponseEntity<?> getAllUsers(){
		try {
			List<UserDto> user = uService.getAllUsers();
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (userException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * REST API to delete user by EMAIL.
	 */
	@DeleteMapping("/delete/email")
	public ResponseEntity<?> deleteUserByEmail(@RequestParam String email)
	{
		try {
			uService.deleteUser(email);
			return new ResponseEntity<>("User with "+email+" successfully deleted!",HttpStatus.OK);
		} catch (userException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
}


