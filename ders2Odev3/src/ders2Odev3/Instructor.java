package ders2Odev3;

public class Instructor extends User {
	
	private int givenCourseAmount;
	private int salary;
	
	public Instructor(int id,String name,String lastname, String username,String email, int givenCourseAmount, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.givenCourseAmount = givenCourseAmount;
		this.salary = salary;
	}
	
	public int getgivenCourseAmount() {
		return givenCourseAmount;
	}
	public void setgivenCourseAmount(int givenCourseAmount) {
		this.givenCourseAmount = givenCourseAmount;
	}
	
	public int getsalary() {
		return salary;
	}
	public void setsalary(int salary) {
		this.salary = salary;
	}	

}
