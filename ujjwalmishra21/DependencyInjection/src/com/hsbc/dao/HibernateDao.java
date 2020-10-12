package com.hsbc.dao;

import java.util.List;

import com.hsbc.models.Account;
import com.hsbc.models.DBUtility;

public class HibernateDao implements AccountDAO {
	
	private DBUtility dbUtility;
	
	public HibernateDao(DBUtility dbUtility) {
		this.dbUtility = dbUtility;
	}
	
	public void setDbUtility(DBUtility dbUtility) {
		this.dbUtility = dbUtility;
	}

	@Override
	public void createAccount(Account account) {
		System.out.println("createAccount() of HibernateDao");
		
	}

	@Override
	public List<Account> getAccounts() {
		System.out.println("getAccounts() of HibernateDao");
		return null;
	}

}
