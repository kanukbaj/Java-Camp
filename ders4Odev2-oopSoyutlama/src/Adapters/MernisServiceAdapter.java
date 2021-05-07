package Adapters;

import java.rmi.RemoteException;
import Abstract.ICustomerCheckService;
import Entitities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;


public class MernisServiceAdapter implements ICustomerCheckService {
	
	@Override
	public boolean checkIfRealPerson(Customer customer) {
		
		//Burasý adapter kýsmý oldugu icin mernis kimlik dogrulama sistemini dýsarýdan sistemime dahil ettigim
		//adapters'ýn altýnda newleme islemi yapabilirim.
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
			try{
					return client.TCKimlikNoDogrula(customer.getNationalityId(), customer.getFirstName(), customer.getLastName(), customer.getDetaOfBirth());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return false;
				
	}

}
