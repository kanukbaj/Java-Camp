
import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entitities.Customer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		//Bunlar normalde ioc containerlar ile  kontrol edilir newleme islemi bu sekilde cok fazla yapýlmaz.
		//StarbucksCustomerManager'ýn ve customerManager'ýn içerisinde ki newlemelerden bahsediyorum
		//Ama suanda gercek bir veri tabaný ile calýsmýyorum. Simülasyon yapýyorum.
			
		//Hatýrlarsak eger abstract ile BaseCustomerManager'ýn Main'De newlenmesini istemedigimi soylemistim
		//Sadece referans tutucu olmalý demistim. Burada da olusturdugum StarbucksCustomerManager'ýn 
		//refaransýný tutuyor.
			
		//Normalde sayýsal islemlere tabi tutulmayan sayýsal degerleri string olarak tutardýk fakat 
		//kimlik dogrulama sistemi aracýlýgýyla kullandýgýmýz fonksiyon tc parametresini Long degerde istiyor
		//bundan dolayý Long deger'de yolladýk tc'mizi.
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.save(new Customer(1, "Baran Emre", "Türkmen", 1997, 27497433098L));
		
		
		//Senaryo geregi starbucks veri tabanýna kullanýcý kaydederken kimlik dogrulamasý istiyor
		//Ama nero istemiyor. Bu durumda ben bu kimlik dogrulama isini ICustomerService interface'ine
		//yazamam. Interface'e yazarsam zaten base durumunda olan abstract class'ýmda bu kimlik dogrulama
		//metodunu kullanacak. Bu durumda nero'da otomaik kimlik dogrulama metodunu kullanmis olacak. 
		//Interface'e yazmayalým abstract olan base class'a yazalým zaten olmaz yukarýda sebebini acikladigim sekilde
		//abstract'da ise bu metod her turlu nero kullanýr ben neronun kimlik dogrulama icin yazacagým metodu
		//kullanmasýný istemiyorum.
				
		//Ozet Ayrýntýlý Acýklamalar Yine Classlarýn Ýcerisinde Mevcut
		//Yukarýdaki yapýnýn kurulumu hakkýnda ozet gecmek gerekirse BaseCustomerManager tüm müsterilerimde var olan
		//metodlarý iceren ICustomerService'i implemente ediyor. NeroCustomerManager ve StarbucksCustomerManager
		//Nero ve Starbucks firmalarý icin musteri kayýt islemini yapan CustomerManager classlarým. Bu classlarýmda
		//BaseCustomerManager'ý extend ediyor. Dolayýsýyla dolaylý yoldan da olsa ICustomerService'i implemente
		//ediyorlar. Burada  BaseCustomerManager class'ý referans tutucu gorevinde bu yuzden abstrac bir class.
		//StarbucksCustomerManager dependency injectionla bir adet ICustomerCheckService tipinde bir nesne
		//istiyor. ICustomerCheckService tipinde ki nesnelerim sayesinde ben kimlik dogrulama islemlerimi gerceklestiriyorum.
		//Dogal olarak arkada kimlik dogrulama islemlerini gerceklestirdigim classlar ICustomerCheckService'i implemente ediyorlar.
		//Base class'ýnda bulunan save metodunu StarbucksCustomerManager ve NeroCustomerManager extend ettiginden rahatlýkla kullanabiliyorlar
		//StarbucksCustomerManager'a kimlik dogrulamasý sartýna sahip oldugundan dependency injection islemi uygulandý. Dolayýsýyla
		//save metodu kimlik dogrulama sistemini icerecek sekilde override edildi. Fakat kimlik dogrulama icin gereken tum kodlar
		//Solid prensibleri dogrultusunda StarbucksCustomerManager altýndaki save metodu altýnda yapýlmadý. Kimlik dogrulama icin 
		//ICustomerCheckService interface'i olusturuldu ve kimlik dogrulama islemine sahip classlar bu interface'i implemente etti
		//StarbucksCustomerManager altýndaki save metodu Mainde bu interface'i implemente eden hangi class verildiyse o class'a 
		//gore kimlik dogrulama islemini yapabilecek sekilde ayarlandý. Bu ayarýda yukarýda bahsettigim sekilde dependency injection
		//ile yaptýk.
	}

}
