package com.amateur.traveller.travelgroup.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

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

import com.amateur.admin.traveltype.dto.TravelTypeDTO;
import com.amateur.admin.traveltype.service.TravelTypeService;
import com.amateur.traveller.domain.ScheduleNote;
import com.amateur.traveller.domain.TravelGroup;
import com.amateur.traveller.domain.TravelType;
import com.amateur.traveller.session.Profile;
import com.amateur.traveller.travelgroup.dto.ScheduleNoteDTO;
import com.amateur.traveller.travelgroup.dto.TravelGroupDTO;
import com.amateur.traveller.travelgroup.serivce.TravelGroupService;
import com.amateur.traveller.travelgroup.validator.TravelGroupValidator;

@Controller
@RequestMapping("/travelgroup")
@SessionAttributes("profile")
public class EditTravelGroupController {
	@Autowired
	private TravelGroupValidator travelGroupValidator;

	@Autowired
	private TravelGroupService travelGroupService;
	
	@Autowired
	private TravelTypeService travelTypeService;

	@InitBinder("travelGroupDTO")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(travelGroupValidator);
	}
	
	@ModelAttribute("travelGroupDTO")
	public void createFormBean(@ModelAttribute("profile") Profile profile, Model m) {
		TravelGroupDTO travelGroupDTO = new TravelGroupDTO();
		travelGroupDTO.setInitiator(profile.getAccountId());
		m.addAttribute(travelGroupDTO);
		//travel types
		List<TravelTypeDTO> travelTypeDTOs = new ArrayList<TravelTypeDTO>();
		List<TravelType> travelTypes = travelTypeService.selectTravelTypes();
		for(TravelType travelType : travelTypes){
			TravelTypeDTO travelTypeDTO = new TravelTypeDTO();
			BeanUtils.copyProperties(travelType, travelTypeDTO);
			travelTypeDTOs.add(travelTypeDTO);
		}
		m.addAttribute(travelTypeDTOs);
		
	}
	
}
