package com.zycus.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zycus.dao.GenericDAO;
import com.zycus.entity.Department;
import com.zycus.entity.Employee;

public class TestEmpDept {

	@Test
	public void testAddDept() {
		GenericDAO dao = new GenericDAO();
		Department department = new Department();
		department.setDeptno(1);
		department.setName("IT");
		department.setLocation("Mumbai");
		
		dao.add(department);
	}
	
	@Test
	public void testAddEmp() {
		GenericDAO dao = new GenericDAO();
		
		Employee employee = new Employee();
		employee.setEmpno(1);
		employee.setName("Sonali");
		employee.setSalary(20000);
		
		Department department = dao.fetchById(Department.class, 1);
		employee.setDepartment(department);
		dao.add(employee);
	}
	
	@Test
	public void testAddEmp2() {
		GenericDAO dao = new GenericDAO();
		
		Employee employee = new Employee();
		employee.setEmpno(2);
		employee.setName("Rupali");
		employee.setSalary(20000);
		
		Department department = dao.fetchById(Department.class, 1);
		//employee.setDepartment(department);
		department.getEmployees().add(employee);
		dao.update(department);
	}

}
