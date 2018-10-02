package service.games.interfaces;

import java.util.List;

public interface GameFeatureService<F> {

    List<F> getAllFeatures();

    boolean addFeature(String feature);
}
