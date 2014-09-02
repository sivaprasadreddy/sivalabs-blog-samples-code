/**
*
*
*/
package com.sivalabs.mockdb.sample;

import com.sivalabs.mockdb.sample.Person.PersonBuilder;

public class MockDB {

	private static final PersonTable PERSON_TABLE = new PersonTable();
	
	public MockDB() {
		Person admin = Person.PersonBuilder.create()/*.id(1)*/.email("admin@gmail.com").password("admin")
				.firstName("Admin").build();
		Person siva = PersonBuilder.create()/*.id(2)*/.email("siva@gmail.com").password("siva")
				.firstName("Siva").lastName("prasad").build();
		
		PERSON_TABLE.create(admin);
		PERSON_TABLE.create(siva);
		
	}
	
	public static PersonTable getPersonTable() {
		return PERSON_TABLE;
	}
}
