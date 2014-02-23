package com.amateur.traveller.persistence;

import java.util.List;

import com.amateur.traveller.domain.FavoriteJournal;

public interface JournalMapper {

	List<FavoriteJournal> getFavoriteJournal(int accountId);
}
