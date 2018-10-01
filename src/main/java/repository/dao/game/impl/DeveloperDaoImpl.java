package repository.dao.game.impl;

import pojo.game.Developer;
import pojo.game.Genre;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.game.interfaces.DeveloperDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperDaoImpl implements DeveloperDao {

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
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return null;
    }
}
