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

import com.amateur.traveller.account.dto.LoginDTO;
import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.account.validator.LoginValidator;
import com.amateur.traveller.domain.Account;
import com.amateur.traveller.session.Profile;

@Controller
@RequestMapping("/account")
@SessionAttributes("profile")
public class LoginController {
	@Autowired
	private LoginValidator loginValidator;

	@Autowired
	private AccountService accountService;

	@InitBinder("loginDTO")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(loginValidator);
	}
	
	@ModelAttribute("loginDTO")
	public LoginDTO createFormBean() {
		return new LoginDTO();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@Valid @ModelAttribute("loginDTO") LoginDTO loginDTO,
			BindingResult result, Model m) {
		if (!result.hasErrors()) {
		
			Account account = accountService.getUserByEmail(loginDTO.getEmail());
			if(account != null){
				Profile profile = new Profile();
				profile.setAccountDatasource(account);
				profile.setStatus(Profile.EXPLICIT_LOGIN);
				m.addAttribute("profile", profile);
			}
			m.addAttribute("message", "登陆成功");
		}
	}
}
