package com.amateur.traveller.travelgroup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amateur.traveller.domain.TravelGroup;
import com.amateur.traveller.travelgroup.dto.TravelGroupRemarkDTO;
import com.amateur.traveller.travelgroup.serivce.TravelGroupService;

@Controller
@RequestMapping("/travelgroup")
@SessionAttributes("profile")
public class ViewTravelGroupController {

	@Autowired
	private TravelGroupService travelGroupService;

	@RequestMapping(value = "/viewtrip")
	public void handleRequest(@RequestParam("id") int id, Model m, RedirectAttributes r) {
		TravelGroupRemarkDTO travelGroupRemarkDTO = new TravelGroupRemarkDTO();
		travelGroupRemarkDTO.setTravelGroupId(id);
		m.addAttribute(travelGroupRemarkDTO);
		
		TravelGroup travelGroup = travelGroupService.selectTravelGroupById(id);
		m.addAttribute(travelGroup);
	}

}
