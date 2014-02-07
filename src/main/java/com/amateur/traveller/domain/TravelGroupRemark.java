package com.amateur.traveller.domain;

import java.io.Serializable;
import java.util.Date;

public class TravelGroupRemark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8795261770953787800L;

	private int groupRemarkId;
	private String remark;
	private Date date;
	private int travelGroupId;
	private int fromAccountId;
	private int toAccountId;
	private String nickname;

	public int getGroupRemarkId() {
		return groupRemarkId;
	}

	public void setGroupRemarkId(int groupRemarkId) {
		this.groupRemarkId = groupRemarkId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTravelGroupId() {
		return travelGroupId;
	}

	public void setTravelGroupId(int travelGroupId) {
		this.travelGroupId = travelGroupId;
	}

	public int getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(int fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public int getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
