package business.concretes;

import business.abstracts.EMailService;

public class EMailManager implements EMailService {
	
	@Override
	
	public void send() {
		System.out.println("Doğrulama mailiniz gönderilmiştir. ");
	}
	
	@Override
	
	public void verify() {
		System.out.println("Mailiniz doğrulanmıştır. ");
	}
	

}
