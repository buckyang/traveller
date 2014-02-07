package com.amateur.traveller.account.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.amateur.traveller.account.dto.UpdateAccountDTO;

@Component
public class UpdateAccountValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return UpdateAccountDTO.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		UpdateAccountDTO updateAccountDTO = (UpdateAccountDTO) arg0;
	}

}
