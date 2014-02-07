package com.amateur.traveller.domain;

import java.io.Serializable;

public class TravelType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1987628762085028267L;
	private int travelTypeId;
	private String typeName;
	private int sortOrder;
	
	public int getTravelTypeId() {
		return travelTypeId;
	}
	public void setTravelTypeId(int travelTypeId) {
		this.travelTypeId = travelTypeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	
}
