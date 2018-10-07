package repository.dao.game.impl;

import constants.SQLConstants;
import constants.SQLRequests;
import org.apache.log4j.Logger;
import pojo.game.*;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.game.interfaces.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static constants.SQLConstants.*;

public class GameDaoImpl implements GameDao {
    private static final Logger LOGGER = Logger.getLogger(GameDaoImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerMobileDB.getInstance();

    @Override
    public int add(Game game) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO games values (DEFAULT, " +
                             "?, ?, ?, ?, ?, ?, ?, ?) RETURNING id ")) {

            preparedStatement.setInt(1, game.getTitle().getId());
            preparedStatement.setInt(2, game.getQuantity());
            preparedStatement.setInt(3, game.getGenre().getId());
            preparedStatement.setInt(4, game.getDev().getId());
            preparedStatement.setInt(5, game.getPub().getId());
            preparedStatement.setInt(6, game.getReleaseYear());
            preparedStatement.setInt(7, game.getPlatform().getId());
            preparedStatement.setInt(8, game.getPrice());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Integer id = -1;
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    LOGGER.info("The new object Game in DB was assigned the id: "
                            + id);
                }
                return id;
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return -1;
    }

    @Override
    public int add(int titleId, int quantity, int genreId, int devId,
                   int pubId, int year, int platformId, int price) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO games values (DEFAULT, " +
                             "?, ?, ?, ?, ?, ?, ?, ?) RETURNING id ")) {

            preparedStatement.setInt(1, titleId);
            preparedStatement.setInt(2, quantity);
            preparedStatement.setInt(3, genreId);
            preparedStatement.setInt(4, devId);
            preparedStatement.setInt(5, pubId);
            preparedStatement.setInt(6, year);
            preparedStatement.setInt(7, platformId);
            preparedStatement.setInt(8, price);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Integer id = -1;
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    LOGGER.info("The new object Game in DB was assigned the id: "
                            + id);
                }
                return id;
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return -1;
    }

    @Override
    public Game getById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     SQLRequests.SELECT_GAME_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Game(
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
                            resultSet.getInt(PRICE));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return null;
    }

    @Override
    public boolean updateById(Game game) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE games SET title_id=?, quantity=?, genre_id=?," +
                             "developer_id=?, publisher_id=?,release_year=?," +
                             "platform_id=?, price=? WHERE id=?")) {
            preparedStatement.setInt(1, game.getTitle().getId());
            preparedStatement.setInt(2, game.getQuantity());
            preparedStatement.setInt(3, game.getGenre().getId());
            preparedStatement.setInt(4, game.getDev().getId());
            preparedStatement.setInt(5, game.getPub().getId());
            preparedStatement.setInt(6, game.getReleaseYear());
            preparedStatement.setInt(7, game.getPlatform().getId());
            preparedStatement.setInt(8, game.getPrice());
            preparedStatement.setInt(9, game.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM games WHERE id=?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public List<Game> getAll(String query) {
        List<Game> games = null;
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {

            try (ResultSet resultSet = statement.executeQuery(query)) {
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
    public List<Game> getAllByFeature(String query, Integer featureId) {
        List<Game> games = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(query)) {
            preparedStatement.setInt(1, featureId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
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
}
