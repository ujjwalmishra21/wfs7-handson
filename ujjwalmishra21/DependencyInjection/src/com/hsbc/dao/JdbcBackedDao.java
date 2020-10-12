package com.hsbc.dao;

import java.util.List;

import com.hsbc.models.Account;
import com.hsbc.models.DBUtility;

public class JdbcBackedDao implements AccountDAO {
	
	private DBUtility dbUtility;
		
	public void setDbUtility(DBUtility dbUtility) {
		this.dbUtility = dbUtility;
	}

	@Override
	public void createAccount(Account account) {
		System.out.println("createAccount() of JdbcBackedDao");

	}

	@Override
	public List<Account> getAccounts() {
		System.out.println("getAccounts() of JdbcBackedDao");
		return null;
	}

}
