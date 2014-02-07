package com.amateur.traveller.account.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.amateur.traveller.account.dto.RegistrationDTO;
import com.amateur.traveller.persistence.AccountMapper;

@Service
public class AccountValidator implements Validator {
	
	@Autowired
	private AccountMapper accountMapper;
	
	public boolean supports(Class<?> clazz) {
        return RegistrationDTO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		RegistrationDTO registration = (RegistrationDTO) target;
		if(StringUtils.isEmpty(registration.getEmail()) || !StringUtils.contains(registration.getEmail(), "@")){
			errors.rejectValue("email", "account.email.invalid");
		}else{
			if(accountMapper.getUserByEmail(registration.getEmail())!= null){
				errors.rejectValue("email", "account.email.existing");
			}
		}
		if(StringUtils.isEmpty(registration.getPassword()) || registration.getPassword().length() < 6){
			errors.rejectValue("password", "account.pass.invalid");
		}
		if(registration.getPassword() != null && !registration.getPassword().equals(registration.getRePassword())){
			errors.rejectValue("rePassword", "account.repassword.notequal");
		}
		if(StringUtils.isEmpty("nickname")){
			errors.rejectValue("nickname", "account.nickname.invalid");
		}
	}

}
