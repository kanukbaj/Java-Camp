package Abstract;

import Entitities.Customer;

public interface ICustomerService {
	
	//T�m m��terilerimde var olan metodlar� interface ile soyutlamal�s�n. Bu �ekilde ortak metodlar�m� gruplam�� oluyorum ve sisteme yeni m��teriler eklendi�inde
		//ve bu interface'i implemente ettiklerinde ortak metodlar� da i�ermek zorunda kal�caklar. Dolay�s�yla olmas� gereken metodlar� i�ermeyen bir m��teri class'�
		//kalmayacak. Eklenen m��teri class'lar�ndan biri bu interface'in alt�ndaki metodlar� i�ermek istemiyorsa e�er o m��teri i�in farkl� dizayn yoluna gidilebilir.
		//Tabi bu farkl� dizayn durumu overdizayn denilen durumu ortaya ��karmamal� karar�nda olmal�.
	
	void save(Customer customer) throws Exception;

}
