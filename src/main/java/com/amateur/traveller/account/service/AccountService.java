package com.amateur.traveller.account.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.traveller.account.dto.RegistrationDTO;
import com.amateur.traveller.account.dto.UpdateAccountDTO;
import com.amateur.traveller.domain.Account;
import com.amateur.traveller.persistence.AccountMapper;

@Service
public class AccountService {
	@Autowired
	private AccountMapper accountMapper;
	
	public Account getUserByEmail(String email){
		return accountMapper.getUserByEmail(email);
	}
	public Account getAccountBydId(int accountId){
		return accountMapper.getAccountById(accountId);
	}
	
	public boolean registerUser(RegistrationDTO registration){
		if(StringUtils.isEmpty(registration.getEmail())){
			throw new IllegalArgumentException("Email can not be null");
		}
		if(StringUtils.isEmpty(registration.getPassword())){
			throw new IllegalArgumentException("Pass can not be null");
		}
		Account user = new Account();
		user.setEmail(registration.getEmail());
		user.setPass(registration.getPassword());
		user.setNickname(registration.getNickname());
		user.setSex(registration.getGender());
		if(accountMapper.registerUser(user) > 0){
			return true;
		}
		return false;
	}
	public boolean updateUser(UpdateAccountDTO updateAccountDTO){
		Account account = new Account();
		BeanUtils.copyProperties(updateAccountDTO, account);
		if(accountMapper.updateUser(account) > 0){
			return true;
		}
		return false;
	}
	
	public boolean updatePassword(Account account){
		if(account == null){
			throw new IllegalArgumentException("Account parameter can not be null");
		}
		if(accountMapper.updatePassword(account)>0){
			return true;
		}
		return false;
	}
}
