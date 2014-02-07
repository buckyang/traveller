package com.amateur.traveller.travelgroup.controller;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amateur.traveller.domain.TravelGroupRemark;
import com.amateur.traveller.session.Profile;
import com.amateur.traveller.travelgroup.dto.TravelGroupRemarkDTO;
import com.amateur.traveller.travelgroup.serivce.TravelGroupService;

@Controller
@RequestMapping("/travelgroup")
@SessionAttributes("profile")
public class NewTravelGroupRemarkController {

	@Autowired
	private TravelGroupService travelGroupService;

	@RequestMapping(value = "/newremark")
	public String handleRequest(TravelGroupRemarkDTO travelGroupRemarkDTO, @ModelAttribute("profile") Profile profile, RedirectAttributes r) {
		if (StringUtils.isNotEmpty(travelGroupRemarkDTO.getRemark())) {
			TravelGroupRemark travelGroupRemark = new TravelGroupRemark();
			BeanUtils.copyProperties(travelGroupRemarkDTO, travelGroupRemark);
			travelGroupRemark.setDate(new Date());
			travelGroupRemark.setFromAccountId(profile.getAccountId());
			if (travelGroupService.insertTravelGroupRemark(travelGroupRemark)) {
				r.addFlashAttribute("message", "travelgroup.remark.new.success");
			}else{
				r.addFlashAttribute("message", "travelgroup.remark.new.failure");
			}
		} else {
			r.addFlashAttribute("message", "travelgroup.remark.new.emptyremark");
		}
		r.addAttribute("id", travelGroupRemarkDTO.getTravelGroupId());
		return "redirect:viewtrip";
	}

}
