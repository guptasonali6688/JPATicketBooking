package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import com.zycus.util.JPAUtil;

public class GenericDAO {
	public void add(Object object) {

		// Step1 Create/Obtain EntityManagerFactory object
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		// Step2 Create/Obtain Session object(connection object)
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		// Step3 Bind the Session with a Transaction
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(object);
		tx.commit();
		entityManager.close();
	}
	
	public void update(Object object) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(object);
		tx.commit();
		entityManager.close();

	}

	public void delete(Class clazz, Object id) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		Object object = entityManager.find(clazz, id);
		entityManager.remove(object);
		tx.commit();
		entityManager.close();

	}

	public <E>E fetchById(Class<E> clazz, Object id) {
		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		try {
			E e = entityManager.find(clazz, id);
			return e;
		}
		finally {
			entityManager.close();
		}

	}

	public <E> List<E> fetchAll(Class<E> clazz) {

		EntityManagerFactory entityManagerFactory = JPAUtil.getEntityManagerFactory();
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "select o from "+clazz.getName()+" as o";
		Query query = entityManager.createQuery(jpql); // JPQL
		try {
			return query.getResultList();
		}

		finally {
			entityManager.close();
		}

	}
}
