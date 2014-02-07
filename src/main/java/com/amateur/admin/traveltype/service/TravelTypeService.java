package com.amateur.admin.traveltype.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.traveller.domain.TravelType;
import com.amateur.traveller.persistence.TravelTypeMapper;
@Service
public class TravelTypeService {
	@Autowired
	private TravelTypeMapper travelTypeMapper;
	
	public boolean insertTravelType(TravelType travelType){
		if(travelTypeMapper.insertTravelType(travelType) > 0){
			return true;
		}
		return false;
	}
	public List<TravelType> selectTravelTypes(){
		return travelTypeMapper.selectTravelTypes();
	} 
}
