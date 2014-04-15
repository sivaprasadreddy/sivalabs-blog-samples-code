/**
 * 
 */
package sivalabs.app.core.services;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sivalabs.app.core.config.AppConfig;
import sivalabs.app.core.entities.Person;
import sivalabs.app.core.services.PersonService;

/**
 * @author Siva
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=[AppConfig.class])
public class PersonServiceTest extends GroovyTestCase
{
	@Autowired
	PersonService personService;
	
	@Test
	public void findAll() {
		List<Person> persons = personService.findAll();
		assertNotNull(persons);
	}
	
	@Test
	public void findById()
	{
		Person person = personService.findById(1);
		//assertNotNull(person);
	}
	
	@Test
	public void testCreate()
	{
		Person person1 = new Person(name:'siva', userName:'siva', password:'siva', email:'siva@gmail.com');
		Person person2 = new Person(name:'prasad', userName:'prasad', password:'prasad', email:'prasad@gmail.com');
		person1 = personService.create(person1);
		println person1.id
		
		person2 = personService.create(person2);
		println person2.id
		
	}
}
