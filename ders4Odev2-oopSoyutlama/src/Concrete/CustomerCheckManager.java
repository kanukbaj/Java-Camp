package Concrete;

import Abstract.ICustomerCheckService;
import Entitities.Customer;


public class CustomerCheckManager implements ICustomerCheckService {
	
	//Bu class ICustomerCheckService'i implemente ediyor. Simdi bu class sayesinde StarbucksCustomerManager'dan bagimsiz bir sekilde
	//bir dogrulama metodu olusturdum. Kimlik dogrulama sisteminden hata gelmezse eger default olarak true yolluyor metodumuz.

	@Override
	
	public boolean checkIfRealPerson(Customer customer) {
		
		//Burada mernis'e ait kodlarý koyabilir ve calýstýrabilirdik fakat bu durumda da bu metodun altýnda 
		//bir newleme islemi gerceklestirecektik. Bu islem yuzunden checkIfRealPerson metodum mernis kimlik dogrulama sistemine
		//tamamen bagýmlý olacaktý ve bu bizim istemedigimiz birsey. Bundan dolayý mernis'i kendi sistemime entegre ederken 
		//adapters diye bir paket olusturuyorum ve adapters'ýn altýndan mernis'i sistemime entegre ediyorum. Dýþ bir sistemi sisteme
		//dahil ederken bu yöntem kullanýlýr yani adapters denilen design patterns kullanýlýr. Burasý bizim kendi servisimiz. Bize ait kodlar
		//burada olmalý . Dýþarýdan sisteme entegre edeceðim servisler adapters'ýn altýnda olmalý. Burasý boþ gözüküyor ama burada kendi servimizle
		//alakalý olan checkIfRealPerson metodu çalýþtýrýlabilir. Burada kendi servisimizle ilgili kodlarýn oldugunu dusunebiliriz.
	
		return true;
	}
}
