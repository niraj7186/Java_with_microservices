package com.altemetrik.candidate.accountapi.exception;


/**
 * Custom Exception class that throws graceful exception messages.
 */
public class AccountException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public AccountException(String message) {
		super(message);
	}
	
	public static String EmailExists(String email)
	{
		return email+" already exists for a user.";
	}
	
	public static String NotFoundException(String email)
	{
		return "Account with "+email+" not found";
	}

	public static String EmailMismatch(String email)
	{
		return "User email "+email+" does not match";
	}

	public static String EmptyDB()
	{
		return "DataBase empty.";
	}
	
	public static String BalanceLow(Double bal)
	{
		return "Account can not be created as your balance $"+bal+" is less than $1000.00";
	}

	public static String AccountExists(String email)
	{
		return "Account can not be created as account already exists for a user.";
	}
}
