package com.amateur.traveller.service;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.traveller.domain.Sequence;
import com.amateur.traveller.persistence.SequenceMapper;

@Service
public class SequenceService {
	@Autowired
	private SequenceMapper sequenceMapper;

	private String travelGroup;
	
	private String scheduleNote;
	
	private String travelType;

	private String tripRemark;
	
	private String tripAccount;
	
	private Map<String, String> sequenceInitMap;

	public int getNextTravelGroupId() {
		return getNextId(travelGroup);
	}
	
	public int getScheduleNoteId(){
		return getNextId(scheduleNote);
	}
	
	public int getTravelTypeId(){
		return getNextId(travelType);
	}
	
	public int getTripRemarkId(){
		return getNextId(tripRemark);
	}
	
	public int getTripAccountId(){
		return getNextId(tripAccount);
	}
	private int getNextId(String primaryKey) {
		return getNextSequence(primaryKey).getNextId();
	}

	private String getNextStringId(String primaryKey) {
		Sequence sequence = getNextSequence(primaryKey);
		return (sequence.getPrefix() != null ? sequence.getPrefix() : "")
				+ sequence.getNextId()
				+ (sequence.getSuffix() != null ? sequence.getSuffix() : "");
	}

	public Sequence getNextSequence(String name) {
		Sequence sequence = sequenceMapper.getSequence(name);
		if (sequence == null) {
			sequence = new Sequence();
			String sequenceInit = sequenceInitMap.get(name);
			String[] initArray = sequenceInit.split(";");
			if (StringUtils.isNotBlank(initArray[0])) {
				sequence.setPrefix(initArray[0]);
			}
			if (StringUtils.isNotBlank(initArray[2])) {
				sequence.setSuffix(initArray[2]);
			}
			sequence.setName(name);
			sequence.setNextId(NumberUtils.toInt(initArray[1]));
			sequenceMapper.insertSequence(sequence);
		}
		sequence.setNextId(sequence.getNextId() + 1);
		sequenceMapper.updateSequence(sequence);
		return sequence;
	}

	public String getTravelGroup() {
		return travelGroup;
	}

	public void setTravelGroup(String travelGroup) {
		this.travelGroup = travelGroup;
	}

	public Map<String, String> getSequenceInitMap() {
		return sequenceInitMap;
	}

	public void setSequenceInitMap(Map<String, String> sequenceInitMap) {
		this.sequenceInitMap = sequenceInitMap;
	}

	public String getScheduleNote() {
		return scheduleNote;
	}

	public void setScheduleNote(String scheduleNote) {
		this.scheduleNote = scheduleNote;
	}

	public String getTravelType() {
		return travelType;
	}

	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}

	public String getTripRemark() {
		return tripRemark;
	}

	public void setTripRemark(String tripRemark) {
		this.tripRemark = tripRemark;
	}

	public String getTripAccount() {
		return tripAccount;
	}

	public void setTripAccount(String tripAccount) {
		this.tripAccount = tripAccount;
	}

}
