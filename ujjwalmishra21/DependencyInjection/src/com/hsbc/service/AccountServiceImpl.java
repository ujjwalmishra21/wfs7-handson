package com.hsbc.service;

import java.util.List;

import com.hsbc.dao.AccountDAO;
import com.hsbc.dao.JdbcBackedDao;
import com.hsbc.models.Account;

public class AccountServiceImpl implements AccountService {
	private AccountDAO dao;
	
	public AccountDAO getJdbc() {
		return dao;
	}

	public void setJdbc(AccountDAO jdbc) {
		this.dao = jdbc;
	}

	@Override
	public void createAccoount(Account account) {
		System.out.println("createAccount() AccountServiceImpl");
		dao.createAccount(account);
		
	}

	@Override
	public List<Account> getAccounts() {
		System.out.println("getAccounts() AccountServiceImpl");
		dao.getAccounts();
		return null;
	}

	@Override
	public List<Account> getAccountsSortByName() {
		System.out.println("getAccountsSortByName() AccountServiceImpl");
		dao.getAccounts();
		return null;
	}

}
