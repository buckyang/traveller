package com.amateur.traveller.account.dto;

import java.io.Serializable;
import java.util.List;

public class PrivateZoneDTO implements Serializable {

	private static final long serialVersionUID = -8023887994534433762L;

	private UserBasicInfoDTO personalInfo;

	private List<FavoriteJournalDTO> favoriteJournalList;

	private FollowShipDTO followShip;

	private String errorMsg;

	public UserBasicInfoDTO getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(UserBasicInfoDTO personalInfo) {
		this.personalInfo = personalInfo;
	}

	public List<FavoriteJournalDTO> getFavoriteJournalList() {
		return favoriteJournalList;
	}

	public void setFavoriteJournalList(
			List<FavoriteJournalDTO> favoriteJournalList) {
		this.favoriteJournalList = favoriteJournalList;
	}

	public FollowShipDTO getFollowShip() {
		return followShip;
	}

	public void setFollowShip(FollowShipDTO followShip) {
		this.followShip = followShip;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
