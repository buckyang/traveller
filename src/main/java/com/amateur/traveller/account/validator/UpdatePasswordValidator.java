package com.amateur.traveller.account.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.amateur.traveller.account.dto.UpdatePasswordDTO;
import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.domain.Account;
@Component
public class UpdatePasswordValidator implements Validator{
	@Autowired
	private LocalValidatorFactoryBean validator;
	
	@Autowired
	private AccountService accountService;
	
	public boolean supports(Class<?> arg0) {
		return UpdatePasswordDTO.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		validator.validate(arg0, arg1);
		if(arg1.hasErrors()){
			return;
		}
		UpdatePasswordDTO passwordDTO = (UpdatePasswordDTO) arg0;
		Account account = accountService.getAccountBydId(passwordDTO.getAccountId());
		if(account == null){
			arg1.reject("account.invalid");
			return;
		}
		if(!account.getPass().equals(passwordDTO.getOldPass())){
			arg1.rejectValue("oldPass", "account.updatepassword.oldpass.invalid");
		}
		if(!passwordDTO.getPass().equals(passwordDTO.getRePass())){
			arg1.rejectValue("rePass", "account.updatepassword.repass.invalid");
		}
		
	}
	
	
}
