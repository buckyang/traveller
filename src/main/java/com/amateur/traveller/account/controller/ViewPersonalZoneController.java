package com.amateur.traveller.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.amateur.traveller.account.dto.FavoriteJournalDTO;
import com.amateur.traveller.account.dto.PrivateZoneDTO;
import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.journal.service.JournalService;


@Controller
@RequestMapping("/account")
public class ViewPersonalZoneController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private JournalService journalService;

	@RequestMapping(value = "/viewmpz", method = RequestMethod.GET)
	public void handleRequest(@RequestParam("id") int id, Model m,
			RedirectAttributes r) {
		PrivateZoneDTO privateZoneDTO=accountService.getPrivateZoneInfo(id);
		List<FavoriteJournalDTO> favoriteJournals=journalService.getFavoriteJouralDTO(id);
		privateZoneDTO.setFavoriteJournalList(favoriteJournals);
		m.addAttribute(privateZoneDTO);
	}
}
