package com.amateur.traveller.session;

import com.amateur.traveller.domain.Account;

public class Profile {
	public static final String PROFILE_KEY = "profile";
	public static final int ANONYMOUS = 0;
	public static final int EXPLICIT_LOGIN = 1;
	public static final int COOKIE_LOGIN = 2;

	private int status = 0;
	
	private Account accountDatasource;
	public Account getAccountDatasource() {
		return accountDatasource;
	}

	public void setAccountDatasource(Account accountDatasource) {
		this.accountDatasource = accountDatasource;
	}



	public Integer getAccountId() {
		if (accountDatasource != null) {
			return accountDatasource.getAccountId();
		}
		return null;
	}

	public String getRealName() {
		if (accountDatasource != null) {
			return accountDatasource.getRealName();
		}
		return null;
	}

	public String getEmail() {
		if (accountDatasource != null) {
			return accountDatasource.getEmail();
		}
		return null;
	}

	public String getIdiograph() {
		if (accountDatasource != null) {
			return accountDatasource.getIdiograph();
		}
		return null;
	}

	public Integer getSex() {
		if (accountDatasource != null) {
			return accountDatasource.getSex();
		}
		return null;
	}

	public String getPhone() {
		if (accountDatasource != null) {
			return accountDatasource.getPhone();
		}
		return null;
	}

	public String getProvince() {
		if (accountDatasource != null) {
			return accountDatasource.getProvince();
		}
		return null;
	}

	public String getCity() {
		if (accountDatasource != null) {
			return accountDatasource.getCity();
		}
		return null;
	}

	public String getImageUrl() {
		if (accountDatasource != null) {
			return accountDatasource.getImageUrl();
		}
		return null;
	}

	public String getNickname() {
		if (accountDatasource != null) {
			return accountDatasource.getNickname();
		}
		return null;
	}

	public String getIdNumber() {
		if (accountDatasource != null) {
			return accountDatasource.getIdNumber();
		}
		return null;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
