package com.hsbc.service;

import java.util.List;

import com.hsbc.models.Account;

public interface AccountService {
	public void createAccoount(Account account);
	public List<Account> getAccounts();
	public List<Account> getAccountsSortByName();
}
