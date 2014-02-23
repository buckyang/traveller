package com.amateur.traveller.account.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amateur.traveller.account.dto.FollowShipDTO;
import com.amateur.traveller.account.dto.PrivateZoneDTO;
import com.amateur.traveller.account.dto.RegistrationDTO;
import com.amateur.traveller.account.dto.UpdateAccountDTO;
import com.amateur.traveller.account.dto.UserBasicInfoDTO;
import com.amateur.traveller.domain.Account;
import com.amateur.traveller.persistence.AccountMapper;

@Service
public class AccountService {

	private static final Logger log = Logger.getLogger(AccountService.class);

	@Autowired
	private AccountMapper accountMapper;

	public Account getUserByEmail(String email) {
		return accountMapper.getUserByEmail(email);
	}

	public Account getAccountBydId(int accountId) {
		return accountMapper.getAccountById(accountId);
	}

	public boolean registerUser(RegistrationDTO registration) {
		if (StringUtils.isEmpty(registration.getEmail())) {
			throw new IllegalArgumentException("Email can not be null");
		}
		if (StringUtils.isEmpty(registration.getPassword())) {
			throw new IllegalArgumentException("Pass can not be null");
		}
		Account user = new Account();
		user.setEmail(registration.getEmail());
		user.setPass(registration.getPassword());
		user.setNickname(registration.getNickname());
		user.setSex(registration.getGender());
		if (accountMapper.registerUser(user) > 0) {
			return true;
		}
		return false;
	}

	public boolean updateUser(UpdateAccountDTO updateAccountDTO) {
		Account account = new Account();
		BeanUtils.copyProperties(updateAccountDTO, account);
		if (accountMapper.updateUser(account) > 0) {
			return true;
		}
		return false;
	}

	public boolean updatePassword(Account account) {
		if (account == null) {
			throw new IllegalArgumentException(
					"Account parameter can not be null");
		}
		if (accountMapper.updatePassword(account) > 0) {
			return true;
		}
		return false;
	}

	public List<Account> getFollowerList(int accountId) {
		return accountMapper.getFollowerList(accountId);
	}

	public List<Account> getFolloweeList(int accountId) {
		return accountMapper.getFolloweeList(accountId);
	}

	public PrivateZoneDTO getPrivateZoneInfo(int id) {
		PrivateZoneDTO privateZoneDTO = new PrivateZoneDTO();
		// query user basic information
		Account account = accountMapper.getAccountById(id);
		if (account == null) {
			log.warn("The user is not exist,user id is::" + id);
			privateZoneDTO.setErrorMsg("This user has logged off");
			return privateZoneDTO;
		}
		UserBasicInfoDTO userBasicInfoDTO = new UserBasicInfoDTO();
		BeanUtils.copyProperties(account, userBasicInfoDTO);
		privateZoneDTO.setPersonalInfo(userBasicInfoDTO);

		// query the follower/followee
		FollowShipDTO followShipDTO = new FollowShipDTO();
		privateZoneDTO.setFollowShip(followShipDTO);

		List<Account> followerList = accountMapper.getFollowerList(id);
		followShipDTO.setFollowerList(constructFollowerList(followerList));

		List<Account> followeeList = accountMapper.getFolloweeList(id);
		followShipDTO.setFolloweeList(constructFollowerList(followeeList));
		return privateZoneDTO;
	}

	@SuppressWarnings("unchecked")
	private List<UserBasicInfoDTO> constructFollowerList(
			List<Account> followShipAccounts) {
		if (followShipAccounts != null && !followShipAccounts.isEmpty()) {
			List<UserBasicInfoDTO> followShipsTemp = new ArrayList<UserBasicInfoDTO>(
					followShipAccounts.size());
			for (Account follower : followShipAccounts) {
				UserBasicInfoDTO userInfoTemp = new UserBasicInfoDTO();
				BeanUtils.copyProperties(follower, userInfoTemp);
				followShipsTemp.add(userInfoTemp);
			}
			return followShipsTemp;
		} else {
			return Collections.EMPTY_LIST;
		}
	}

}
