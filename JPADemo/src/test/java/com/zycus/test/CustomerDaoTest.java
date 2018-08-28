package com.zycus.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zycus.dao.CustomerDao;
import com.zycus.dao.GenericDAO;
import com.zycus.entity.Address;
import com.zycus.entity.Customer;
import com.zycus.entity.Employee;

public class CustomerDaoTest {

	@Test
	public void testAddCustomer() {

		Customer customer = new Customer();
		customer.setName("Sonali Gupta");
		customer.setEmail("sonali.gupta@zycus.com");
		customer.setCity("mumbai");

		CustomerDao dao = new CustomerDao();
		dao.add(customer);

	}

	@Test
	public void testFetchByCustomerID() {
		CustomerDao dao = new CustomerDao();
		Customer customer = new Customer();
		customer = dao.fetchById(1);
		assertNotNull(customer);
		System.out.println(customer);// wrong while writing test cases
	}

	@Test
	public void testUpdateCustomer() {
		CustomerDao dao = new CustomerDao();
		Customer customer = new Customer();
		customer = dao.fetchById(1);
		assertNotNull(customer);
		customer.setCity("Jamshedpur");
		dao.update(customer);
		System.out.println(customer);

	}
	
	@Test
	public void delete() {
		CustomerDao dao=new CustomerDao();
		dao.delete(1);
		
		
	}
	@Test
	public void fetchAllTest(){
		List<Customer> customerList=new ArrayList<Customer>();
		CustomerDao dao=new CustomerDao();
		customerList=dao.fetchAll();
		for(Customer c:customerList)
			System.out.println(c);
		
		
	}
	
	@Test
	public void testAddCustomerWithAddress() {

		Customer customer = new Customer();
		customer.setName("Sonali Gupta");
		customer.setEmail("sonali.gupta@zycus.com");
		customer.setCity("mumbai");
		
		Address address = new Address();
		address.setCity("Sanpada");
		address.setState("Maharashtra");
		address.setPincode(400705);
		customer.setAddress(address);

		CustomerDao dao = new CustomerDao();
		dao.add(customer);
		System.out.println(customer);

	}
	

}
