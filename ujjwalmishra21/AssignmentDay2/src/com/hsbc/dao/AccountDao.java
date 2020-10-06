package com.hsbc.dao;

import java.util.List;

import com.hsbc.exceptions.InsuffientBalanceException;
import com.hsbc.exceptions.InvalidAccountException;
import com.hsbc.model.beans.Account;

public interface AccountDao {
	public Account createAccount(Account account);
	public Account debit(int account, double amount) throws InsuffientBalanceException, InvalidAccountException;
	public Account credit(int account, double amount) throws InvalidAccountException;
	public Account getAccount(int accountNumber);
	public Account deleteAccount(int accountNumber) throws InvalidAccountException;
	public List<Account> getAllAccounts();
}
