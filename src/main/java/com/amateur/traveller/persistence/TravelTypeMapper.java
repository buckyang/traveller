package com.amateur.traveller.persistence;

import java.util.List;

import com.amateur.traveller.domain.TravelType;

public interface TravelTypeMapper {
	int insertTravelType(TravelType travelType);
	List<TravelType> selectTravelTypes(); 
}
