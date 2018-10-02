package repository.dao.game.impl;

import org.apache.log4j.Logger;
import pojo.game.Developer;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.game.interfaces.DeveloperDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeveloperDaoImpl implements DeveloperDao {

    private static final Logger LOGGER = Logger.getLogger(DeveloperDaoImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerMobileDB.getInstance();

    @Override
    public boolean add(Developer dev) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO developers values (DEFAULT, ?) RETURNING id ")) {

            preparedStatement.setString(1, dev.getName());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    System.out.println("The new object Developer in DB was assigned the id: "
                            + id);
                }
                return true;
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public Developer getById(Integer id) {
        try(Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM developers WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Developer(
                            resultSet.getInt(1),
                            resultSet.getString(2));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developers = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {

            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM developers")) {
                developers = new ArrayList<>();
                while (resultSet.next()) {
                    developers.add(new Developer(
                            resultSet.getInt(1),
                            resultSet.getString(2)));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return developers;
    }
}
