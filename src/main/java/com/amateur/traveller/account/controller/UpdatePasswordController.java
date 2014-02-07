package com.amateur.traveller.account.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
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

import com.amateur.traveller.account.dto.UpdatePasswordDTO;
import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.account.validator.UpdatePasswordValidator;
import com.amateur.traveller.domain.Account;
import com.amateur.traveller.session.Profile;

@Controller
@RequestMapping("/account")
@SessionAttributes("profile")
public class UpdatePasswordController {
	static Logger log = Logger.getLogger(UpdatePasswordController.class.getName());
	@Autowired
	private UpdatePasswordValidator updatePasswordValidator;
	
	@Autowired
	private AccountService accountService;
	
	@InitBinder("updatePasswordDTO")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(updatePasswordValidator);
	}

	@ModelAttribute("updatePasswordDTO")
	public UpdatePasswordDTO createFormBean(@ModelAttribute("profile") Profile profile) {
		UpdatePasswordDTO updatePasswordDTO = new UpdatePasswordDTO();
		BeanUtils.copyProperties(profile, updatePasswordDTO);
		return updatePasswordDTO;
		
	}
	
	@RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public void registerUser(@Valid @ModelAttribute("updatePasswordDTO") UpdatePasswordDTO UpdatePasswordDTO,
			BindingResult result, Model m) {
		if (!result.hasErrors()) {
			Account account = new Account();
			account.setAccountId(UpdatePasswordDTO.getAccountId());
			account.setPass(UpdatePasswordDTO.getPass());
			if(accountService.updatePassword(account)){
				m.addAttribute("message", "account.updatepassword.success");
			}
		}
	}	
}
