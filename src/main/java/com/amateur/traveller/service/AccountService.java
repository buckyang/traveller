package com.amateur.traveller.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.traveller.domain.Account;
import com.amateur.traveller.persistence.AccountMapper;

@Service
public class AccountService {
	@Autowired
	private AccountMapper accountMapper;
	
	public Account getUserByEmail(String email){
		return accountMapper.getUserByEmail(email);
	}
	
	public boolean registerUser(String email, String pass, String nickName, int sex){
		if(StringUtils.isEmpty(email)){
			throw new IllegalArgumentException("Email can not be null");
		}
		if(StringUtils.isEmpty(pass)){
			throw new IllegalArgumentException("Pass can not be null");
		}
		Account user = new Account();
		user.setEmail(email);
		user.setPass(pass);
		user.setNickname(nickName);
		user.setSex(sex);
		if(accountMapper.registerUser(user) > 0){
			return true;
		}
		return false;
	}
}
