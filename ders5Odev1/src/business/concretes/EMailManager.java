package business.concretes;

import business.abstracts.EMailService;

public class EMailManager implements EMailService {
	
	@Override
	
	public void send() {
		System.out.println("Doðrulama mailiniz gönderilmiþtir. ");
	}
	
	@Override
	
	public void verify() {
		System.out.println("Mailiniz doðrulanmýþtýr. ");
	}
	

}
