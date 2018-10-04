package repository.dao.game.interfaces;

import pojo.game.Game;

import java.util.List;

public interface GameDao {

    int add(Game game);

    int add(int titleId, int quantity, int genreId, int devId,
                int pubId, int year, int platformId, int price);

    Game getById(Integer id);

    boolean updateById(Game game);

    boolean deleteById(Integer id);

    List<Game> getAll(String query);

    List<Game> getAllByFeature(String query, Integer featureId);

}
