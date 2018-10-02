package repository.dao.person.interfaces;

import pojo.person.Person;

import java.sql.SQLException;

public interface UserDao {
     Person getUserByLogin(String login) throws SQLException;
}
