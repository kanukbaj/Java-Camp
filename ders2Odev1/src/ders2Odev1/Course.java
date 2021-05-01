package ders2Odev1;

public class Course {
	
	public Course() {
		System.out.println("Kurs yapýcý bloðu çalýþtý");
	}
	
	public Course(int id, String title, String courseName, String courseTeacher, String detail, String instructor, int price) {
		this();
		this.id = id;
		this.courseName = courseName;
		this.courseTeacher = courseTeacher;
		this.price = price;
		this.title = title;
		this.instructor = instructor;
	}
	
	int id;
	String courseName;
	String courseTeacher;
	int price;
	String title;
	String instructor;

}
