package service.person.customer.impl;

import pojo.game.Game;
import repository.dao.customer.impl.BasketDaoImpl;
import repository.dao.customer.interfaces.BasketDao;
import service.person.customer.interfaces.BasketService;

import javax.servlet.http.Cookie;
import java.util.Collections;
import java.util.List;

import static utils.CookieHandler.handleForGameIds;

public class BasketServiceImpl implements BasketService {
    private BasketDao basketDao;

    public BasketServiceImpl() {
        basketDao = new BasketDaoImpl();
    }

    public BasketServiceImpl(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    @Override
    public List<Game> showAddedGames(Cookie[] cookies) {
        Integer[] ids = handleForGameIds(cookies);
        return (ids.length != 0) ? basketDao.getByGamesByIds(ids) : Collections.emptyList();
    }

    @Override
    public boolean checkout(Cookie[] cookies) {
        Integer[] ids = handleForGameIds(cookies);
        return (ids.length != 0) && basketDao.decreaseQuantity(ids);
    }


}
