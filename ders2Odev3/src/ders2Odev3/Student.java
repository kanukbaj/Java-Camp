package ders2Odev3;

public class Student extends User {
	
	private String univertsity;
	private String yearOfSeniority;
	private int age;
	private int amountOfTakenCourse;
	
	
	public Student(int id, String name,String lastname,String username, String email,
			String university, String yearOfSeniority,int age,int amountOfTakenCourse) {
			this.id=id;
			this.name=name;
			this.lastname=lastname;
			this.username=username;
			this.email=email;
			this.univertsity=university;
			this.yearOfSeniority=yearOfSeniority;
			this.age=age;
			this.amountOfTakenCourse=amountOfTakenCourse;
		
	}
	
	public String getuniversity() {
		return univertsity;
	}
	public void setuniversity(String university) {
		this.univertsity = university;
	}
	
	public String getyearOfSeniority() {
		return yearOfSeniority;
	}
	public void setyearOfSeniority(String yearOfSeniority) {
		this.yearOfSeniority = yearOfSeniority;
	}
	
	public int getage() {
		return age;
	}
	public void setage(int age) {
		this.age = age;
	}
	
	public int getamountOfTakenCourse() {
		return amountOfTakenCourse;
	}
	public void setamountOfTakenCourse(int amountOfTakenCourse) {
		this.amountOfTakenCourse=amountOfTakenCourse;
	}

}
