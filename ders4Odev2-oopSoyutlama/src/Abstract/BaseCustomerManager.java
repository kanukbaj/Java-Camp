package Abstract;

import Entitities.Customer;

public class BaseCustomerManager implements ICustomerService{
	
	//ÇOK ÖNEMLÝ !!!
		//Concrete paketinin altýnda bulunan NeroCustomerManager ve StarbuckCustomerManager direkt olarak ICustomerService'i
		//implemente edebilirdi. Fakat senaryo gereði her 2 MananagerClass'ýmda ayný sekilde veri tabanýna ekleme yapýyor.
		//Bu durumda ben bir tane Base bir Manager class'ý olusturdum. Bu base ManagerClass'ý ICustomerService'i implemente etti.
		//ve ICustomerService'i implemente ettiði için ICustomerService'i override etmek zorunda kaldý. Ben NeroCustomerManager ve
		//StarbucksCustomerManager classlarýmýnda ortak metodlarý otomatik olarak kullanmasýný istiyorsam eger bu class'ý extend etmeleri
		//gerekir bu sekilde otomatikman burada ki save metodunu kullanabilcekler. Eðer bu hareket yapýlmasaydý ve NeroCustomerManager
		//StarbuckCustomerManager direkt olarak ICustomerService'i implemente etseydi her 2 class'ýn içinde de ben ICustomerService'De bulunan
		//save metodunu implemente edip tekrar tekrar yazmak durumunda kalacaktým ve kod tekrarýna düsecektim. Degismesi gereken bir
		//sey oldugu zaman save metodlarimda her 2 class'ýmda da degistirecektim ama direk olarak buradan degistirirsem eger degismesi gereken
		//birseyi her 2 class'ýmda da bu metodlar otomatik olarak degisecek yani bir nevi soyle dusunulebilir benim bu class'ým CustomerManager
		//classlarým icin bir base class gorevinde. ICustomerService CustomerManager tipinde ki classlarýn ortak metodlarý tutuyor yani
		//ICustomerService sayesinde Manager classlarýnýn ortak metodlarýný gruplamýþ oluyorum. Bu base class'ým ICustomerService'i implemente
		//ediyor ve ICustomerService'de ki grupladýgým kullanýlmasý gereken ortak metodlarý override etmis oluyor. CustomerManager tipinde ki 
		//classlarým bu base class'ý extend edip burada ki metodlarý  otomatik olarak kullanýyor. Boylece tum CustomerManager classlarýnda
		//bu class'da var olan burada ki metodlari kullanýyor. Degisiklik gereken durumlarda degisiklik buradan yapýlýyor ve tum CustomerManager
		//tipindeki classlarýmda degisiklik gerceklesmis oluyor. Eger bu base class olmasaydý CustomerManger tipindeki classlarým direkt olarak ICustomerService
		//implemente etseydi. Degisiklik durumunda ne kadar CustomerManager tipinde class'ým varsa tek tek hepsini degistirmek durumunda kalacaktým.
		//Þu unutulmasýn interfaceler yalnýzca govdesiz metodlarý imzalarý tutarlar. Benim CustomerManager'lar icin base class'a ihtiyacým varsa
		//eger interface base class gorevi gormez. Bu durumda ayrý bir base class olusturulmalý ve bu base class interface'i implemente etmeli.
		//Base class'ýmýn abstract olmasýnýn sebebi su ben base class'ým uzerinden islemler yapmak istemiyorum. Sadece CustomerManager tipinde ki classlarýn
		//base class'ýmý kullanmasýný istiyorum. Bu durumda benim base class'ým yalnýzca bir referans tutucu görevi goruyor. Sadece CustomerManager tipindeki
		//classlarýn referansýný tutuyor. Bu durumda ben BaseCustomerManager'ýn yani CustomerManagerlar icin olusturdugum base class'ýn Mainde newlenmesini
		//onlemeliyim. Bundan dolayý bu class'ýmýn basýna abstract ekliyorum ve bu class'ýmý soyutluyorum. Bu sekilde base class'ým govdeleri olan ve kendisini
		//extend eden classlar ile govdeli metodlarýný paylasan , kendisini extend eden classlarýn referansýný tutan ama ayný zamanda da bir soyut class oluyor.
		//Sonuc olarak Manager classlarýn interface'i implemente ediyor ama interface base class ihtiyacýný karþýlamýyor.
		
		
		//C#'ta bu base'deki metodu bu class'ý extend eden metodlarda override edebilmek icin void'in soluna virtual anahtar kelimesi geliyor diðer türlü
		//bu metodu bu class'ý extend eden metodlarda override edemeyiz ama Java'Da boyle bir parametreye ihtiyac yok override islemi icin.
		//Bu metodu StarbucksCustomerManager içerisinde override etmem lazým çünkü StarbucksCustomerManager veri tabanýna müsteri kaydederken müsteri bilgilerini
		//mernis ile dogrulamak istiyor. Bu dogrulama islemini save metodunu StarbucksCustomerManager icerisinde override ederek gerceklestirecegim.
		//Neroda boyle bir ihtiyac yok. Dolayýsýyla NeroCustomerManager bu class'ý oldugu gibi kullanacagý icin NeroCustomerManager buradaki save metodunu override 
		//etmeyecek.
	
	@Override
	public void save(Customer customer) throws Exception{
		System.out.println("Veri tabanýna  kaydedildi : "+ customer.getFirstName());
		}
	
	}


