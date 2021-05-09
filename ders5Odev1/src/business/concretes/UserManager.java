package business.concretes;

import business.abstracts.UserService;
import business.abstracts.ValidationService;
import core.SignUpService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {
	
	private UserDao userDao;
	private SignUpService signUpService;
	private ValidationService validationService;
	
	public UserManager(UserDao userDao, SignUpService singUpService, ValidationService validationService) {
		super();
		this.userDao = userDao;
		this.signUpService = singUpService;
		this.validationService = validationService;
	}
	
	@Override
	
	public void singUp(User user) {
		
		if(validationService.eMailIsVerified(user, userDao.getAllMails()) == true
				&& validationService.firstNameIsVerified(user) == true
				&& validationService.lastNameIsVerified(user) == true) {
		System.out.println("Sifre ve E-mail gecerli. Kayit yapildi : " + user.getFirstName());
		
		this.userDao.add(user);
		this.signUpService.singUp();
		
		}else {
			System.out.println("Lutfen gecerli E-mail ve sifre ile tekrar deneyiniz. ");
		}
	}
	
	@Override
	
	public void logIn(User user, String eMail, String password) {
		if(eMail == user.geteMail() && password == user.getPassword()){
			System.out.println("Bilgiler dogru. Giris yapildi. ");
		}else {
			System.out.println("Giris basarisiz. Yanlis email ve sifre girdiniz. ");
		}
	}

	
}
