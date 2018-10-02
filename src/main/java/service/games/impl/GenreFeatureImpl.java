package service.games.impl;

import pojo.game.Genre;
import repository.dao.game.impl.GenreDaoImpl;
import repository.dao.game.interfaces.GenreDao;
import service.games.interfaces.GameFeatureService;

import java.util.List;

public class GenreFeatureImpl implements GameFeatureService {

    private GenreDao genreDao;

    public GenreFeatureImpl() {
        genreDao = new GenreDaoImpl();
    }

    public GenreFeatureImpl(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAllFeatures() {
        return genreDao.getAll();
    }

    @Override
    public boolean addFeature(String feature) {
        if (feature != null) {
            return genreDao.add(new Genre(null, feature));
        }
        return false;
    }
}
