package ders5Odev1;

import business.abstracts.EMailService;
import business.abstracts.UserService;
import business.concretes.EMailManager;
import business.concretes.UserManager;
import business.concretes.ValidationManager;
import core.JGoogleRegistrationManagerAdapter;
import core.MyRegistrationManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		User kadri = new User(1,"Kadri", "Ozcan", "kadri@gmail.com", "123kadri123");
		User ali = new User(1, "ali", "veli", "aveli@gmail.com", "123veli123");
		
		UserService userService = new UserManager(new MyRegistrationManager(), new HibernateUserDao()),
				new ValidationManager());
				
		UserService userServiceGoole = new UserManager(new JGoogleRegistrationManagerAdapter(), new HibernateUserDao(),
				new ValidationManager());
		
		EMailService eMailService = new EMailManager();
		
		
		userService.singUp(kadri);
		eMailService.send();
		eMailService.verify();
		
		System.out.println("------------------------------------");
		
		userServiceGoole.singUp(ali);
		eMailService.send();
		eMailService.verify();
		
		System.out.println("---------------------------------------");
		
		
		userService.logIn(kadri, "kadri@gmil.com", "123kadri123");
		userService.logIn(ali, "aveli@gmail.com", "123veli123");
	}

}
