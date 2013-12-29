package com.amateur.traveller.controller;

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

import com.amateur.traveller.dto.RegistrationDTO;
import com.amateur.traveller.service.AccountService;
import com.amateur.traveller.validator.AccountValidator;

@Controller
@RequestMapping("/account")
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
	public RegistrationDTO createFormBean() {
		return new RegistrationDTO();
	}
	
	@RequestMapping(value = "/signon", method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(value = "/signon", method = RequestMethod.POST)
	public void registerUser(@Valid @ModelAttribute("registrationDTO") RegistrationDTO registrationDTO,
			BindingResult result, Model m) {
		if (!result.hasErrors()) {
			accountService.registerUser(registrationDTO.getEmail(), registrationDTO.getPassword(), registrationDTO.getNickname(), 0);
			m.addAttribute("message", "注册成功");
		}
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String loadTestPage(Model m) {

		m.addAttribute("account",
				accountService.getUserByEmail("buckyang@aaxischina.com"));
		return "test";
	}
}
