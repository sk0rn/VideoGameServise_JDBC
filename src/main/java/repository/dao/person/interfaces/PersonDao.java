package repository.dao.person.interfaces;

import pojo.person.Person;

import java.sql.SQLException;

public interface PersonDao {

    Person getPersonByLogin(String login) throws SQLException;

    boolean createPerson(Person person);
}
