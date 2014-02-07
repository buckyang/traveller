package com.amateur.traveller.account.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.amateur.traveller.account.dto.LoginDTO;
import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.domain.Account;
@Component
public class LoginValidator implements Validator {
	@Autowired
	LocalValidatorFactoryBean validator;
	@Autowired
	private AccountService accountService;
	
	public boolean supports(Class<?> arg0) {
		return LoginDTO.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		validator.validate(arg0, arg1);
		if(arg1.hasErrors()){
			return;
		}
		LoginDTO loginDTO = (LoginDTO) arg0;
		boolean loginFailed = true;
		Account account = accountService.getUserByEmail(loginDTO.getEmail());
		if(account != null){
			if(account.getPass().equals(loginDTO.getPassword().trim())){
				loginFailed = false;
			}
		}
		if(loginFailed){
			arg1.reject("account.login.failed");
		}
	}

}
