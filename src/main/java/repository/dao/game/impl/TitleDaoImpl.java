package repository.dao.game.impl;

import org.apache.log4j.Logger;
import pojo.game.Title;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.game.interfaces.TitleDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitleDaoImpl implements TitleDao {

    private static final Logger LOGGER = Logger.getLogger(TitleDaoImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerMobileDB.getInstance();

    @Override
    public boolean add(Title title) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO titles values (DEFAULT, ?) RETURNING id ")) {

            preparedStatement.setString(1, title.getName());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    System.out.println("The new object Title in DB was assigned the id: "
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
    public Title getById(Integer id) {
        try(Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM titles WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Title(
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
    public List<Title> getAll() {
        List<Title> titles = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {

            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM titles")) {
                titles = new ArrayList<>();
                while (resultSet.next()) {
                    titles.add(new Title(
                            resultSet.getInt(1),
                            resultSet.getString(2)));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return titles;
    }
}
