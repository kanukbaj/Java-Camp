package Abstract;

import Entitities.Customer;

public interface ICustomerService {
	
	//Tüm müþterilerimde var olan metodlarý interface ile soyutlamalýsýn. Bu þekilde ortak metodlarýmý gruplamýþ oluyorum ve sisteme yeni müþteriler eklendiðinde
		//ve bu interface'i implemente ettiklerinde ortak metodlarý da içermek zorunda kalýcaklar. Dolayýsýyla olmasý gereken metodlarý içermeyen bir müþteri class'ý
		//kalmayacak. Eklenen müþteri class'larýndan biri bu interface'in altýndaki metodlarý içermek istemiyorsa eðer o müþteri için farklý dizayn yoluna gidilebilir.
		//Tabi bu farklý dizayn durumu overdizayn denilen durumu ortaya çýkarmamalý kararýnda olmalý.
	
	void save(Customer customer) throws Exception;

}
