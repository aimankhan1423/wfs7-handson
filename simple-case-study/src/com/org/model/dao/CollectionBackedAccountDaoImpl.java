package com.org.model.dao;

import java.util.ArrayList;
import java.util.List;

import com.org.model.beans.Account;
import com.org.model.exceptions.InsufficientFundException;

public class CollectionBackedAccountDaoImpl implements AccountDao {

	private static List<Account> database = new ArrayList<>();
	@Override
	public Account createAccount(Account account) {
		database.add(account);
		return account;
	}


	

	@Override
	public Account getAccount(int accountNumber)  {
		
		return(database.get(accountNumber-1));
		
	}

	@Override
	public List<Account> getAccounts() {
	
		return database;
	}




	@Override
	public Account debit(int accountNumber, double amount) throws InsufficientFundException {

		Account a=database.get(accountNumber-1);
		if(a.getBalance()<amount)
			throw new InsufficientFundException("You dont have sufficient funds to proceed");
		else
			
		a.setBalance(a.getBalance()-amount) ;
		return a;
	}




	@Override
	public Account credit(int accountNumber, double amount) {
		
		Account a=database.get(accountNumber-1);
		a.setBalance(a.getBalance()+amount);
		return a;
	}

}
