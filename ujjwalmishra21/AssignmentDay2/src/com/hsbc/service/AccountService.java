package com.hsbc.service;

import java.util.List;

import com.hsbc.exceptions.InsuffientBalanceException;
import com.hsbc.exceptions.InvalidAccountException;
import com.hsbc.model.beans.Account;

public interface AccountService {
	public Account createAccount(Account account);
	public double getBalance(int accountNumber) throws InvalidAccountException;
	public boolean transfer(int sourceAccount, int destinationAccount,double amount) throws InsuffientBalanceException, InvalidAccountException;
	public List<Account> getAccountSortedByName();
	public List<Account> getAccountSortedByAccountNumber();
	public Account deleteAccount(int accountNumber) throws InvalidAccountException;
}
