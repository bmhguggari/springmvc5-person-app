/**
 * 
 */
package org.hanamant.person.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hanamant.person.AppConstants;
import org.hanamant.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hguggari
 *
 */
public class PersonPersistenceServiceImpl implements PersonPersistenceService {
	private static final Logger logger = Logger.getLogger(PersonPersistenceServiceImpl.class);

	private static final String SELECT_PERSON_QUERY = "select id, name, address, mobile, email from person where id = ?";
	private static final String SELECT_ALL_PERSON = "select id, name, address, mobile, email from person";
	private static final String INSERT_PERSON = "insert into person(id, name, address, mobile, email) values(person_id_seq.nextval, ?, ?, ?, ?)";
	private static final String DELETE_PERSON = "delete from person where id = ?";
	private static final String UPDATE_PERSON = "update person set name = ?, address = ?, mobile = ?, email = ? where id = ?";
	
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		if(dataSource != null) {
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
		}
		return connection;
	}
	
	private void releaseConnection(Connection connection)  {
			try { if(connection != null) { connection.close(); } }catch (SQLException e) { }
	}
	
	private void commit(Connection connection) {
		try {
			connection.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void rollBack(Connection connection) {
		try {
			connection.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	DataSource dataSource;
	/**
	 * 
	 */
	public PersonPersistenceServiceImpl() {
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.persistence.PersonPersistenceService#createPerson(org.hanamant.person.model.Person)
	 */
	public String createPerson(Person person) throws SQLException {
		logger.info("Create Person DAO has been called");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection  = getConnection();
			
			preparedStatement = connection.prepareStatement(INSERT_PERSON);
			
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getAddress());
			preparedStatement.setString(3, person.getMobile());
			preparedStatement.setString(4, person.getEmail());
			
			preparedStatement.executeUpdate();
			
		} catch(Exception ex) {
			rollBack(connection);
			throw new SQLException(ex);
		} finally {
			commit(connection);
			try { if(preparedStatement != null) preparedStatement.close(); } catch(Exception ex) {}
			releaseConnection(connection);
		}
		return AppConstants.SUCESS;
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.persistence.PersonPersistenceService#deletePerson(java.lang.Integer)
	 */
	public String deletePerson(Integer id) throws SQLException {
		logger.info("Delete Person DAO has been called");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(DELETE_PERSON);
			preparedStatement.setInt(1, id);
			preparedStatement.executeQuery();
		} catch(Exception ex) {
			rollBack(connection);
			throw new SQLException(ex);
		} finally {
			commit(connection);
			try { if(preparedStatement != null) preparedStatement.close(); } catch(Exception ex) {}
			releaseConnection(connection);
		}
		return AppConstants.SUCESS;
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.persistence.PersonPersistenceService#updatePerson(org.hanamant.person.model.Person)
	 */
	public String updatePerson(Person person) throws SQLException {
		logger.info("Update Person DAO has been called");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection  = getConnection();
			
			preparedStatement = connection.prepareStatement(UPDATE_PERSON);
			
			preparedStatement.setString(1, person.getName());
			preparedStatement.setString(2, person.getAddress());
			preparedStatement.setString(3, person.getMobile());
			preparedStatement.setString(4, person.getEmail());
			preparedStatement.setInt(5, person.getId());
			
			preparedStatement.executeUpdate();
			
		} catch(Exception ex) {
			rollBack(connection);
			throw new SQLException(ex);
		} finally {
			commit(connection);
			try { if(preparedStatement != null) preparedStatement.close(); } catch(Exception ex) {}
			releaseConnection(connection);
		}
		return AppConstants.SUCESS;
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.persistence.PersonPersistenceService#searchPerson(java.lang.Integer)
	 */
	public Person searchPerson(Integer personId) throws SQLException {
		logger.info("Search Person DAO has been called");
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Person person = null;
		try {
			connection  = getConnection();
			
			preparedStatement = connection.prepareStatement(SELECT_PERSON_QUERY);
			
			preparedStatement.setInt(1, personId);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				person = populatePerson(resultSet);
			}
			
		} catch(Exception ex) {
			rollBack(connection);
			throw new SQLException(ex);
		} finally {
			commit(connection);
			try { if(preparedStatement != null) preparedStatement.close(); } catch(Exception ex) {}
			releaseConnection(connection);
		}
		return person;
	}

	private Person populatePerson(ResultSet resultSet) throws SQLException {
		Person person = new Person();
		person.setId(resultSet.getInt(1));
		person.setName(resultSet.getString(2));
		person.setAddress(resultSet.getString(3));
		person.setMobile(resultSet.getString(4));
		person.setEmail(resultSet.getString(5));
		
		return person;
	}

	/* (non-Javadoc)
	 * @see org.hanamant.person.persistence.PersonPersistenceService#getAllPerson()
	 */
	public List<Person> getAllPerson() throws SQLException {
		logger.info("Get all Person DAO has been called");
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Person> list = null;
		try {
			connection  = getConnection();
			
			statement = connection.createStatement();
			
			resultSet = statement.executeQuery(SELECT_ALL_PERSON);
				
			list = populateAllPerson(resultSet);
			
		} catch(Exception ex) {
			rollBack(connection);
			throw new SQLException(ex);
		} finally {
			commit(connection);
			try { if(statement != null) statement.close(); } catch(Exception ex) {}
			releaseConnection(connection);
		}
		return list;
	}

	private List<Person> populateAllPerson(ResultSet resultSet) throws SQLException {
		List<Person> list = new ArrayList<Person>();
		while(resultSet.next()) {
			list.add(populatePerson(resultSet));
		}
		return list;
	}

}
