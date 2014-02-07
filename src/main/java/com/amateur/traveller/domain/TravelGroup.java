package com.amateur.traveller.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TravelGroup implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -813372657408112759L;
	
	private Integer travelGroupId;
	private String fromResort;
	private String fromAddress;
	private String fromCity;
	private String arrivalCity;
	private String arrivalResort;
	private Date fromDate;
	private Integer days;
	private Double budget;
	private String note;
	private String type;
	private String topic;
	private Integer initiator;
	private Integer disable;
	private Integer count;
	private List<ScheduleNote> scheduleNotes;
	private List<TravelGroupRemark> travelGroupRemarks;
	private List<TravelGroupAccount> travelGroupAccounts;
	
	public Integer getTravelGroupId() {
		return travelGroupId;
	}
	public void setTravelGroupId(Integer travelGroupId) {
		this.travelGroupId = travelGroupId;
	}
	public String getFromResort() {
		return fromResort;
	}
	public void setFromResort(String fromResort) {
		this.fromResort = fromResort;
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getArrivalResort() {
		return arrivalResort;
	}
	public void setArrivalResort(String arrivalResort) {
		this.arrivalResort = arrivalResort;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getInitiator() {
		return initiator;
	}
	public void setInitiator(Integer initiator) {
		this.initiator = initiator;
	}
	public Integer getDisable() {
		return disable;
	}
	public void setDisable(Integer disable) {
		this.disable = disable;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<ScheduleNote> getScheduleNotes() {
		return scheduleNotes;
	}
	public void setScheduleNotes(List<ScheduleNote> scheduleNotes) {
		this.scheduleNotes = scheduleNotes;
	}
	public List<TravelGroupRemark> getTravelGroupRemarks() {
		return travelGroupRemarks;
	}
	public void setTravelGroupRemarks(List<TravelGroupRemark> travelGroupRemarks) {
		this.travelGroupRemarks = travelGroupRemarks;
	}
	public List<TravelGroupAccount> getTravelGroupAccounts() {
		return travelGroupAccounts;
	}
	public void setTravelGroupAccounts(List<TravelGroupAccount> travelGroupAccounts) {
		this.travelGroupAccounts = travelGroupAccounts;
	}
	
	
}
