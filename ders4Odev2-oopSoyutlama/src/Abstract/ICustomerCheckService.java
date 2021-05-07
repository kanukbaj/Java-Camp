package Abstract;

import  Entitities.Customer;

public interface ICustomerCheckService {
	
	//Bu interface altýnda kimlik dogrulamasý icin gerekli metodlar gruplanacak kimlik dogrulamasý yapan classlar bu interface'i 
		//implemente edecekler.
	
	boolean checkIfRealPerson(Customer customer);

}
