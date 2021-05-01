package ders2Odev1;

public class Main {
	
	public static void main(String[] args) {
		
		Student student1 = new Student (1,"Ali", "AKKOR", "ali.akkor@mail.com");
		Student student2 = new Student (2, "Eylül", "UYGUR", "ayse.uygur@mail.com");
		
		Student[] student = {student1, student2};
	
		Course course1 = new Course (1, "Yazılım Geliştirici Yetiştirme Kampı (C# /Angular)", "Engin Demiroğ",
			"2 ay sürecek Yazılım Geliştirici Kampı" ,"Nitelikli","", 0);
		Course course2 = new Course (2, "Java/React","1 ay sürecek", "Engin Demiroğ",
				"Yazılım Geliştirici Kamp", "Nitelikli", 0);
		
		Course[] course = {course1, course2};
		
		System.out.println("Öğrenciler");
		
		for (Student students : student) {
			System.out.println(students.name + " " + students.surname);
		}
		
		System.out.println("Kurslar");
		
		for (Course courses : course) {
			System.out.println(courses.courseName);
		}
		
				
		CourseManager courseManager = new CourseManager();
		
		courseManager.join(course1);
		courseManager.Add(course1);
		courseManager.Update(course2);
		courseManager.Delete(course2);
		
		StudentManager studentManager = new StudentManager();
		studentManager.addToStudent(student1);
		studentManager.addToStudent(student2);
		studentManager.deleteFromStudent(student1);
		
		Instructor instructor = new Instructor();
		instructor.id = 1;
		instructor.name = "Engin Demiroğ";
		
		Instructor instructor1 = new Instructor();
		instructor1.id = 1;
		instructor1.name = "Engin Demiroğ";
		
		System.out.println(instructor1.name);
	}

}
