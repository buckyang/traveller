package com.amateur.admin.traveltype.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amateur.admin.traveltype.dto.TravelTypeDTO;
import com.amateur.admin.traveltype.service.TravelTypeService;
import com.amateur.traveller.domain.TravelType;
import com.amateur.traveller.service.SequenceService;

@Controller
@RequestMapping("/admin/traveltype")
public class TravelTypeController {
	@Autowired
	private TravelTypeService travelTypeService;
	@Autowired
	private SequenceService sequenceService;
	
	@ModelAttribute("travelTypeDTO")
	public TravelTypeDTO createFormBean() {
		TravelTypeDTO travelTypeDTO = new TravelTypeDTO();
		return travelTypeDTO;
	}
	
	@RequestMapping(value = "/newtype", method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(value = "/newtype", method = RequestMethod.POST)
	public void handlePost(@Valid @ModelAttribute("travelGroupDTO") TravelTypeDTO travelGroupDTO,
			BindingResult result, Model m) {
		if (!result.hasErrors()) {
			TravelType travelType = new TravelType();
			travelType.setTravelTypeId(sequenceService.getTravelTypeId());
			BeanUtils.copyProperties(travelGroupDTO, travelType);
			travelTypeService.insertTravelType(travelType);
			m.addAttribute("message", "admin.traveltype.new.success");
		}
	}
}
