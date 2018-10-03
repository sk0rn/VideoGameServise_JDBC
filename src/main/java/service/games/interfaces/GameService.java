package service.games.interfaces;

import pojo.game.Game;

import java.util.List;

public interface GameService {

    List<Game> getAllByFeature(String query, Integer featureId);

    List<Game> getAllGames(String query);
}
