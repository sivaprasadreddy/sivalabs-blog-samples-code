/**
 * 
 */
package com.sivalabs.addressbook.repositories;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sivalabs.addressbook.model.Contact;

/**
 * @author siva
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ContactRepositoryTest {

	@Autowired
	private ContactRepository contactRepository;
	
	@BeforeClass
	public static void init()
	{
		System.out.println("111");
	}
	
	@Test
	public void findAllContacts() {
		//System.out.println(11111111);
		//System.out.println("-->"+contactRepository.findAll());
		List<Contact> list = contactRepository.findByFirstnameOrLastname("s%", "%");
		for (Contact contact : list) {
			System.err.println(contact);
		}
		//Assert.fail();
	}
	
	public static void main(String[] args) {
		System.out.println(11);
	}
}
