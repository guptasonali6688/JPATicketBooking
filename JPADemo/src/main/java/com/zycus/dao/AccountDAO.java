package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.zycus.bo.Account;
import com.zycus.bo.FacilityTransaction;
import com.zycus.util.JPAUtil;

public class AccountDAO extends GenericDAO{

		public double fetchBalance(int accNo) {
			EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "select a.balance from Account a where a.accNo = :accNo";
			Query query = entityManager.createQuery(jpql); //JPQL
			query.setParameter("accNo", accNo); //Substitute :accNo with actual value
			return (Double) query.getSingleResult();		
		}
		
		public List<FacilityTransaction> listminiStatements(int accNo) {
			EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "select tx from FacilityTransaction tx "
					+ "where tx.account.accNo = :accNo "
					+ "order by tx.txdate DESC";
		
			Query query = entityManager.createQuery(jpql); //JPQL
			query.setParameter("accNo", accNo);
			query.setMaxResults(3);
			return query.getResultList();
		}
		
		public List<Account> fetchAccountsByTransAmt(double amount) {
			EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "select distinct acc from Account acc join acc.transaction tx where tx.amount >= :amt ";		
			Query query = entityManager.createQuery(jpql); //JPQL
			query.setParameter("amt", amount);
			return query.getResultList();
		}
		
		public List<Account> fetchAccountsByHighestTransactionAmount() {
			EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "select distinct acc from Account acc join acc.transaction tx where tx.amount = (select MAX(amount) from FacilityTransaction) ";		
			Query query = entityManager.createQuery(jpql); //JPQL
			return query.getResultList();
		}
		
		
}
