package com.amateur.traveller.account.dto;

import java.io.Serializable;
import java.util.List;

public class FollowShipDTO implements Serializable {

	private static final long serialVersionUID = 4885109399315813255L;

	private List<UserBasicInfoDTO> followerList;

	private List<UserBasicInfoDTO> followeeList;

	public List<UserBasicInfoDTO> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(List<UserBasicInfoDTO> followerList) {
		this.followerList = followerList;
	}

	public List<UserBasicInfoDTO> getFolloweeList() {
		return followeeList;
	}

	public void setFolloweeList(List<UserBasicInfoDTO> followeeList) {
		this.followeeList = followeeList;
	}

}
