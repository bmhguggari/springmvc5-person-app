/**
 * 
 */
package org.hanamant.person.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hanamant.person.model.Person;
import org.hanamant.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hguggari
 *
 */
@Controller
public class PersonController {
	private static final Logger logger = Logger.getLogger(PersonController.class);
	
	@Autowired
	public PersonService personService;
	/**
	 * 
	 */
	public PersonController() {
	}

	@RequestMapping(path="/", method=RequestMethod.GET)
	public String getHome() {
		logger.info("Home page has been requested by client");
		return "index";
	}
	
	@RequestMapping(path="/create-person", method=RequestMethod.GET)
	public String getPersonForm(Model m) {
		logger.info("Create person form get Request");
		m.addAttribute("command", new Person());
		return "create-person";
	}
	
	@RequestMapping(path="/create-person", method=RequestMethod.POST)
	public String createPerson(@ModelAttribute("person")Person person,Model m) {
		logger.info("Create Person POST method");
		try {
			personService.createPerson(person);
			m.addAttribute("successMessage" , "Person details has been created!!!");
		} catch(Exception ex) {
			m.addAttribute("errorMessage" , ex.getMessage());
			return "failure";
		}
		return "index";
	}
	
	@RequestMapping(path="/delete-person", method=RequestMethod.GET)
	public String getDeleteForm(Model m) {
		logger.info("Delete person form GET method");
		return "delete-person";
	}
	
	@RequestMapping(path="/delete-person", method=RequestMethod.POST)
	public String deletePerson(@RequestParam("id")String id, Model m) {
		logger.info("Delete person POST method");
		try {
			String status = personService.deletePerson(Integer.parseInt(id));
			if(!"success".equalsIgnoreCase(status)) {
				throw new Exception("Could not find person");
			} else {
				m.addAttribute("successMessage" , "Person details has been deleted!!!");
			}
		} catch(Exception ex) {
			m.addAttribute("errorMessage" , ex.getMessage());
			return "failure";
		}
		return "index";
	}
	
	@RequestMapping(path="update-person", method=RequestMethod.GET)
	public String updateForm(@RequestParam("id")String id, Model m) {
		logger.info("Update Person GET method");
		try {
			Person person = personService.searchPerson(Integer.parseInt(id));
			m.addAttribute("command", person);
		} catch (Exception ex) {
			m.addAttribute("errorMessage" , ex.getMessage());
			return "failure";
		}
		return "update-person";
	}
	
	@RequestMapping(path="update-person", method=RequestMethod.POST)
	public String updatePerson(@ModelAttribute("person")Person person, Model m) {
		logger.info("Update person POST method");
		try {
			personService.updatePerson(person);
			m.addAttribute("successMessage" , "Person details has been updated!!!");
		} catch (Exception ex) {
			m.addAttribute("errorMessage" , ex.getMessage());
			return "failure";
		}
		return "index";
	}
	
	@RequestMapping(path="/search-person", method=RequestMethod.GET)
	public String searchForm() {
		logger.info("Search person GET method");
		return "search-person";
	}
	
	@RequestMapping(path="/search-person", method=RequestMethod.POST)
	public String searchPerson(@RequestParam("id")String id, Model m) {
		logger.info("Search person POST method");
		try {
			Person person = personService.searchPerson(Integer.parseInt(id));
			if(person != null) {
				List<Person> list = new ArrayList<Person>();
				list.add(person);
				m.addAttribute("persons",list);
			}
		} catch(Exception ex) {
			m.addAttribute("errorMessage" , ex.getMessage());
			return "failure";
		}
		return "get-all-person";
	}
	
	@RequestMapping(path="/get-all-person", method=RequestMethod.GET)
	public String getAllPerson(Model m) {
		logger.info("Get all person GET method");
		try {
			List<Person> list = personService.getAllPerson();
			m.addAttribute("persons",list);
		} catch(Exception ex) {
			m.addAttribute("errorMessage" , ex.getMessage());
			return "failure";
		}
		return "get-all-person";
	}
}
