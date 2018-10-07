package repository.dao.customer.interfaces;

import pojo.game.Game;

import java.util.List;

public interface BasketDao {

    List<Game> getByGamesByIds(Integer[] ids);

    boolean updateQuantity(Integer[] ids);


}
