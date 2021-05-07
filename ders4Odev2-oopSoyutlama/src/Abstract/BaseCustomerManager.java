package Abstract;

import Entitities.Customer;

public class BaseCustomerManager implements ICustomerService{
	
	//�OK �NEML� !!!
		//Concrete paketinin alt�nda bulunan NeroCustomerManager ve StarbuckCustomerManager direkt olarak ICustomerService'i
		//implemente edebilirdi. Fakat senaryo gere�i her 2 MananagerClass'�mda ayn� sekilde veri taban�na ekleme yap�yor.
		//Bu durumda ben bir tane Base bir Manager class'� olusturdum. Bu base ManagerClass'� ICustomerService'i implemente etti.
		//ve ICustomerService'i implemente etti�i i�in ICustomerService'i override etmek zorunda kald�. Ben NeroCustomerManager ve
		//StarbucksCustomerManager classlar�m�nda ortak metodlar� otomatik olarak kullanmas�n� istiyorsam eger bu class'� extend etmeleri
		//gerekir bu sekilde otomatikman burada ki save metodunu kullanabilcekler. E�er bu hareket yap�lmasayd� ve NeroCustomerManager
		//StarbuckCustomerManager direkt olarak ICustomerService'i implemente etseydi her 2 class'�n i�inde de ben ICustomerService'De bulunan
		//save metodunu implemente edip tekrar tekrar yazmak durumunda kalacakt�m ve kod tekrar�na d�secektim. Degismesi gereken bir
		//sey oldugu zaman save metodlarimda her 2 class'�mda da degistirecektim ama direk olarak buradan degistirirsem eger degismesi gereken
		//birseyi her 2 class'�mda da bu metodlar otomatik olarak degisecek yani bir nevi soyle dusunulebilir benim bu class'�m CustomerManager
		//classlar�m icin bir base class gorevinde. ICustomerService CustomerManager tipinde ki classlar�n ortak metodlar� tutuyor yani
		//ICustomerService sayesinde Manager classlar�n�n ortak metodlar�n� gruplam�� oluyorum. Bu base class'�m ICustomerService'i implemente
		//ediyor ve ICustomerService'de ki gruplad�g�m kullan�lmas� gereken ortak metodlar� override etmis oluyor. CustomerManager tipinde ki 
		//classlar�m bu base class'� extend edip burada ki metodlar�  otomatik olarak kullan�yor. Boylece tum CustomerManager classlar�nda
		//bu class'da var olan burada ki metodlari kullan�yor. Degisiklik gereken durumlarda degisiklik buradan yap�l�yor ve tum CustomerManager
		//tipindeki classlar�mda degisiklik gerceklesmis oluyor. Eger bu base class olmasayd� CustomerManger tipindeki classlar�m direkt olarak ICustomerService
		//implemente etseydi. Degisiklik durumunda ne kadar CustomerManager tipinde class'�m varsa tek tek hepsini degistirmek durumunda kalacakt�m.
		//�u unutulmas�n interfaceler yaln�zca govdesiz metodlar� imzalar� tutarlar. Benim CustomerManager'lar icin base class'a ihtiyac�m varsa
		//eger interface base class gorevi gormez. Bu durumda ayr� bir base class olusturulmal� ve bu base class interface'i implemente etmeli.
		//Base class'�m�n abstract olmas�n�n sebebi su ben base class'�m uzerinden islemler yapmak istemiyorum. Sadece CustomerManager tipinde ki classlar�n
		//base class'�m� kullanmas�n� istiyorum. Bu durumda benim base class'�m yaln�zca bir referans tutucu g�revi goruyor. Sadece CustomerManager tipindeki
		//classlar�n referans�n� tutuyor. Bu durumda ben BaseCustomerManager'�n yani CustomerManagerlar icin olusturdugum base class'�n Mainde newlenmesini
		//onlemeliyim. Bundan dolay� bu class'�m�n bas�na abstract ekliyorum ve bu class'�m� soyutluyorum. Bu sekilde base class'�m govdeleri olan ve kendisini
		//extend eden classlar ile govdeli metodlar�n� paylasan , kendisini extend eden classlar�n referans�n� tutan ama ayn� zamanda da bir soyut class oluyor.
		//Sonuc olarak Manager classlar�n interface'i implemente ediyor ama interface base class ihtiyac�n� kar��lam�yor.
		
		
		//C#'ta bu base'deki metodu bu class'� extend eden metodlarda override edebilmek icin void'in soluna virtual anahtar kelimesi geliyor di�er t�rl�
		//bu metodu bu class'� extend eden metodlarda override edemeyiz ama Java'Da boyle bir parametreye ihtiyac yok override islemi icin.
		//Bu metodu StarbucksCustomerManager i�erisinde override etmem laz�m ��nk� StarbucksCustomerManager veri taban�na m�steri kaydederken m�steri bilgilerini
		//mernis ile dogrulamak istiyor. Bu dogrulama islemini save metodunu StarbucksCustomerManager icerisinde override ederek gerceklestirecegim.
		//Neroda boyle bir ihtiyac yok. Dolay�s�yla NeroCustomerManager bu class'� oldugu gibi kullanacag� icin NeroCustomerManager buradaki save metodunu override 
		//etmeyecek.
	
	@Override
	public void save(Customer customer) throws Exception{
		System.out.println("Veri taban�na  kaydedildi : "+ customer.getFirstName());
		}
	
	}


