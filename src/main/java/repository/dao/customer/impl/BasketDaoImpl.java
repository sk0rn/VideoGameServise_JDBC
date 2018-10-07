package repository.dao.customer.impl;

import org.apache.log4j.Logger;
import pojo.game.*;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.customer.interfaces.BasketDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static constants.SQLConstants.*;
import static constants.SQLRequests.SELECT_GAME_BY_IDS;

public class BasketDaoImpl implements BasketDao {
    private static final Logger LOGGER = Logger.getLogger(BasketDaoImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerMobileDB.getInstance();


    @Override
    public List<Game> getByGamesByIds(Integer[] ids) {
        List<Game> games = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery(SELECT_GAME_BY_IDS +
                    "(" + Arrays.toString(ids).
                    replaceAll("[\\[\\]]", "") + ")")) {
                games = new ArrayList<>();
                while (resultSet.next()) {
                    games.add(new Game(
                            resultSet.getInt(GAME_ID),
                            new Title(resultSet.getInt(TITLE_ID),
                                    resultSet.getString(TITLE_NAME)),
                            resultSet.getInt(QUANTITY),
                            new Genre(resultSet.getInt(GENRE_ID),
                                    resultSet.getString(GENRE_NAME)),
                            new Developer(resultSet.getInt(DEV_ID),
                                    resultSet.getString(DEV_NAME)),
                            new Publisher(resultSet.getInt(PUB_ID),
                                    resultSet.getString(PUB_NAME)),
                            resultSet.getInt(YEAR),
                            new Platform(resultSet.getInt(PLATFORM_ID),
                                    resultSet.getString(PLATFORM_NAME)),
                            resultSet.getInt(PRICE)));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return games;
    }

    @Override
    public boolean decreaseQuantity(Integer[] ids) {
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {
            try(ResultSet resultSet = statement.executeQuery("UPDATE games\n" +
                    "SET quantity = quantity - 1\n" +
                    "WHERE id in (" + Arrays.toString(ids).
                    replaceAll("[\\[\\]]", "") + ") AND NOT EXISTS(\n" +
                    "SELECT * FROM games\n" +
                    "WHERE id in (" + Arrays.toString(ids).
                    replaceAll("[\\[\\]]", "") + ") AND quantity < 1)\n" +
                    "RETURNING id")) {
                // если при уменьшении количества какой-либо из игр, оно будет меньше одного,
                // то уменьшнение не произойдет ни для одной игры. Метод вернет false, для того
                // что бы выше сообщить клиенту что с заказом возникла проблема
                return resultSet.next();
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }
}
