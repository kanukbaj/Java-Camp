package business.concretes;

import business.abstracts.EMailService;

public class EMailManager implements EMailService {
	
	@Override
	
	public void send() {
		System.out.println("Do�rulama mailiniz g�nderilmi�tir. ");
	}
	
	@Override
	
	public void verify() {
		System.out.println("Mailiniz do�rulanm��t�r. ");
	}
	

}
