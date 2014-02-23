package com.amateur.traveller.followship.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amateur.traveller.domain.FollowShip;
import com.amateur.traveller.followship.service.FollowShipService;
@Controller
@RequestMapping("/followship")
public class FollowShipController {

	@Autowired
	private FollowShipService followShipService;

	@RequestMapping(value = "/addfollower", method = RequestMethod.GET)
	public void handleRequest(@RequestParam("followerId") int followerId,
			@RequestParam("followeeId") int followeeId, Model m) {
		FollowShip followShip = new FollowShip();
		followShip.setFollowerId(followerId);
		followShip.setFolloweeId(followeeId);
		followShipService.addFollower(followShip);
	}

}
