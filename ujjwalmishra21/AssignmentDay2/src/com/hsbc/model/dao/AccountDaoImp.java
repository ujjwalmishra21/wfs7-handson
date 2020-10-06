package com.hsbc.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.hsbc.exceptions.InsuffientBalanceException;
import com.hsbc.exceptions.InvalidAccountException;
import com.hsbc.model.beans.Account;

public class AccountDaoImp implements AccountDao {
	
	private List<Account> database = null;
	
	public AccountDaoImp() {
		// TODO Auto-generated constructor stub
		this.database = new ArrayList<Account>();
	}
	
	@Override
	public Account createAccount(Account account) {
		database.add(account);
		
		return account;
	}

	
	@Override
	public Account getAccount(int accountNumber) {
		// TODO Auto-generated method stub
		return database.stream().filter(x -> x.getAccountNumber() == accountNumber).findAny().orElse(null);
	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		
		return this.database;
	}

	@Override
	public Account debit(int accountNumber, double amount) throws InsuffientBalanceException, InvalidAccountException {
		for(Account account:this.database) {
			if(account.getAccountNumber() == accountNumber) {
				if(account.getBalance() < amount)
					throw new InsuffientBalanceException("Insufficient balance");
				account.setBalance(account.getBalance() - amount);
				return account;
			}
			
				
		}
		throw new InvalidAccountException("Account does not exist: " + accountNumber);
		
	}

	@Override
	public Account credit(int accountNumber, double amount) throws InvalidAccountException {
		for(Account account:this.database) {
			if(account.getAccountNumber() == accountNumber) {
				account.setBalance(account.getBalance() + amount);
				return account;
			}
		}
		
		throw new InvalidAccountException("Account does not exist: " + accountNumber);
	}

	@Override
	public Account deleteAccount(int accountNumber) throws InvalidAccountException {
		int size = this.database.size();
		List<Account> accounts = this.database.stream().filter(x->x.getAccountNumber() != accountNumber).collect(Collectors.toList());
		Account account = this.getAccount(accountNumber);
		if(accounts.size() == size)
			throw new InvalidAccountException("Account does not exist");
		this.database = accounts;
		
		return account;
	}

}
