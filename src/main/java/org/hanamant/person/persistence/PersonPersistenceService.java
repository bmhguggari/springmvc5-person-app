/**
 * 
 */
package org.hanamant.person.persistence;

import java.sql.SQLException;
import java.util.List;

import org.hanamant.person.model.Person;
import org.springframework.stereotype.Repository;

/**
 * @author hguggari
 *
 */
@Repository
public interface PersonPersistenceService {
	
	public String createPerson(Person person) throws SQLException;
	
	public String deletePerson(Integer id) throws SQLException;
	
	public String updatePerson(Person person) throws SQLException;
	
	public Person searchPerson(Integer personId) throws SQLException;
	
	public List<Person> getAllPerson() throws SQLException;

}
