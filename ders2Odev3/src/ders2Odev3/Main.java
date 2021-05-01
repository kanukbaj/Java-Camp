package ders2Odev3;

public class Main {

	public static void main(String[] args) {
		
		Student student1= new Student(1,"Kayra",
				"Arya",
				"kayrarya",
				"kayrarya@mail.com",
				"Colarodo Universitesi",
				"4",
				17,
				2);
		Student student2 = new Student(2,
				"Eylul",
				"Sarı",
				"eylulsari",
				"eylulsari@mail.com",
				"Canada Universitesi",
				"4",
				17,
				3);
		
		Student [] students = {student1, student2};
		
		UserManager userManager = new UserManager();
		userManager.add(student2);
	}

}
