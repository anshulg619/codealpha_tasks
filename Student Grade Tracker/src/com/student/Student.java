package com.student;

import java.util.Arrays;

public class Student {
	private String studentName;
	private String studentClass;
	private double grades[];
	private double total;
	private double avg_marks;
	private double highest;
	private double lowest;

	public Student(String studentName, String studentClass, double[] grades) {
		super();
		this.studentName = studentName;
		this.studentClass = studentClass;
		this.grades = grades;
		this.total = total(grades);
		this.avg_marks = avg_marks(grades);
		this.highest = highest(grades);
		this.lowest = lowest(grades);
	}
	
	
	

	public String getStudentName() {
		return studentName;
	}




	public String getStudentClass() {
		return studentClass;
	}




	public double[] getGrades() {
		return grades;
	}




	public double getTotal() {
		return total;
	}




	public double getAvg_marks() {
		return avg_marks;
	}




	public double getHighest() {
		return highest;
	}




	public double getLowest() {
		return lowest;
	}




	public double total(double grades[]) {
		double sum = 0;
		for (double i : grades) {
			sum += i;
		}
		return sum;

	}
	
	public double avg_marks(double grades[]) {
		double sum = 0;
		for (double i : grades) {
			sum += i;
		}
		return sum/grades.length;
	}
	
	public double highest(double grades[]) {
		double max = 0;
		for (double i : grades) {
			if(max<i) max=i;
			else continue;
		}
		return max;

	}
	
	public double lowest(double grades[]) {
		double low=highest(grades);
		for (double i : grades) {;
			if(low>i) low=i;
			else continue;
		}
		return low;

	}




	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentClass=" + studentClass + ", grades="
				+ Arrays.toString(grades) + ", total=" + total + ", avg_marks=" + avg_marks + ", highest=" + highest
				+ ", lowest=" + lowest + "]";
	}
	
	



}
