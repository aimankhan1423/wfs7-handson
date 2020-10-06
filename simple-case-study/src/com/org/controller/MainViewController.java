package com.org.controller;

import java.util.List;
import java.util.Scanner;

import com.org.model.beans.Account;
import com.org.model.exceptions.AccountNotFoundException;
import com.org.model.exceptions.InsufficientFundException;
import com.org.model.service.AccountService;
import com.org.model.util.ObjectFactory;

public class MainViewController {

	public static void main(String[] args) {
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		AccountService service = ObjectFactory.getAccountServiceInstance();
		do {
			System.out.println("1: Create Account 2: Check Balance");
			System.out.println("3: Transfer Amount 4: Sort Accounts by name 5: Sort Accounts by account number 0: Exit");
			option = scanner.nextInt();
			List<Account> list = null;
			switch(option) {
			case 1: 
				System.out.println("Enter name");
				Account account = new Account(scanner.next());
				Account createdAccount = service.createAccount(account);
				System.out.println(createdAccount);
				break;
				
			case 2: System.out.println("Enter account number");
			        int ac=scanner.nextInt();
			        try
			        {
			        System.out.println("Balance is : " +service.getBalance(ac));
			        }
			        catch(AccountNotFoundException i)
			        {
			        	i.getMessage();
			        }
				    break; 
			
			case 3: System.out.println("Enter source account number");
	        		int ac1=scanner.nextInt();
	        		System.out.println("Enter destination account number");
	        		int ac2=scanner.nextInt();
	        		System.out.println("Enter amount to be transfered");
	        		double d=scanner.nextDouble();
	        		try
	        		{
	        		service.transfer(ac1, ac2, d);
	        		}
	        		catch(InsufficientFundException i)
	        		{
	        			i.getMessage();
	        		}
	        		catch(AccountNotFoundException i)
	        		{
	        			i.getMessage();
	        		}
	        		try
	        		{
	        		System.out.println(" Updated Balance of source  is : " +service.getBalance(ac1));
	        		System.out.println("Upadted Balance of destination  is : " +service.getBalance(ac2));
	        		
	        		}
	        		catch(AccountNotFoundException a)
	        		{
	        			a.getMessage();
	        		}
	        		
	        	
				break; 
			
			case 4: 
				list = service.getAccountsSortedByName(); // HttpSession -> setAttribute("key", list) -> ${ }
				list.forEach(acc -> System.out.println(acc));
				break;
			
			case 5:list = service.getAccountsSortedByAccountNumber(); 
			            list.forEach(acc -> System.out.println(acc));
				
				break;
			}
		} while(option != 0);
		
		scanner.close();
	

	}
}

