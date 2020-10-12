package com.hsbc.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hsbc.models.Account;
import com.hsbc.service.AccountService;

public class Client {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		AccountService accountService = (AccountService)context.getBean("accountService");
		
		accountService.createAccoount(new Account());
		accountService.getAccounts();
		accountService.getAccountsSortByName();
		

	}

}
