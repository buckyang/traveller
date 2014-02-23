package com.amateur.traveller.account.dto;

import java.io.Serializable;

public class UserBasicInfoDTO implements Serializable {
	private static final long serialVersionUID = -6220739970175435943L;

	private String nickname;

	private String imageUrl;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
