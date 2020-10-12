package com.hsbc.dao;

import java.util.List;

import com.hsbc.models.Account;

public interface AccountDAO {
	public void createAccount(Account account);
	public List<Account> getAccounts();

}
