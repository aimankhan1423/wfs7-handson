package com.hsbc.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.hsbc.dao.IEmployee;
import com.hsbc.daoImpl.EmployeeImpl;
import com.hsbc.model.Employee;

public class Caller {

	public static void main(String[] args) 
	{
	
		int choice;
		boolean exit=false;
		Scanner sc=new Scanner(System.in);
		IEmployee e=new EmployeeImpl();
		Employee e1=new Employee(101,"Aiman",100000,LocalDate.of(1998,02,04));
        Employee e2=new Employee(98,"Zia",1000,LocalDate.of(1991,03,05));
        Employee e3=new Employee(136,"Riya",160000,LocalDate.of(1997,07,01));
        e.store(e1);
        e.store(e2);
        e.store(e3);
        
        while(!exit)
        {
		System.out.println("Enter 1. Store \n  2. Sort and Display  3. top Three");
		choice=sc.nextInt();
	
		
		switch(choice)
		{
		  case 1: 	  System.out.println("Enter the employee ID:");
			           int id = sc.nextInt();
			  
			          System.out.println("Enter the employee name:");
					String name = sc.next();
			
					System.out.println("Enter the employee salary");
					double salary = sc.nextDouble();
			
					System.out.println("Enter the employee birth data(dd/mm/yyyy):");
					String date = sc.next();
					
					LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			        Employee new1 = new Employee(id,name,salary,localDate);
			        e.store(new1);
		            break;
		 
		  case 2: System.out.println("arranging asc by ID");
		          System.out.println(e.sortIdAsc());
		          
		          System.out.println("descending asc by ID");
		          System.out.println(e.sortIdDesc());
		          
		          System.out.println("arranging asc by dob");
		          System.out.println(e.sortDobAsc());
		          
		          System.out.println("descending desc by dob");
		          System.out.println(e.sortDobDesc());
		          
		          System.out.println("ascending asc by salary");
		          System.out.println(e.sortSalaryAsc());
		          
		          System.out.println("descending desc by salary");
		          System.out.println(e.sortSalaryDesc());
		          break;
		          
		  case 3: ArrayList<Employee> top=(ArrayList<Employee>) e.topThree();    
		          System.out.println(top);
		          
		  case 4: exit=true; 
		          break;
		          
		          
		}
	}
		
	}

	

}
