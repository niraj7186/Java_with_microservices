package com.altemetrik.candidate.accountapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Email;

/**
 * Account Model Class to map Account Entity Fields.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

	private Long id;
	@Email
	private String email;
	@JsonIgnore
	private String password;
	
	private Double balance;


}
