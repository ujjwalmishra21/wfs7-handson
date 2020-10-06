package com.hsbc.model.service;

import java.util.List;
import java.util.stream.Collectors;

import com.hsbc.exceptions.InsuffientBalanceException;
import com.hsbc.exceptions.InvalidAccountException;
import com.hsbc.model.beans.Account;
import com.hsbc.model.dao.AccountDao;
import com.hsbc.model.dao.AccountDaoImp;
import com.hsbc.model.utils.ObjectFactory;

public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao = null;
	
	public AccountServiceImpl() {
		// TODO Auto-generated constructor stub
		this.accountDao = (AccountDao) ObjectFactory.getInstance("dao");
	}
	
	@Override
	public Account createAccount(Account account) {
		
		return this.accountDao.createAccount(account);
	}

	@Override
	public double getBalance(int accountNumber) throws InvalidAccountException {
		// TODO Auto-generated method stub
		Account account = this.accountDao.getAccount(accountNumber);
		if(account == null) {
			throw new InvalidAccountException("Account does not exist");
		}
		return account.getBalance();
	}

	@Override
	public boolean transfer(int sourceAccount, int destinationAccount, double amount) throws InsuffientBalanceException, InvalidAccountException {
		Account source = accountDao.getAccount(sourceAccount);
		Account destination = accountDao.getAccount(destinationAccount);
		if(source == null || destination == null) {
			throw new InvalidAccountException("Account invalid exception");
		}
		accountDao.debit(sourceAccount, amount);
		accountDao.credit(destinationAccount, amount);
		return true;
	}

	@Override
	public List<Account> getAccountSortedByName() {
		
		List<Account> accounts = this.accountDao.getAllAccounts().stream().sorted((a1,a2)->a1.getCustomerName().compareTo(a2.getCustomerName())).collect(Collectors.toList());
		return accounts;
	}

	@Override
	public List<Account> getAccountSortedByAccountNumber() {
		List<Account> accounts = this.accountDao.getAllAccounts().stream().sorted((a1,a2)->a1.getAccountNumber() - a2.getAccountNumber()).collect(Collectors.toList());
		return accounts;
	}

	@Override
	public Account deleteAccount(int accountNumber) throws InvalidAccountException {
		
		return this.accountDao.deleteAccount(accountNumber);
	}

}
