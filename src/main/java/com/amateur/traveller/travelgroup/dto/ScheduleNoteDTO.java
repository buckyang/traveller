package com.amateur.traveller.travelgroup.dto;

public class ScheduleNoteDTO {
	private int dayNumber;
	private String note;
	private int travelGroupId;
	
	public int getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(int dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int getTravelGroupId() {
		return travelGroupId;
	}
	public void setTravelGroupId(int travelGroupId) {
		this.travelGroupId = travelGroupId;
	}
}
