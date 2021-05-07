
import Abstract.BaseCustomerManager;
import Adapters.MernisServiceAdapter;
import Concrete.NeroCustomerManager;
import Concrete.StarbucksCustomerManager;
import Entitities.Customer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		//Bunlar normalde ioc containerlar ile  kontrol edilir newleme islemi bu sekilde cok fazla yap�lmaz.
		//StarbucksCustomerManager'�n ve customerManager'�n i�erisinde ki newlemelerden bahsediyorum
		//Ama suanda gercek bir veri taban� ile cal�sm�yorum. Sim�lasyon yap�yorum.
			
		//Hat�rlarsak eger abstract ile BaseCustomerManager'�n Main'De newlenmesini istemedigimi soylemistim
		//Sadece referans tutucu olmal� demistim. Burada da olusturdugum StarbucksCustomerManager'�n 
		//refarans�n� tutuyor.
			
		//Normalde say�sal islemlere tabi tutulmayan say�sal degerleri string olarak tutard�k fakat 
		//kimlik dogrulama sistemi arac�l�g�yla kulland�g�m�z fonksiyon tc parametresini Long degerde istiyor
		//bundan dolay� Long deger'de yollad�k tc'mizi.
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new MernisServiceAdapter());
		customerManager.save(new Customer(1, "Baran Emre", "T�rkmen", 1997, 27497433098L));
		
		
		//Senaryo geregi starbucks veri taban�na kullan�c� kaydederken kimlik dogrulamas� istiyor
		//Ama nero istemiyor. Bu durumda ben bu kimlik dogrulama isini ICustomerService interface'ine
		//yazamam. Interface'e yazarsam zaten base durumunda olan abstract class'�mda bu kimlik dogrulama
		//metodunu kullanacak. Bu durumda nero'da otomaik kimlik dogrulama metodunu kullanmis olacak. 
		//Interface'e yazmayal�m abstract olan base class'a yazal�m zaten olmaz yukar�da sebebini acikladigim sekilde
		//abstract'da ise bu metod her turlu nero kullan�r ben neronun kimlik dogrulama icin yazacag�m metodu
		//kullanmas�n� istemiyorum.
				
		//Ozet Ayr�nt�l� Ac�klamalar Yine Classlar�n �cerisinde Mevcut
		//Yukar�daki yap�n�n kurulumu hakk�nda ozet gecmek gerekirse BaseCustomerManager t�m m�sterilerimde var olan
		//metodlar� iceren ICustomerService'i implemente ediyor. NeroCustomerManager ve StarbucksCustomerManager
		//Nero ve Starbucks firmalar� icin musteri kay�t islemini yapan CustomerManager classlar�m. Bu classlar�mda
		//BaseCustomerManager'� extend ediyor. Dolay�s�yla dolayl� yoldan da olsa ICustomerService'i implemente
		//ediyorlar. Burada  BaseCustomerManager class'� referans tutucu gorevinde bu yuzden abstrac bir class.
		//StarbucksCustomerManager dependency injectionla bir adet ICustomerCheckService tipinde bir nesne
		//istiyor. ICustomerCheckService tipinde ki nesnelerim sayesinde ben kimlik dogrulama islemlerimi gerceklestiriyorum.
		//Dogal olarak arkada kimlik dogrulama islemlerini gerceklestirdigim classlar ICustomerCheckService'i implemente ediyorlar.
		//Base class'�nda bulunan save metodunu StarbucksCustomerManager ve NeroCustomerManager extend ettiginden rahatl�kla kullanabiliyorlar
		//StarbucksCustomerManager'a kimlik dogrulamas� sart�na sahip oldugundan dependency injection islemi uyguland�. Dolay�s�yla
		//save metodu kimlik dogrulama sistemini icerecek sekilde override edildi. Fakat kimlik dogrulama icin gereken tum kodlar
		//Solid prensibleri dogrultusunda StarbucksCustomerManager alt�ndaki save metodu alt�nda yap�lmad�. Kimlik dogrulama icin 
		//ICustomerCheckService interface'i olusturuldu ve kimlik dogrulama islemine sahip classlar bu interface'i implemente etti
		//StarbucksCustomerManager alt�ndaki save metodu Mainde bu interface'i implemente eden hangi class verildiyse o class'a 
		//gore kimlik dogrulama islemini yapabilecek sekilde ayarland�. Bu ayar�da yukar�da bahsettigim sekilde dependency injection
		//ile yapt�k.
	}

}
