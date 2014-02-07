package com.amateur.traveller.persistence;

import com.amateur.traveller.domain.Account;

public interface AccountMapper {
	
	Account getUserByEmail(String email);
	
	Account getAccountById(int accountId);
	
	int registerUser(Account account);
	
	int updateUser(Account account);
	
	int updatePassword(Account account);
	
}
