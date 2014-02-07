package com.amateur.traveller.travelgroup.serivce;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.traveller.domain.ScheduleNote;
import com.amateur.traveller.domain.TravelGroup;
import com.amateur.traveller.domain.TravelGroupAccount;
import com.amateur.traveller.domain.TravelGroupRemark;
import com.amateur.traveller.persistence.TravelGroupMapper;
import com.amateur.traveller.service.SequenceService;

@Service
public class TravelGroupService {
	@Autowired
	private TravelGroupMapper travelGroupMapper;
	@Autowired
	private SequenceService sequenceService;
	
	public boolean insertTravelGroup(TravelGroup travelGroup){
		if(travelGroup == null){
			throw new IllegalArgumentException("Travel group parameter can not be nulll");
		}
		travelGroup.setTravelGroupId(sequenceService.getNextTravelGroupId());
		if(travelGroupMapper.insertTravelGroup(travelGroup) > 0){
			return true;
		}
		return false;
	}
	
	public boolean insertScheduleNote(ScheduleNote scheduleNote){
		if(scheduleNote == null){
			throw new IllegalArgumentException("Schedule note parameter can not be null");
		}
		scheduleNote.setScheduleNoteId(sequenceService.getScheduleNoteId());
		if(travelGroupMapper.insertScheduleNote(scheduleNote)>0){
			return true;
		}
		return false;
	}
	
	public TravelGroup selectTravelGroupById(int id){
		return travelGroupMapper.selectTravelGroupById(id);
	}
	public boolean disableTravelGroup(TravelGroup travelGroup){
		if(travelGroupMapper.disableTravelGroup(travelGroup) > 0){
			return true;
		}
		return false;
	}
	public boolean insertTravelGroupRemark(TravelGroupRemark travelGroupRemark){
		travelGroupRemark.setGroupRemarkId(sequenceService.getTripRemarkId());
		travelGroupRemark.setToAccountId(travelGroupRemark.getFromAccountId());
		if(travelGroupMapper.insertTravelGroupRemark(travelGroupRemark) > 0){
			return true;
		}
		return false;
	}
	public boolean insertTravelGroupAccount(TravelGroupAccount travelGroupAccount){
		travelGroupAccount.setId(sequenceService.getTripAccountId());
		if(travelGroupMapper.insertTravelGroupAccount(travelGroupAccount) > 0){
			return true;
		}
		return false;
	}
	public	List<TravelGroup> searchTravelGroups(String queryString){
		Map<String, String> map = new HashMap<String, String>();
		map.put("queryString", queryString);
		return travelGroupMapper.searchTravelGroups(map);
	}

}
