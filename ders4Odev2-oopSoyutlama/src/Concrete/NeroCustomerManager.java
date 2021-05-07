package Concrete;

import Abstract.BaseCustomerManager;

public class NeroCustomerManager extends BaseCustomerManager {
	
	//Dolayl� yoldan interface'de ki save'i miras ald�. Yani interface'i de referans olarak kullanabilecek. Dolayl� yoldan miras
	//ald� diyoruz cunku BaseCustomer manager'Da ICustomerService'i implemente ediyordu.
		
	//NeroCustomerManager'da kimlik bilgisi ile do�rulama yap�ld�ktan sonra m��terilerini kaydetmek isterse StarbucksManager'da yapt�g�m�z
	//islemleri aynen yapmam�z yeterli. Hatta kodumuz o kadar esnek ki istersek Nero hem default olarak sistemimizde bulunan kimlik dogrulama
	//sistemini kullan�r(default olarak direkt true donen CustomerCheckManager class'� sim�lasyon amac�yla tasarlad�k.) Hem de mernis kimlik dogrulama
	//sistemini kullanabilir. Tabi ki ayn� durum StarbucksCustomerManager i�inde ge�erli , istersek e�er StarbucksCustomerManager'da 
	//default olarak sistemimizde bulunan kimlik dogrulama sistemini kullanabilir. Bu durum Mainde StarbucksCustomerManager newlenirken StarbucksCustomerManager'�n
	//constructor�nda bulunan ICustomerCheckService objesi olan customerCheckService'e ne verdiginizle ilgili.

}
