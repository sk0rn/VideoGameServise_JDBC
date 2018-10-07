package service.customer.impl;

import org.apache.log4j.Logger;
import pojo.game.Game;
import repository.dao.customer.impl.BasketDaoImpl;
import repository.dao.customer.interfaces.BasketDao;
import repository.dao.game.impl.GameDaoImpl;
import service.customer.interfaces.BasketService;

import javax.servlet.http.Cookie;
import java.util.Collections;
import java.util.List;

public class BasketServiceImpl implements BasketService {
    private static final Logger LOGGER = Logger.getLogger(GameDaoImpl.class);
    BasketDao basketDao;

    public BasketServiceImpl() {
        basketDao = new BasketDaoImpl();
    }

    public BasketServiceImpl(BasketDao basketDao) {
        this.basketDao = basketDao;
    }

    @Override
    public List<Game> showAddedGames(Cookie[] cookies) {
        Integer[] ids = handleCookies(cookies);
        return (ids.length != 0) ? basketDao.getByGamesByIds(ids) : Collections.emptyList();
    }

    @Override
    public boolean checkout(Cookie[] cookies) {
        Integer[] ids = handleCookies(cookies);
        return (ids.length != 0) && basketDao.decreaseQuantity(ids);
    }

    private Integer[] handleCookies(Cookie[] cookies) {
        Integer[] ids = new Integer[cookies.length];
        try {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().indexOf("g_uid") == 0) {
                    ids[i] = Integer.valueOf(cookies[i].getName().substring(5));
                }
            }
        } catch (NumberFormatException nfe) {
            LOGGER.error(nfe);
            return new Integer[0];
        }
        return ids;
    }

}
