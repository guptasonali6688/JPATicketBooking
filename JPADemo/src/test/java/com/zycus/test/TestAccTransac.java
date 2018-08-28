package com.zycus.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zycus.bo.Account;
import com.zycus.bo.FacilityTransaction;
import com.zycus.dao.GenericDAO;
import com.zycus.service.AccountService;

public class TestAccTransac {

/*	@Test
	public void testAddAccount() {
		Account account = new Account();
		account.setName("Manas");
		account.setBalance(20000);
		account.setType("Current");
		AccountService accountService = new AccountService();
		accountService.registerAccount(account);
	}*/
	
	@Test
	public void testDeposit() {
		AccountService accountService = new AccountService();
		accountService.deposit(1, 100000);
	}
	
	@Test
	public void testWithDraw() {
		AccountService accountService = new AccountService();
		accountService.withDraw(4, 20);
	}
	
	@Test
	public void testTransfer() {
		AccountService accountService = new AccountService();
		accountService.transfer(1, 4, 775);
	}
	
	@Test
	public void testFetchBalance() {
		AccountService accountService = new AccountService();	
		System.out.println(accountService.fetchBalance(1));
	}
	
	@Test
	public void testlistMiniStatement() {
		AccountService accountService = new AccountService();
		List<FacilityTransaction> list = accountService.miniStatement(1);
		
		for(FacilityTransaction fac: list) {
			System.out.println(fac);
		}
		
	}
	@Test
	public void testfetchAccByTransAmt() {
		AccountService accountService = new AccountService();
		List<Account> list = accountService.fetchAccByTransAmt(100);
		
		for(Account acc: list) {
			System.out.println(acc.getAccNo());
		}
		
	}
	
	@Test
	public void testfetchAccByHighestTransAmt() {
		AccountService accountService = new AccountService();
		List<Account> list = accountService.fetchAccountsByHighestTransactionAmount();
		
		for(Account acc: list) {
			System.out.println(acc.getAccNo());
		}
		
	}

}
