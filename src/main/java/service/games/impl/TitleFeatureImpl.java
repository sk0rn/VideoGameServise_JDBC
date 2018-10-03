package service.games.impl;

import pojo.game.Title;
import repository.dao.game.impl.TitleDaoImpl;
import repository.dao.game.interfaces.TitleDao;
import service.games.interfaces.GameFeatureService;

import java.util.List;

public class TitleFeatureImpl implements GameFeatureService {

    private TitleDao titleDao;

    public TitleFeatureImpl() {
        titleDao = new TitleDaoImpl();
    }

    public TitleFeatureImpl(TitleDao titleDao) {
        this.titleDao = titleDao;
    }

    @Override
    public List<Title> getAllFeatures() {
        return titleDao.getAll();
    }

    @Override
    public boolean addFeature(String feature) {
        if (feature != null) {
            return titleDao.add(new Title(null, feature));
        }
        return false;
    }
}
