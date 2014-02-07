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

import com.amateur.traveller.account.dto.UpdateAccountDTO;
import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.account.validator.UpdateAccountValidator;
import com.amateur.traveller.domain.Account;
import com.amateur.traveller.session.Profile;

@Controller
@RequestMapping("/account")
@SessionAttributes("profile")
public class UpdateAccountController {
	static Logger log = Logger.getLogger(UpdateAccountController.class.getName());
	@Autowired
	private UpdateAccountValidator updateAccountValidator;
	
	@Autowired
	private AccountService accountService;
	
	@InitBinder("updateAccountDTO")
	protected void initBinder(WebDataBinder binder){
		binder.setValidator(updateAccountValidator);
	}

	@ModelAttribute("updateAccountDTO")
	public UpdateAccountDTO createFormBean(@ModelAttribute("profile") Profile profile) {
		UpdateAccountDTO updateAccountDTO = new UpdateAccountDTO();
		BeanUtils.copyProperties(profile, updateAccountDTO);
		return updateAccountDTO;
		
	}
	
	@RequestMapping(value = "/updateAccount", method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
	public void registerUser(@Valid @ModelAttribute("updateAccountDTO") UpdateAccountDTO updateAccountDTO, @ModelAttribute("profile") Profile profile,
			BindingResult result, Model m) {
		if (!result.hasErrors()) {
			if(accountService.updateUser(updateAccountDTO)){
				Account account = accountService.getUserByEmail(updateAccountDTO.getEmail());
				profile.setAccountDatasource(account);
			}
			m.addAttribute("message", "account.update.success");
		}
	}	
}
