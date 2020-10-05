package com.hsbc.daoImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hsbc.dao.IEmployee;
import com.hsbc.model.Employee;

public class EmployeeImpl implements IEmployee{
	
	List<Employee> le=new ArrayList<Employee>();

	@Override
	public void store(Employee e) {
		
		le.add(e);
		
	}

	@Override
	public Collection<Employee> sortIdAsc()
	{
		Collections.sort(le, (e1,e2) -> e1.getId() - e2.getId());
		return le;
	}

	@Override
	public Collection<Employee> sortIdDesc() {
		Collections.sort(le, (e1,e2) -> e2.getId() - e1.getId());
		return le;
	}

	@Override
	public Collection<Employee> sortDobAsc() {
	
		Collections.sort(le, (e1,e2) -> e1.getDob().compareTo(e2.getDob()));
		return le;
		
	}

	@Override
	public Collection<Employee> sortDobDesc() {
		
		Collections.sort(le, (e1,e2) -> e2.getDob().compareTo(e1.getDob()));
		return le;
		
		
	}

	@Override
	public Collection<Employee> sortSalaryAsc() {
		Collections.sort(le, (e1,e2) -> (int)(e1.getSalary() - e2.getSalary()));
		return le;
		
	}

	@Override
	public Collection<Employee> sortSalaryDesc() {
		Collections.sort(le, (e1,e2) -> (int)(e2.getSalary() - e1.getSalary()));
		return le;
		
	}
	public List<Employee> topThree(){
		List<Employee> empList = new ArrayList<Employee>();
		
		int count = 0;
		for(Employee employee:le) {
			empList.add(employee);
			count++;
			if(count == 3)
				break;
		}
		
		return empList;
	}


	
}
