package service.games.impl;

import pojo.game.Game;
import repository.dao.game.impl.GameDaoImpl;
import repository.dao.game.interfaces.GameDao;
import service.games.interfaces.GameService;

import java.util.List;

public class GameServiceImpl implements GameService {

    private GameDao gameDao;

    public GameServiceImpl() {
        gameDao = new GameDaoImpl();
    }

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public List<Game> getAllByFeature(String query, Integer featureId) {
        return gameDao.getAllByFeature(query, featureId);
    }

    @Override
    public List<Game> getAllGames(String query) {
        return gameDao.getAll(query);
    }

}