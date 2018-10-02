package service.games.impl;

import pojo.game.Publisher;
import repository.dao.game.impl.PublisherDaoImpl;
import repository.dao.game.interfaces.PublisherDao;
import service.games.interfaces.GameFeatureService;

import java.util.List;

public class PublisherFeatureImpl implements GameFeatureService {

    PublisherDao pubDao;

    public PublisherFeatureImpl() {
        pubDao = new PublisherDaoImpl();
    }

    public PublisherFeatureImpl(PublisherDao pubDao) {
        this.pubDao = pubDao;
    }

    @Override
    public List<Publisher> getAllFeatures() {
        return pubDao.getAll();
    }

    @Override
    public boolean addFeature(String feature) {
        if (feature != null) {
            return pubDao.add(new Publisher(null, feature));
        }
        return false;
    }
}
