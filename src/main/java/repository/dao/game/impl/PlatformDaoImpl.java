package repository.dao.game.impl;

import pojo.game.Developer;
import pojo.game.Platform;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.game.interfaces.PlatformDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatformDaoImpl implements PlatformDao {


    private static ConnectionManager connectionManager =
            ConnectionManagerMobileDB.getInstance();


    @Override
    public boolean add(Platform platform) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO platforms values (DEFAULT, ?) RETURNING id ")) {

            preparedStatement.setString(1, platform.getName());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    System.out.println("The new object Platform in DB was assigned the id: "
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
    public Platform getById(Integer id) {
        try(Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM platforms WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Platform(
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
