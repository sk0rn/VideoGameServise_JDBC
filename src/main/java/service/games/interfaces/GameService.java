package service.games.interfaces;

import pojo.game.*;

import java.util.List;

public interface GameService {

    List<Game> getAllByFeature(String query, Integer featureId);

    List<Game> getAllGames(String query);

    int addGame(Game game);

    int addGame(int titleId, int quantity, int genreId, int devId,
                int pubId, int year, int platformId, int price);
}
