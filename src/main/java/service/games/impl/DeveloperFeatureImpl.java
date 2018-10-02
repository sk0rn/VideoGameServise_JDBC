package service.games.impl;

import pojo.game.Developer;
import repository.dao.game.impl.DeveloperDaoImpl;
import repository.dao.game.interfaces.DeveloperDao;
import service.games.interfaces.GameFeatureService;

import java.util.List;

public class DeveloperFeatureImpl implements GameFeatureService {

    DeveloperDao devDao;

    public DeveloperFeatureImpl() {
        devDao = new DeveloperDaoImpl();
    }

    public DeveloperFeatureImpl(DeveloperDao devDao) {
        this.devDao = devDao;
    }

    @Override
    public List<Developer> getAllFeatures() {
        return devDao.getAll();
    }

    @Override
    public boolean addFeature(String feature) {
        if (feature != null) {
            return devDao.add(new Developer(null, feature));
        }
        return false;
    }
}
