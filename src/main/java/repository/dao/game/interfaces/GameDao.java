package repository.dao.game.interfaces;

import pojo.game.Game;

import java.util.List;

public interface GameDao {

    boolean add(Game game);

    Game getById(Integer id);

    boolean updateById(Game game);

    boolean deleteById(Integer id);

    List<Game> getAll(String query);

    List<Game> getAllByFeature(String query, Integer featureId);

}
