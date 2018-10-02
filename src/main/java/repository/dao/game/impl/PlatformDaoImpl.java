package repository.dao.game.impl;

import org.apache.log4j.Logger;
import pojo.game.Platform;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.game.interfaces.PlatformDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlatformDaoImpl implements PlatformDao {


    private static final Logger LOGGER = Logger.getLogger(PlatformDaoImpl.class);
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
            LOGGER.error(e);
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
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public List<Platform> getAll() {
        List<Platform> platforms = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {

            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM platforms")) {
                platforms = new ArrayList<>();
                while (resultSet.next()) {
                    platforms.add(new Platform(
                            resultSet.getInt(1),
                            resultSet.getString(2)));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return platforms;
    }
}
