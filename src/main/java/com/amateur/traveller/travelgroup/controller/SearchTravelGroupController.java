package com.amateur.traveller.travelgroup.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amateur.admin.traveltype.service.TravelTypeService;
import com.amateur.traveller.domain.TravelGroup;
import com.amateur.traveller.travelgroup.dto.SearchTravelGroupDTO;
import com.amateur.traveller.travelgroup.serivce.TravelGroupService;

@Controller
@RequestMapping("/travelgroup")
public class SearchTravelGroupController {

	@Autowired
	private TravelGroupService travelGroupService;
	
	@Autowired
	private TravelTypeService travelTypeService;

	@ModelAttribute("searchTravelGroupDTO")
	public void createFormBean(Model m) {
		SearchTravelGroupDTO searchTravelGroupDTO = new SearchTravelGroupDTO();
		m.addAttribute(searchTravelGroupDTO);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public void form() {
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public void handlePost(@Valid @ModelAttribute("searchTravelGroupDTO") SearchTravelGroupDTO searchTravelGroupDTO,
			BindingResult result, Model m) {
		String generatedSQL = generateQuerySQL(searchTravelGroupDTO);
		List<TravelGroup> travelGroups = travelGroupService.searchTravelGroups(generatedSQL);
		m.addAttribute(travelGroups);
	}
	private String generateQuerySQL(SearchTravelGroupDTO searchTravelGroupDTO){
		StringBuilder sb = new StringBuilder();
		if(StringUtils.isNotBlank(searchTravelGroupDTO.getFromCity())){
			if(sb.length() != 0){
				sb.append(" and ");
			}
			sb.append(" t.from_city = \"");
			sb.append(searchTravelGroupDTO.getFromCity());
			sb.append("\"");
		}
		if(StringUtils.isNotBlank(searchTravelGroupDTO.getArrivalCity())){
			if(sb.length() != 0){
				sb.append(" and ");
			}
			sb.append(" t.arrival_city = \"");
			sb.append(searchTravelGroupDTO.getArrivalCity());
			sb.append("\"");
		}
		if(StringUtils.isNotBlank(searchTravelGroupDTO.getBeginDate())){
			if(sb.length() != 0){
				sb.append(" and ");
			}
			sb.append(" t.from_date = \"");
			sb.append(searchTravelGroupDTO.getBeginDate());
			sb.append("\"");
		}		
		sb.append(" limit 0,10");
		return sb.toString();
	}
}
