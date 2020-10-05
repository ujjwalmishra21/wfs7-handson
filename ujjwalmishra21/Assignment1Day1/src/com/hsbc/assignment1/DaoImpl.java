package com.hsbc.assignment1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DaoImpl {
	private List<Employee> employees = new ArrayList<>();
	
	public void store(String name, LocalDate date, double salary) {
		
		Employee employee = new Employee(employees.size()+1,name,salary,date);
		employees.add(employee);
	}
	
	public List<Employee> sortEmployee(int type){
				
		switch(type) {
		case 1:
			Collections.sort(employees, (e1,e2) -> e1.getId() - e2.getId());
			break;
		case 2:
			Collections.sort(employees, (e1,e2) -> e2.getId() - e1.getId());
			break;
		case 3:
			Collections.sort(employees, (e1,e2) -> e1.getName().compareTo(e2.getName()));
			break;
		case 4:
			Collections.sort(employees, (e1,e2) -> e2.getName().compareTo(e1.getName()));
			break;
		case 5:
			Collections.sort(employees, (e1,e2) -> e1.getDob().compareTo(e2.getDob()));
			break;
		case 6:
			Collections.sort(employees, (e1,e2) -> e2.getDob().compareTo(e1.getDob()));
			break;
		case 7:
			Collections.sort(employees, (e1,e2) -> (int)(e1.getSalary() - e2.getSalary()));
			break;
		case 8:
			Collections.sort(employees, (e1,e2) -> (int)(e2.getSalary() - e1.getSalary()));
			break;
		default:
			return null;
		}
		return employees;
	}
	
	public List<Employee> getTopThree(){
		List<Employee> list = new ArrayList<Employee>();
		
		int count = 0;
		for(Employee employee:employees) {
			list.add(employee);
			count++;
			if(count == 3)
				break;
		}
		
		return list;
	}
}
