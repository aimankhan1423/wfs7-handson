package com.hsbc.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.hsbc.model.Employee;

public interface IEmployee 
{
	void store(Employee e);
	Collection<Employee> sortIdAsc();
	Collection<Employee> sortIdDesc();
	Collection<Employee> sortDobAsc();
	Collection<Employee> sortDobDesc();
	Collection<Employee> sortSalaryAsc();
	Collection<Employee> sortSalaryDesc();
	List<Employee> topThree();

	
	
	
}
