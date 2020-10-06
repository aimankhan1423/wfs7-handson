package com.org.model.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.org.model.beans.Account;
import com.org.model.dao.AccountDao;
import com.org.model.exceptions.AccountNotFoundException;
import com.org.model.exceptions.InsufficientFundException;
import com.org.model.util.ObjectFactory;

public class AccountServiceImpl implements AccountService {

	
	private AccountDao accountDao = null;
	public AccountServiceImpl() {
		accountDao = ObjectFactory.getAccountDaoInstance();
	}
	
	
	@Override
	public Account createAccount(Account account) {
	
		return accountDao.createAccount(account);
	}

	@Override
	public double getBalance(int accountNumber) throws AccountNotFoundException {
		
		double balance=0;
		
		Account a=accountDao.getAccount(accountNumber) ;
		
		if(a.equals(null))
				throw new AccountNotFoundException("Customer with this id does not exist.....");
		else 
			
		balance=a.getBalance();
		
		
		
	   return balance;
		
	
		
	}

	@Override
	public void transfer(int sourceAccount, int destinationAccount, double amount)  throws AccountNotFoundException,InsufficientFundException
	{
		
		
		Account source = accountDao.getAccount(sourceAccount);
		Account destination = accountDao.getAccount(destinationAccount);
		if(source == null || destination == null) {
			throw new AccountNotFoundException("Account not in list of customers......");
		}
		accountDao.debit(sourceAccount, amount);
		accountDao.credit(destinationAccount, amount);
		
		
	}

	@Override
	public List<Account> getAccountsSortedByName() {
		List<Account> accounts = accountDao.getAccounts();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account1.getCustomerName().compareTo(account2.getCustomerName()))
		.collect(Collectors.toList());
		
		return sortedAccount;
	}

	@Override
	public List<Account> getAccountsSortedByAccountNumber() {
		List<Account> accounts = accountDao.getAccounts
				();
		List<Account> sortedAccount = accounts.stream()
		.sorted((account1, account2) -> account1.getAccountNumber()-account2.getAccountNumber())
		.collect(Collectors.toList());
		
		return sortedAccount;
			}

}
