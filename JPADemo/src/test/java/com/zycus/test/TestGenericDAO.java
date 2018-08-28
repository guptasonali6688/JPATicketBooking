package com.zycus.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.zycus.dao.GenericDAO;
import com.zycus.entity.Employee;

public class TestGenericDAO {

	@Test
	public void testAdd() {
		Employee employee = new Employee();
		employee.setName("Sonali");
		employee.setSalary(20000);
		GenericDAO dao = new GenericDAO();
		dao.add(employee);
	}
	@Test 
	public void fetchById() {
		GenericDAO dao = new GenericDAO();
		Employee employee = dao.fetchById(Employee.class, 1);
		assertNotNull(employee);
		System.out.println(employee);
	}
	
	@Test
	public void testUpdate() {
		GenericDAO dao = new GenericDAO();
		Employee employee = dao.fetchById(Employee.class, 1);
		employee.setName("Rupali");
		dao.update(employee);
	}
	
	@Test
	public void testFetchAll() {
		GenericDAO dao = new GenericDAO();
		List<Employee> emplist = dao.fetchAll(Employee.class);
		for(Employee emp: emplist){
			System.out.println(emp);
		}
		
	}
	@Test
	public void delete() {
		GenericDAO dao = new GenericDAO();
		dao.delete(Employee.class, 1);
	}

}
