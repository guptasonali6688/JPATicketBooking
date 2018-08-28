package com.zycus.dao;

import org.hibernate.Transaction;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zycus.entity.Customer;
import com.zycus.util.HibernateUtil;

public class CustomerDao {

	public void add(Customer customer) {

		// Step 1 Create/Obtain SessionFactory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Create/Obtain session object
		Session session = sessionFactory.getCurrentSession();

		// Bind the session with a Transaction
		Transaction tx = session.beginTransaction();

		// now insert/update etc all sql queries
		session.save(customer);// save method generates insert query
		tx.commit();

	}

	public void update(Customer customer) {

		// Step 1 Create/Obtain SessionFactory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Create/Obtain session object
		Session session = sessionFactory.getCurrentSession();

		// Bind the session with a Transaction
		Transaction tx = session.beginTransaction();

		// now insert/update etc all sql queries
		session.update(customer);// save method generates insert query
		tx.commit();

	}

	public void delete(int customerId) {

		// Step 1 Create/Obtain SessionFactory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		// Create/Obtain session object
		Session session = sessionFactory.getCurrentSession();

		// Bind the session with a Transaction
		Transaction tx = session.beginTransaction();

		// now insert/update etc all sql queries
		Customer customer = (Customer) session.get(Customer.class, customerId);
		session.delete(customer);// save method generates insert query
		tx.commit();

	}

	public Customer fetchById(int customerId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			// get method generates select query
			Customer customer = (Customer) session.get(Customer.class, customerId);
			return customer;
		} finally {
			session.close();
		}

	}

	public List<Customer> fetchAll() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select c from Customer as c");// hql
		try {
			return query.list();
		} finally {
			session.close();
		}

	}
}
