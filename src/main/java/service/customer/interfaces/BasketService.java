package service.customer.interfaces;

import pojo.game.Game;

import javax.servlet.http.Cookie;
import java.util.List;

public interface BasketService {

    List<Game> showAddedGames(Cookie[] cookies);

    boolean checkout(Cookie[] cookies);
}
