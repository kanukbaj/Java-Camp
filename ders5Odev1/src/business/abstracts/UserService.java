package business.abstracts;

import entities.concretes.User;

public interface UserService {
	
	void singUp(User user);
	void logIn(User user, String eMail, String password);

}
