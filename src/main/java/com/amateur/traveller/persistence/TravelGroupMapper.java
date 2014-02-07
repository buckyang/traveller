package com.amateur.traveller.persistence;

import java.util.List;
import java.util.Map;

import com.amateur.traveller.domain.ScheduleNote;
import com.amateur.traveller.domain.TravelGroup;
import com.amateur.traveller.domain.TravelGroupAccount;
import com.amateur.traveller.domain.TravelGroupRemark;

public interface TravelGroupMapper {
	int insertTravelGroup(TravelGroup travelGroup);
	int insertScheduleNote(ScheduleNote scheduleNote);
	TravelGroup selectTravelGroupById(int id);
	int disableTravelGroup(TravelGroup travelGroup);
	int insertTravelGroupRemark(TravelGroupRemark travelGroupRemark);
	int insertTravelGroupAccount(TravelGroupAccount travelGroupAccount);
	List<TravelGroup> searchTravelGroups(Map map);
}
