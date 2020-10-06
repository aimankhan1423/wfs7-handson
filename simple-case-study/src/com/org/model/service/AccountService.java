package com.org.model.service;

import java.util.List;

import com.org.model.beans.Account;
import com.org.model.exceptions.AccountNotFoundException;
import com.org.model.exceptions.InsufficientFundException;

public interface AccountService {
	public Account createAccount(Account account);
	public double getBalance(int accountNumber) throws AccountNotFoundException;
	// call updateBalance() on source & destination account
	public void transfer(int sourceAccount, int destincationAccount, double amount) throws AccountNotFoundException,InsufficientFundException;
	public List<Account> getAccountsSortedByName();
	public List<Account> getAccountsSortedByAccountNumber();
}
