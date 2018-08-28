package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.zycus.entity.Customer;
import com.zycus.util.JPAUtil;

public class CustomerDao {

	public void add(Customer customer) {

		// Step1 Create/Obtain EntityManagerFactory object
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		// Step2 Create/Obtain Session object(connection object)
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Step3 Bind the Session with a Transaction
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(customer);
		tx.commit();

	}

	public void update(Customer customer) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(customer);
		tx.commit();

	}

	public void delete(int customerId) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Customer customer = (Customer) (entityManager.find(Customer.class, customerId));
		entityManager.remove(customer);
		tx.commit();

	}

	public Customer fetchById(int customerId) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Customer customer = (Customer) (entityManager.find(Customer.class, customerId));
		return customer;

	}

	public List<Customer> fetchAll() {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select c from Customer as c"); // JPQL
		try {
			return query.getResultList();
		}

		finally {
			entityManager.close();
		}

	}
}
