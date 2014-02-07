package com.amateur.traveller.travelgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amateur.traveller.domain.TravelGroup;
import com.amateur.traveller.session.Profile;
import com.amateur.traveller.travelgroup.serivce.TravelGroupService;

@Controller
@RequestMapping("/travelgroup")
@SessionAttributes("profile")
public class DisableTravelGroupController {

	@Autowired
	private TravelGroupService travelGroupService;

	@RequestMapping(value = "/disabletrip")
	public String handleRequest(@RequestParam("id") int id, @ModelAttribute("profile") Profile profile, RedirectAttributes r) {
		TravelGroup travelGroup = new TravelGroup();
		travelGroup.setTravelGroupId(id);
		travelGroup.setInitiator(profile.getAccountId());
		if(travelGroupService.disableTravelGroup(travelGroup)){
			r.addAttribute("message", "travelgroup.disable.success");
		}else{
			r.addAttribute("message", "travelgroup.disable.failure");
		}
		return "redirect:viewtrip?id=" + id;
	}

}
