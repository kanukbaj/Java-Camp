package Entitities;

import Abstract.IEntity;

public class Customer implements IEntity {
	//Bu class benim müsterilerime ait ozellikleri tutuyor ve baska paketlerin altýndan musterileme ait ozelliklere getterlar ile
	//erisebiliyorum.

	int Id;
	String firstName;
	String lastName;
	int detaOfBirth;
	Long nationalityId;
	
	
	public Customer(int id, String firstName, String lastName, int detaOfBirth, Long nationalityId) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.detaOfBirth = detaOfBirth;
		this.nationalityId = nationalityId;
	}


	public int getId() {
		return Id;
	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public int getDetaOfBirth() {
		return detaOfBirth;
	}

	public Long getNationalityId() {
		return nationalityId;
	}

}
