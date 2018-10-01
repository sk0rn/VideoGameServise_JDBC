package service.imp;

import pojo.game.Game;
import repository.dao.game.impl.GameDaoImp;
import repository.dao.game.interfaces.GameDao;
import service.interfaces.GameService;

import java.util.List;

public class GameServiceImpl implements GameService {

    private GameDao gameDao;

    public GameServiceImpl() {
        gameDao = new GameDaoImp();
    }

    public GameServiceImpl(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    @Override
    public List<Game> getAllByGenre(Integer genreId) {
        return gameDao.getAllByGenre(genreId);
    }

    @Override
    public List<Game> getAllGames() {
        return gameDao.getAll();
    }

}
