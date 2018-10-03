package repository.dao.game.impl;

import org.apache.log4j.Logger;
import pojo.game.*;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.game.interfaces.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDaoImpl implements GameDao {

    private TitleDao titleDao = new TitleDaoImpl();
    private GenreDao genreDao = new GenreDaoImpl();
    private DeveloperDao devDao = new DeveloperDaoImpl();
    private PublisherDao pubDao = new PublisherDaoImpl();
    private PlatformDao platformDao = new PlatformDaoImpl();
    private static final Logger LOGGER = Logger.getLogger(GameDaoImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerMobileDB.getInstance();

    @Override
    public boolean add(Game game) {
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
                if (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    LOGGER.info("The new object Game in DB was assigned the id: "
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
    public Game getById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM games WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Game(
                            resultSet.getInt(1),
                            titleDao.getById(resultSet.getInt(2)),
                            resultSet.getInt(3),
                            genreDao.getById(resultSet.getInt(4)),
                            devDao.getById(resultSet.getInt(5)),
                            pubDao.getById(resultSet.getInt(6)),
                            resultSet.getInt(7),
                            platformDao.getById(resultSet.getInt(8)),
                            resultSet.getInt(9));
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
                            resultSet.getInt("game_id"),
                            new Title(resultSet.getInt("title_id"),
                                    resultSet.getString("title_name")),
                            resultSet.getInt("quantity"),
                            new Genre(resultSet.getInt("genre_id"),
                                    resultSet.getString("genre_name")),
                            new Developer(resultSet.getInt("dev_id"),
                                    resultSet.getString("dev_name")),
                            new Publisher(resultSet.getInt("pub_id"),
                                    resultSet.getString("pub_name")),
                            resultSet.getInt("year"),
                            new Platform(resultSet.getInt("platform_id"),
                                    resultSet.getString("platform_name")),
                            resultSet.getInt("price")));
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
                            resultSet.getInt("game_id"),
                            new Title(resultSet.getInt("title_id"),
                                    resultSet.getString("title_name")),
                            resultSet.getInt("quantity"),
                            new Genre(resultSet.getInt("genre_id"),
                                    resultSet.getString("genre_name")),
                            new Developer(resultSet.getInt("dev_id"),
                                    resultSet.getString("dev_name")),
                            new Publisher(resultSet.getInt("pub_id"),
                                    resultSet.getString("pub_name")),
                            resultSet.getInt("year"),
                            new Platform(resultSet.getInt("platform_id"),
                                    resultSet.getString("platform_name")),
                            resultSet.getInt("price")));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return games;
    }
}
