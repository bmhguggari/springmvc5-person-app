/**
 * 
 */
package org.hanamant.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hanamant.person.model.Person;
import org.hanamant.person.persistence.PersonPersistenceService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hguggari
 *
 */
public class PersonServiceImpl implements PersonService {
	private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);
	
	static Map<Integer, Person> personMap = new HashMap<Integer, Person>();
	
	@Autowired
	PersonPersistenceService persistenceService;
	/**
	 * 
	 */
	public PersonServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.service.PersonService#createPerson(org.hanamant.person.model.Person)
	 */
	public String createPerson(Person person) throws Exception {
		logger.info("Create Person Service has been called");
		persistenceService.createPerson(person);
		System.out.println("Person with id " + person.getId() + " has been added");
		return "";
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.service.PersonService#deletePerson(java.lang.Integer)
	 */
	public String deletePerson(Integer personId) throws Exception {
		logger.info("Delete Person Service has been called");
		persistenceService.deletePerson(personId);
		return "success";
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.service.PersonService#updatePerson(org.hanamant.person.model.Person)
	 */
	public String updatePerson(Person person) throws Exception {
		logger.info("Update Person Service has been called");
		persistenceService.updatePerson(person);
		return "success";
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.service.PersonService#getPerson(java.lang.Integer)
	 */
	public Person searchPerson(Integer personId) throws Exception {
		logger.info("Search Person Service has been called");	
		return persistenceService.searchPerson(personId);
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.service.PersonService#getAllPerson()
	 */
	public List<Person> getAllPerson() throws Exception {
		logger.info("Get All Person Service has been called");
		return persistenceService.getAllPerson();
	}

}
