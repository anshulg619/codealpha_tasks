package com.tester;

import java.util.ArrayList;
import java.util.Scanner;

import com.student.Student;
import com.student.Utils;

public class Test {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		//populating the ArrayList
		list = Utils.populateData();
		try (Scanner sc = new Scanner(System.in)) {
			
			boolean flag = true;
			while (flag) {
				System.out.println("Application menu: \n 1.Add Student Grades\n" + " 2.Find Average of all students\n "
						+ "3.Find Highest Score\n " + "4.Find Lowest Score\n" + "0.Exit");
				int choice = sc.nextInt();
				switch (choice) {

				case 1:
					System.out.println("Enter Student Name:");
					String name = sc.next();
					
					System.out.println("Enter Student class");
					String className = sc.next();
					
					System.out.println("Enter grades");
					double[] grades = {sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble()};
					
					list.add(new Student(name, className,grades));
					for (Student i: list) {
						System.out.println(i.toString());
					}
					break;
					
				case 2: 
					double sum=0;
					for (Student i: list) {					
						sum+=i.getTotal();						
					}
					System.out.println("avg marks of all students is :"+ sum/list.size());
					break;
					
				case 3: 
					double max = 0;
					for (Student i : list) {
						if(max<i.getTotal()) max=i.getTotal();
						else continue;
					}
					System.out.println("Higest Score among all Students is: "+ max);
					break;
					
				case 4:
					double low =list.get(0).getTotal();
					for (Student i : list) {
						if(low>i.getTotal()) low=i.getTotal();
						else continue;
					}
					
					System.out.println("Lowest Score Among all Student is: "+ low);
					break;
					
				case 0 : 
					System.out.println("closing the application");
					flag=false;
					break;
					
				default:
					System.out.println("please enter a valid choice");
					
				}
				
			}

		}catch(Exception e) {
			e.getMessage();
		}

	}

}
