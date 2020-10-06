package com.hsbc.model.utils;

import com.hsbc.dao.AccountDao;
import com.hsbc.dao.AccountDaoImp;
import com.hsbc.service.AccountServiceImpl;

public class ObjectFactory {
	
	public static AccountDaoImp getAccountDaoInstance() {
		return new AccountDaoImp();
	}
	public static AccountServiceImpl getAccountServiceInstance() {
		return new AccountServiceImpl();
	}
	public static Object getInstance(String type) {
		if(type.equals("service")) {
			return new AccountServiceImpl();
		}
		else if(type.equals("dao")) {
			return new AccountDaoImp();
		}
		return null;
	}
}
