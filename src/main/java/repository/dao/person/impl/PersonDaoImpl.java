package repository.dao.person.impl;

import org.apache.log4j.Logger;
import pojo.person.Person;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.person.interfaces.RoleDao;
import repository.dao.person.interfaces.PersonDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDaoImpl implements PersonDao {

    private static final Logger LOGGER = Logger.getLogger(PersonDaoImpl.class);
    private ConnectionManager connectionManager = ConnectionManagerMobileDB.getInstance();
    private RoleDao roleDao = new RoleDaoImpl();

    @Override
    public Person getPersonByLogin(String login) throws SQLException {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM persons WHERE login = ?")) {
            preparedStatement.setString(1, login);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Person person = new Person();
                    person.setId(resultSet.getInt(1));
                    person.setName(resultSet.getString(2));
                    person.setAddress(resultSet.getString(3));
                    person.setDateBirth(resultSet.getDate(4));
                    person.setRole(roleDao.getById(resultSet.getInt(5)));
                    person.setLogin(resultSet.getString(6));
                    person.setPassword(resultSet.getString(7));
                    person.setBonusPoints(resultSet.getInt(8));
                    return person;

                }
            } catch (Exception e) {
                LOGGER.error(e);
            }
        }
        return null;
    }

    @Override
    public boolean createPerson(Person person) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO persons (id, role_id, login, password) values " +
                             "(DEFAULT, ?, ?, ?) RETURNING id ")) {

            preparedStatement.setInt(1, person.getRole().getId());
            preparedStatement.setString(2, person.getLogin());
            preparedStatement.setString(3, person.getPassword());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    System.out.println("The new object Person in DB was assigned the id: "
                            + id);
                }
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

}

