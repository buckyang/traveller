package com.amateur.traveller.account.dto;

import java.io.Serializable;

public class FavoriteJournalDTO implements Serializable {

	private static final long serialVersionUID = 6419951069979255437L;

	private String title;

	private String imageUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
