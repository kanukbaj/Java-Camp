package Concrete;

import Abstract.BaseCustomerManager;

public class NeroCustomerManager extends BaseCustomerManager {
	
	//Dolaylý yoldan interface'de ki save'i miras aldý. Yani interface'i de referans olarak kullanabilecek. Dolaylý yoldan miras
	//aldý diyoruz cunku BaseCustomer manager'Da ICustomerService'i implemente ediyordu.
		
	//NeroCustomerManager'da kimlik bilgisi ile doðrulama yapýldýktan sonra müþterilerini kaydetmek isterse StarbucksManager'da yaptýgýmýz
	//islemleri aynen yapmamýz yeterli. Hatta kodumuz o kadar esnek ki istersek Nero hem default olarak sistemimizde bulunan kimlik dogrulama
	//sistemini kullanýr(default olarak direkt true donen CustomerCheckManager class'ý simülasyon amacýyla tasarladýk.) Hem de mernis kimlik dogrulama
	//sistemini kullanabilir. Tabi ki ayný durum StarbucksCustomerManager içinde geçerli , istersek eðer StarbucksCustomerManager'da 
	//default olarak sistemimizde bulunan kimlik dogrulama sistemini kullanabilir. Bu durum Mainde StarbucksCustomerManager newlenirken StarbucksCustomerManager'ýn
	//constructorýnda bulunan ICustomerCheckService objesi olan customerCheckService'e ne verdiginizle ilgili.

}
