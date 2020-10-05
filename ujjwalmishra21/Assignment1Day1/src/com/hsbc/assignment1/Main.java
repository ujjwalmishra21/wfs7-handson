package com.hsbc.assignment1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) {
		
		DaoImpl dao = new DaoImpl();
		Employee e1 = new Employee("Ujjwal", LocalDate.of(1997, 02, 21), 780000);
		Employee e2 = new Employee("Abhishek", LocalDate.of(1998, 11, 02), 560000);
		Employee e3 = new Employee("Binu", LocalDate.of(1997, 02, 25), 9000000);
		Employee e4 = new Employee("Manish", LocalDate.of(1998, 07, 22), 800000);
		dao.store(e1);
		dao.store(e2);
		dao.store(e3);
		dao.store(e4);
				
		boolean exit = false;
		while(!exit) {
			System.out.println("1. Store");
			System.out.println("2. Sort and Display");
			System.out.println("3. Pick Top 3");
			System.out.println("4. Exit");
			int n = sc.nextInt();
			switch(n) {
			case 1:
				System.out.println("Enter the employee name:");
				String name = sc.next();
				
				System.out.println("Enter the employee salary");
				double salary = sc.nextDouble();
				
				System.out.println("Enter the employee birth data(dd/mm/yyyy):");
				String date = sc.next();
				LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				
				Employee eNew = new Employee(name, localDate, salary);
				dao.store(eNew);			
				
				break;
			case 2:
				System.out.println("Choose type of sort:");
				System.out.println("1. Ascending Order by Id");
				System.out.println("2. Descending Order by Id");
				System.out.println("3. Ascending Order by Name");
				System.out.println("4. Descending Order by Name");
				System.out.println("5. Ascending Order by DOB");
				System.out.println("6. Descending Order by DOB");
				System.out.println("7. Ascending Order by Salary");
				System.out.println("8. Descending Order by Salary");
				int s = sc.nextInt();
				display(dao.sortEmployee(s));				
				
				break;
			case 3:
				display(dao.getTopThree());
				break;
			case 4:
				exit = true;
				break;
			default:
				break;
			}
			
		}
		
		
	}
	public static void display(List<Employee> list) {
		
		for(Employee emp : list) {
			System.out.println(emp);
		}
	}
}
