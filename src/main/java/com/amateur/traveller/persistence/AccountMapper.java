package com.amateur.traveller.persistence;

import com.amateur.traveller.domain.Account;

public interface AccountMapper {
	
	Account getUserByEmail(String email);
	
	int registerUser(Account account);
	
}
