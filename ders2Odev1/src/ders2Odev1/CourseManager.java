package ders2Odev1;

public class CourseManager {
	
	public void join(Course course) {
		System.out.println("Programa Dahil ol " + course.title);
	}
	
	public void Add(Course course) {
		System.out.println("Kurs eklendi: " + course.title);
	}
	
	public void Update(Course course) {
		System.out.println("Kurs güncellendi: " + course.title);
	}
	
	public void Delete(Course course) {
		System.out.println("Kurs silindi: " + course.title);
	}

}
