package com.amateur.traveller.travelgroup.dto;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

public class TravelGroupDTO {

	private int travelGroupId;
	private String fromResort;
	private String fromAddress;
	private String fromCity;
	private String arrivalCity;
	private String arrivalResort;
	@NotNull
	@Future
	private Date fromDate;
	private Integer days;
	private Double budget;
	private String note;
	private String topic;
	private String type;
	private Integer initiator;
	private Integer count;
	private boolean disable = false;
	
	private ScheduleNoteDTO[] scheduleNoteDTOs;
	
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
	public boolean isDisable() {
		return disable;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	public int getTravelGroupId() {
		return travelGroupId;
	}
	public void setTravelGroupId(int travelGroupId) {
		this.travelGroupId = travelGroupId;
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
	public ScheduleNoteDTO[] getScheduleNoteDTOs() {
		return scheduleNoteDTOs;
	}
	public void setScheduleNoteDTOs(ScheduleNoteDTO[] scheduleNoteDTOs) {
		this.scheduleNoteDTOs = scheduleNoteDTOs;
	}
	
}
