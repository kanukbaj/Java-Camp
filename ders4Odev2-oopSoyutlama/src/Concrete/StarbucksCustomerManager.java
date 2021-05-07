package Concrete;

import Abstract.BaseCustomerManager;
import Abstract.ICustomerCheckService;
import Entitities.Customer;

public class StarbucksCustomerManager extends BaseCustomerManager{
	
	//Dolayl� yoldan interface'de ki save'i miras ald�. Yani interface'i de referans olarak kullanabilecek. Dolayl� yoldan miras
	//ald� diyoruz cunku BaseCustomer manager'da ICustomerService'i implemente ediyordu.
		
	//StrabucksManager'�n kimlik dogrulamaya ihtiyac� var ben bu kimlik dogurlama isini save metodunun alt�nda yapabilirim
	//Ama gelecekte baska bir musterimde kimlik dogrulama sistemi istediginde benim burada ki save metodunun alt�nda yazd�g�m
	//kimlik dogrulama metodunu kimlik dogrulama isteyen baska musterinin CustomerManager class'�n�n icinde yapmam laz�m. Bu durumda
	//kod tekrar�na dusecegim ve kimlik dogrulama fonksiyonu degistirildiginde tum musterilerde teker teker kodlar�m� degistirmek
	//zorunda kalacagim. Bu problemden kacinmak icin ICustomerCheckService adinda bir interface olusturdum.  Olusturdugum interface'i
	//bu class'imda implemente edip , interface'imde bulunan govdesiz metodu burada doldurabilirim. Bu 1. kullan�m ama daha g�zel 
	//y�ntem var bu y�ntemin ad� da dependency injection. 
	//bICustomerCheckService tipinde bu class'�n alt�nda bir ozellik olusturdum. Bu ozelligin constructorda atamasi yapildi. Yani Mainde ben 
	//StarbuckCustomerManager'� newledigimde ICustomerCheckService objesi vermek zorunday�m. save metodunun alt�nda verdigim ICustomerCheckService
	//objesi sayesinde checkIfRealPerson'a yani kimlik dogrulama metoduna ulasip kimlik dogrulama islemini gerceklestrimis oluyorum.
	
	//�OK �NEML�
	//2. yontem olan dependency injection 1. yonteme gore cok daha iyi. Dependency injection'la kast edilen bag�ml�l�k enjeksiyonu
	//yani biz StarbucksCustomerManager'� Main'De newlerken muhakkak ICustomerCheckService tipinde bir nesneye ihtiyac�m�z var
	//Bu nesnelerimiz de ICustomerCheckService'i implemente eden kimlik dogrulama fonksiyonu checkIfRealPerson metodunu i�erisinde
	//bulunduran kimlik dogrulama amac�yla olusturudugumuz classlar. Biz burada ICustomerCheckService objesine bag�ml�y�z. Ama 
	//bu bagimlilik iyi birsey cunku senaryo geregi starbucks'�n m�sterilerini veri taban�na kaydederken mutlaka kimlik dogrulama
	//sisteminden dogrulama yapmas� gerektigini biliyoruz. Dependency injection ile beraber starbucks musterileri veri tabanina kaydedilmeden
	//once bu kimlik dogrulama islemini zorunlu k�ld�k. Eger 1. yontem kullan�lsayd� eger StarbucksCustomerManager ICustomerCheckService'i
	//implemente etseydi ve checkIfRealPerson burada metod olarak bulunsayd� sayet ben Mainde StarbucksCustomerManager'i manager newlerken
	//benden ICustomerCheckService tipinde bir nesne istenmeyecekti. Bu durumda kimlik dogrulama islemi yapmadan starbucks m�sterilerinin 
	//sisteme kaydedilmesine yol a�abilirdi. Mainde StarbucksCustomerManager newleyip save metodunu calistirirsak ve checkIfRealPerson metodunu oncesinde
	//bir sart olarak save metodundan once uyarlamazsak starbucks musterileri kimlik dogrulama sistemine gecmeden kaydedilir. Dependency injection ile
	//hem senaryoda ger�ekle�mesi %100 gereken bir isteri ger�ekle�tirmi� olduk hemde Mainde save isleminden once  musteri kimlik dogrulamas� icin 
	//yaz�lmas� gereken sart� kodlamaktan kurtulduk.
	
	ICustomerCheckService customerCheckService;
	
	public StarbucksCustomerManager(ICustomerCheckService customerCheckService) {
		this.customerCheckService = customerCheckService;
	}

	@Override
	public void save(Customer customer) throws Exception {
		
		if(customerCheckService.checkIfRealPerson(customer)) {
			super.save(customer);
			//Eger kimlik dogrulama metodumuz true donerse kay�t islemi yap�lacak
			//false ise de hata f�rlataca��z. 
			
			//yeni birsey ogrendik demekki illa super constructor'�n
			//alt�nda ozellikler icin kullanacaz diye birsey yok extend ettigimiz
			//class'in metodlari icinde kullanabiliyoruz super parametresini
		}
		
		else {
				throw new Exception("Not a valid person!");
		}
	}
	
}
