package Abstract;

import  Entitities.Customer;

public interface ICustomerCheckService {
	
	//Bu interface alt�nda kimlik dogrulamas� icin gerekli metodlar gruplanacak kimlik dogrulamas� yapan classlar bu interface'i 
		//implemente edecekler.
	
	boolean checkIfRealPerson(Customer customer);

}
