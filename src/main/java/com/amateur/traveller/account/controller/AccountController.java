package com.amateur.traveller.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.amateur.traveller.account.dto.RegistrationDTO;
import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.account.validator.AccountValidator;
import com.amateur.traveller.session.Profile;

@Controller
@RequestMapping("/account")
@SessionAttributes("profile")
public class AccountController {
	@Autowired
	private AccountValidator accountValidator;
	@Autowired
	private AccountService accountService;

	@InitBinder("registrationDTO")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(accountValidator);
	}
	
	
	@ModelAttribute("registrationDTO")
	public RegistrationDTO createFormBeanRegistrationDTO() {
		return new RegistrationDTO();
	}
	
	
	@RequestMapping(value = "/signon", method = RequestMethod.GET)
	public void registerUser() {
	}

	@RequestMapping(value = "/signon", method = RequestMethod.POST)
	public void registerUser(@Valid @ModelAttribute("registrationDTO") RegistrationDTO registrationDTO,
			BindingResult result, @ModelAttribute("profile")Profile profile, Model m) {
		if (!result.hasErrors()) {
			if(accountService.registerUser(registrationDTO)){
				profile.setAccountDatasource(accountService.getUserByEmail(registrationDTO.getEmail()));
				profile.setStatus(Profile.EXPLICIT_LOGIN);
			}
			m.addAttribute("message", "account.registration.success");
		}
	}
	
}
