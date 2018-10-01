package service;

import pojo.game.Genre;
import repository.dao.game.impl.GenreDaoImpl;
import repository.dao.game.interfaces.GenreDao;

import java.util.List;

public class GenreService {

    private GenreDao genreDao;

    public GenreService() {
        genreDao = new GenreDaoImpl();
    }

    public GenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    public List<Genre> getAllGenres() {
        return genreDao.getAll();
    }
}
