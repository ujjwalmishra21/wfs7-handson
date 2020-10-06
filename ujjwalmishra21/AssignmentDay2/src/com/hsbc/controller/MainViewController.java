package com.hsbc.controller;

import java.util.List;
import java.util.Scanner;

import com.hsbc.exceptions.InsuffientBalanceException;
import com.hsbc.exceptions.InvalidAccountException;
import com.hsbc.model.beans.Account;
import com.hsbc.model.service.AccountService;
import com.hsbc.model.utils.ObjectFactory;

public class MainViewController {
	public static void main(String args[]) {
	
		Scanner sc = new Scanner(System.in);
		AccountService accountService = (AccountService) ObjectFactory.getInstance("service");
		boolean exit = false;
		while(!exit){
			System.out.println("1. Create Account");
			System.out.println("2. Check Balance");
			System.out.println("3. Transfer Amount");
			System.out.println("4. Sort accounts by name");
			System.out.println("5. Sort accounts by  account number");
			System.out.println("6. Delete account");
			System.out.println("7. Exit");
			int option = sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Enter customer name:");
				String name = sc.next();
				Account account = new Account(name);
				System.out.println("Account created: " + account);
				accountService.createAccount(account);
				break;
			case 2:
				System.out.println("Enter the account number:");
				int accountNumber = sc.nextInt();
				double balance;
				try {
					balance = accountService.getBalance(accountNumber);
					System.out.println("Balance: " + balance);
				} catch (InvalidAccountException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				break;
			case 3:
				System.out.println("Enter source account number:");
				int source = sc.nextInt();
				System.out.println("Enter destination account number:");
				int destination = sc.nextInt();
				System.out.println("Enter the amount to transfer:");
				double amount = sc.nextDouble();
				boolean isSuccess = false;
				try {
					isSuccess = accountService.transfer(source, destination, amount);
				} catch (InsuffientBalanceException | InvalidAccountException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(isSuccess) {
					System.out.println("Amount transferred successfully.");
				}else {
					System.out.println("Amount cannot be transferred.");
				}
				break;
			case 4:
				List<Account> accounts = accountService.getAccountSortedByName();
				accounts.stream().forEach(a -> System.out.println(a));
				
				break;
			case 5:
				accounts = accountService.getAccountSortedByAccountNumber();
				accounts.stream().forEach(a -> System.out.println(a));
				break;
			case 6:
				System.out.println("Enter account to be deleted:");
				int accountN = sc.nextInt();
				try {
					Account accountD = accountService.deleteAccount(accountN);
					System.out.println(accountD + " deleted successfully");
				} catch (InvalidAccountException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 7:
				exit  = true;
				break;
			default:
				break;
			}
		}
	}
	
	
}
