package com.amateur.traveller.travelgroup.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.amateur.traveller.travelgroup.dto.TravelGroupDTO;
@Component
public class TravelGroupValidator implements Validator {
	@Autowired
	private LocalValidatorFactoryBean validator;
	public boolean supports(Class<?> arg0) {
		return TravelGroupDTO.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		validator.validate(arg0, arg1);
		if(arg1.hasErrors()){
			return;
		}
	}

}
