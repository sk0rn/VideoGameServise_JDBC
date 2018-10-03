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
    public List<Game> getAllByGenre(Integer genreId) {
        return gameDao.getAllByGenre(genreId);
    }

    @Override
    public List<Game> getAllByDeveloper(Integer devId) {
        return gameDao.getAllByDeveloper(devId);
    }

    @Override
    public List<Game> getAllGames() {
        return gameDao.getAll();
    }

}
