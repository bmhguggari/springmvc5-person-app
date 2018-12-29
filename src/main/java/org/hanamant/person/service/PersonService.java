/**
 * 
 */
package org.hanamant.person.service;

import java.util.List;

import org.hanamant.person.model.Person;
import org.springframework.stereotype.Service;

/**
 * @author hguggari
 *
 */
@Service
public interface PersonService {
	
	public String createPerson(Person person) throws Exception;
	
	public String deletePerson(Integer personId) throws Exception;
	
	public String updatePerson(Person person) throws Exception;
	
	public Person searchPerson(Integer personId) throws Exception;
	
	public List<Person> getAllPerson() throws Exception;
	
}
