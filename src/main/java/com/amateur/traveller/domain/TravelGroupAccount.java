package com.amateur.traveller.domain;

import java.io.Serializable;
import java.util.Date;

public class TravelGroupAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2038794407047727343L;
	private Integer id;
	private Integer travelGroupId;
	private Integer accountId;
	private Date date;
	private String nickname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTravelGroupId() {
		return travelGroupId;
	}
	public void setTravelGroupId(Integer travelGroupId) {
		this.travelGroupId = travelGroupId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
}
