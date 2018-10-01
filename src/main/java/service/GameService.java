package service;

import pojo.game.Game;
import repository.dao.game.impl.GameDaoImp;
import repository.dao.game.interfaces.GameDao;

import java.util.List;

public class GameService {

    private GameDao gameDao;

    public GameService() {
        gameDao = new GameDaoImp();
    }

    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    public List<Game> getAllByGenre(Integer genreId) {
        return gameDao.getAllByGenre(genreId);
    }

    public List<Game> getAllGames() {
        return gameDao.getAll();
    }

}
