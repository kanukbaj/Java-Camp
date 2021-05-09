package business.abstracts;

import java.util.ArrayList;

import entities.concretes.User;

public interface ValidationService {
	boolean passwordIsVerified(User user);
	boolean eMailIsVerified(User user, ArrayList<String> emails);
	boolean firstNameIsVerified(User user);
	boolean lastNameIsVerified(User user);

}
