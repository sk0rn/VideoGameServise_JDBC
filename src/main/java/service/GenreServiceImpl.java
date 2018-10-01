package service;

import pojo.game.Genre;
import repository.dao.game.impl.GenreDaoImpl;
import repository.dao.game.interfaces.GenreDao;
import service.interfaces.GenreService;

import java.util.List;

public class GenreServiceImpl implements GenreService {

    private GenreDao genreDao;

    public GenreServiceImpl() {
        genreDao = new GenreDaoImpl();
    }

    public GenreServiceImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreDao.getAll();
    }
}
