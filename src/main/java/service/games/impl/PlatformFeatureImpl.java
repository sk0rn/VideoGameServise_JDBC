package service.games.impl;

import pojo.game.Platform;
import repository.dao.game.impl.PlatformDaoImpl;
import repository.dao.game.interfaces.PlatformDao;
import service.games.interfaces.GameFeatureService;

import java.util.List;

public class PlatformFeatureImpl implements GameFeatureService {

    private PlatformDao platformDao;

    public PlatformFeatureImpl() {
        platformDao = new PlatformDaoImpl();
    }

    public PlatformFeatureImpl(PlatformDao platformDao) {
        this.platformDao = platformDao;
    }

    @Override
    public List<Platform> getAllFeatures() {
        return platformDao.getAll();
    }

    @Override
    public boolean addFeature(String feature) {
        if (feature != null) {
            return platformDao.add(new Platform(null, feature));
        }
        return false;
    }
}
