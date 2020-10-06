package com.org.model.dao;

import java.util.List;

import com.org.model.beans.Account;
import com.org.model.exceptions.AccountNotFoundException;
import com.org.model.exceptions.InsufficientFundException;

public interface AccountDao {
	public Account createAccount(Account account);
	public Account debit(int accountNumber, double amount) throws InsufficientFundException; 
	public Account credit(int accountNumber, double amount);
	public Account getAccount(int accountNumber) throws AccountNotFoundException;
	public List<Account> getAccounts();
}
