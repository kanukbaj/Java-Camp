package dataAccess.abstracts;

import java.util.ArrayList;

import entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void delete(User user);
	User get(int id);
	ArrayList<String> getAllMails();

}
