package com.amateur.traveller.domain;

import java.io.Serializable;

public class ScheduleNote implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1135041946418693864L;

	private int scheduleNoteId;
	private int dayNumber;
	private String note;
	private int travelGroupId;
	public int getScheduleNoteId() {
		return scheduleNoteId;
	}
	public void setScheduleNoteId(int scheduleNoteId) {
		this.scheduleNoteId = scheduleNoteId;
	}
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
