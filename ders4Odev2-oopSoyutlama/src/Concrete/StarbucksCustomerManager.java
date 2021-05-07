package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Entitities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager{
	
	//Dolaylý yoldan interface'de ki save'i miras aldý. Yani interface'i de referans olarak kullanabilecek. Dolaylý yoldan miras
	//aldý diyoruz cunku BaseCustomer manager'da ICustomerService'i implemente ediyordu.
		
	//StrabucksManager'ýn kimlik dogrulamaya ihtiyacý var ben bu kimlik dogurlama isini save metodunun altýnda yapabilirim
	//Ama gelecekte baska bir musterimde kimlik dogrulama sistemi istediginde benim burada ki save metodunun altýnda yazdýgým
	//kimlik dogrulama metodunu kimlik dogrulama isteyen baska musterinin CustomerManager class'ýnýn icinde yapmam lazým. Bu durumda
	//kod tekrarýna dusecegim ve kimlik dogrulama fonksiyonu degistirildiginde tum musterilerde teker teker kodlarýmý degistirmek
	//zorunda kalacagim. Bu problemden kacinmak icin ICustomerCheckService adinda bir interface olusturdum.  Olusturdugum interface'i
	//bu class'imda implemente edip , interface'imde bulunan govdesiz metodu burada doldurabilirim. Bu 1. kullaným ama daha güzel 
	//yöntem var bu yöntemin adý da dependency injection. 
	//bICustomerCheckService tipinde bu class'ýn altýnda bir ozellik olusturdum. Bu ozelligin constructorda atamasi yapildi. Yani Mainde ben 
	//StarbuckCustomerManager'ý newledigimde ICustomerCheckService objesi vermek zorundayým. save metodunun altýnda verdigim ICustomerCheckService
	//objesi sayesinde checkIfRealPerson'a yani kimlik dogrulama metoduna ulasip kimlik dogrulama islemini gerceklestrimis oluyorum.
	
	//ÇOK ÖNEMLÝ
	//2. yontem olan dependency injection 1. yonteme gore cok daha iyi. Dependency injection'la kast edilen bagýmlýlýk enjeksiyonu
	//yani biz StarbucksCustomerManager'ý Main'De newlerken muhakkak ICustomerCheckService tipinde bir nesneye ihtiyacýmýz var
	//Bu nesnelerimiz de ICustomerCheckService'i implemente eden kimlik dogrulama fonksiyonu checkIfRealPerson metodunu içerisinde
	//bulunduran kimlik dogrulama amacýyla olusturudugumuz classlar. Biz burada ICustomerCheckService objesine bagýmlýyýz. Ama 
	//bu bagimlilik iyi birsey cunku senaryo geregi starbucks'ýn müsterilerini veri tabanýna kaydederken mutlaka kimlik dogrulama
	//sisteminden dogrulama yapmasý gerektigini biliyoruz. Dependency injection ile beraber starbucks musterileri veri tabanina kaydedilmeden
	//once bu kimlik dogrulama islemini zorunlu kýldýk. Eger 1. yontem kullanýlsaydý eger StarbucksCustomerManager ICustomerCheckService'i
	//implemente etseydi ve checkIfRealPerson burada metod olarak bulunsaydý sayet ben Mainde StarbucksCustomerManager'i manager newlerken
	//benden ICustomerCheckService tipinde bir nesne istenmeyecekti. Bu durumda kimlik dogrulama islemi yapmadan starbucks müsterilerinin 
	//sisteme kaydedilmesine yol açabilirdi. Mainde StarbucksCustomerManager newleyip save metodunu calistirirsak ve checkIfRealPerson metodunu oncesinde
	//bir sart olarak save metodundan once uyarlamazsak starbucks musterileri kimlik dogrulama sistemine gecmeden kaydedilir. Dependency injection ile
	//hem senaryoda gerçekleþmesi %100 gereken bir isteri gerçekleþtirmiþ olduk hemde Mainde save isleminden once  musteri kimlik dogrulamasý icin 
	//yazýlmasý gereken sartý kodlamaktan kurtulduk.
	
	ICustomerCheckService customerCheckService;
	
	public StarbucksCustomerManager(ICustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}

	@Override
	public void save(Customer customer) throws Exception {
		
		if(customerCheckService.checkIfRealPerson(customer)) {
			super.save(customer);
			//Eger kimlik dogrulama metodumuz true donerse kayýt islemi yapýlacak
			//false ise de hata fýrlatacaðýz. 
			
			//yeni birsey ogrendik demekki illa super constructor'ýn
			//altýnda ozellikler icin kullanacaz diye birsey yok extend ettigimiz
			//class'in metodlari icinde kullanabiliyoruz super parametresini
		}
		
		else {
				throw new Exception("Not a valid person!");
		}
	}
	
}
