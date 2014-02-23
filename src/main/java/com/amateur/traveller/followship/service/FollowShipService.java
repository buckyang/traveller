package com.amateur.traveller.followship.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.traveller.account.service.AccountService;
import com.amateur.traveller.domain.FollowShip;
import com.amateur.traveller.persistence.FollowShipMapper;

@Service
public class FollowShipService {
	private static final Logger log = Logger.getLogger(AccountService.class);

	@Autowired
	private FollowShipMapper followShipMapper;

	public void addFollower(FollowShip followShip) {
		followShipMapper.addFollower(followShip);
	}
}
