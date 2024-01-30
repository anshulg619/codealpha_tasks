package com.student;

import java.util.ArrayList;

public class Utils {
	
	public static ArrayList<Student> populateData(){
		ArrayList<Student> list = new ArrayList<>();
		
		list.add(new Student("Shivam","XI",new double[]{46,25,36,38,49}));
		list.add(new Student("Yashdeep","XI",new double[]{47,37,38,41,39}));
		list.add(new Student("Shubham","XI",new double[]{35,28,31,36,35}));
		list.add(new Student("Sanjeev","XI",new double[]{39,41,33,42,36}));
		
		return list;
	}

}
