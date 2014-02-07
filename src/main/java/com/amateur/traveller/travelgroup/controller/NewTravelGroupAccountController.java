package com.amateur.traveller.travelgroup.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amateur.traveller.domain.TravelGroupAccount;
import com.amateur.traveller.session.Profile;
import com.amateur.traveller.travelgroup.serivce.TravelGroupService;

@Controller
@RequestMapping("/travelgroup")
@SessionAttributes("profile")
public class NewTravelGroupAccountController {

	@Autowired
	private TravelGroupService travelGroupService;

	@RequestMapping(value = "/jointrip")
	public String handleRequest(@RequestParam("id") int id, @ModelAttribute("profile") Profile profile, RedirectAttributes r) {
		TravelGroupAccount tripAccount = new TravelGroupAccount();
		tripAccount.setDate(new Date());
		tripAccount.setAccountId(profile.getAccountId());
		tripAccount.setTravelGroupId(id);
		if(travelGroupService.insertTravelGroupAccount(tripAccount)){
			r.addFlashAttribute("message", "travelgroup.account.join。success");
		}
		r.addAttribute("id", id);
		return "redirect:viewtrip";
	}

}
