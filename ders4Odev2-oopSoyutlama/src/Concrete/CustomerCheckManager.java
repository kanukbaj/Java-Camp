package Concrete;

import Abstract.ICustomerCheckService;
import Entitities.Customer;


public class CustomerCheckManager implements ICustomerCheckService {
	
	//Bu class ICustomerCheckService'i implemente ediyor. Simdi bu class sayesinde StarbucksCustomerManager'dan bagimsiz bir sekilde
	//bir dogrulama metodu olusturdum. Kimlik dogrulama sisteminden hata gelmezse eger default olarak true yolluyor metodumuz.

	@Override
	
	public boolean checkIfRealPerson(Customer customer) {
		
		//Burada mernis'e ait kodlar� koyabilir ve cal�st�rabilirdik fakat bu durumda da bu metodun alt�nda 
		//bir newleme islemi gerceklestirecektik. Bu islem yuzunden checkIfRealPerson metodum mernis kimlik dogrulama sistemine
		//tamamen bag�ml� olacakt� ve bu bizim istemedigimiz birsey. Bundan dolay� mernis'i kendi sistemime entegre ederken 
		//adapters diye bir paket olusturuyorum ve adapters'�n alt�ndan mernis'i sistemime entegre ediyorum. D�� bir sistemi sisteme
		//dahil ederken bu y�ntem kullan�l�r yani adapters denilen design patterns kullan�l�r. Buras� bizim kendi servisimiz. Bize ait kodlar
		//burada olmal� . D��ar�dan sisteme entegre edece�im servisler adapters'�n alt�nda olmal�. Buras� bo� g�z�k�yor ama burada kendi servimizle
		//alakal� olan checkIfRealPerson metodu �al��t�r�labilir. Burada kendi servisimizle ilgili kodlar�n oldugunu dusunebiliriz.
	
		return true;
	}
}
