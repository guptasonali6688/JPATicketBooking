package com.zycus.service;


import java.util.List;

import javax.transaction.Transaction;

import com.zycus.bo.Account;
import com.zycus.bo.FacilityTransaction;
import com.zycus.dao.AccountDAO;
import com.zycus.dao.GenericDAO;

public class AccountService {
	GenericDAO dao = new GenericDAO();
	AccountDAO accdao = new AccountDAO();
	
	public AccountService() {
		// TODO Auto-generated constructor stub
	}
	public void registerAccount(Account account) {
		dao.add(account);
	}
	
	public void withDraw(int accNo, double amount) {	
		try {
			Account account = dao.fetchById(Account.class, accNo);
			if(account.getBalance() > 0) {
				double temp = account.getBalance() - amount;
				if(temp > 0) {
					account.setBalance(temp);
					dao.update(account);
					FacilityTransaction trans = addTransaction(amount,"WithDraw",accNo);
					trans.setAccount(account);
					dao.add(trans);
				}else {
					System.out.println("Insufficient balance to withDraw");
				}
			}else {
				System.out.println("Insufficient balance");
			}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	
	public void deposit(int accNo, double amount) {
		try {
			Account account = dao.fetchById(Account.class, accNo);
			double temp = account.getBalance() + amount;
			account.setBalance(temp);
			dao.update(account);
			FacilityTransaction trans = addTransaction(amount,"Deposit",accNo);		
			trans.setAccount(account);
			dao.add(trans);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void transfer(int fromAccNo, int toAccNo, double amount) {	
		withDraw(fromAccNo, amount);
		deposit(toAccNo, amount);		
	}
	
	public FacilityTransaction addTransaction(double amount, String type, int accNo) {
		FacilityTransaction trans = new FacilityTransaction();
		trans.setAmount(amount);
		trans.setTxdate(new java.sql.Date(System.currentTimeMillis()));
		trans.setType(type);
		
		return trans;
	}
	
	public double fetchBalance(int accNo) {
		return accdao.fetchBalance(accNo);
	}
	
	public List<FacilityTransaction> miniStatement(int accNo) {
		return accdao.listminiStatements(accNo);
	}
	
	public List<Account> fetchAccByTransAmt(double amount) {
		return accdao.fetchAccountsByTransAmt(amount);
	}
	
	public List<Account> fetchAccountsByHighestTransactionAmount() {
		return accdao.fetchAccountsByHighestTransactionAmount();
	}
}
