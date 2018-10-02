package repository.dao.person;

import pojo.person.Person;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.person.impl.RoleDaoImpl;
import repository.dao.person.interfaces.RoleDao;
import repository.dao.person.interfaces.UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    ConnectionManager connectionManager = ConnectionManagerMobileDB.getInstance();
    private RoleDao roleDao  = new RoleDaoImpl();

    @Override
    public Person getUserByLogin(String login) throws SQLException {
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
                e.printStackTrace();
            }
        }
        return null;
    }

}

