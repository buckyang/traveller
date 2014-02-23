package com.amateur.traveller.journal.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.traveller.account.dto.FavoriteJournalDTO;
import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.domain.FavoriteJournal;
import com.amateur.traveller.persistence.JournalMapper;
@Service
public class JournalService {
	private static final Logger log = Logger.getLogger(AccountService.class);

	@Autowired
	private JournalMapper journalMapper;

	public List<FavoriteJournal> getFavoriteJournal(int accountId) {
		return journalMapper.getFavoriteJournal(accountId);
	}

	@SuppressWarnings("unchecked")
	public List<FavoriteJournalDTO> getFavoriteJouralDTO(int accountId) {
		List<FavoriteJournal> favoriteJournals = getFavoriteJournal(accountId);
		if (favoriteJournals == null || favoriteJournals.isEmpty()) {
			return Collections.EMPTY_LIST;
		}
		List<FavoriteJournalDTO> favoriteJournalList = new ArrayList<FavoriteJournalDTO>(
				favoriteJournals.size());
		for (FavoriteJournal favoriteJournal : favoriteJournals) {
			FavoriteJournalDTO favoritejournalDTO = new FavoriteJournalDTO();
			BeanUtils.copyProperties(favoriteJournal, favoritejournalDTO);
			favoriteJournalList.add(favoritejournalDTO);
		}
		return favoriteJournalList;
	}

}
