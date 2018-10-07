package service.customer.impl;

import org.apache.log4j.Logger;
import pojo.game.Game;
import repository.dao.customer.impl.BasketDaoImpl;
import repository.dao.customer.interfaces.BasketDao;
import repository.dao.game.impl.GameDaoImpl;
import service.customer.interfaces.BasketService;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        Integer[] ids = new Integer[cookies.length];
//        String rawCookies = Arrays.toString(cookies);
//        Pattern p = Pattern.compile("g_uid(\\d+)=");
//        Matcher m = p.matcher(rawCookies);
//        System.out.println(rawCookies);
        try {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().indexOf("g_uid") == 0) {
                    ids[i] = Integer.valueOf(cookies[i].getName().substring(5));
                }
            }
        } catch (NumberFormatException nfe) {
            LOGGER.error("Passed not integer", nfe);
            return Collections.emptyList();
        }
        return basketDao.getByGamesByIds(ids);
    }

    @Override
    public boolean checkout(String[] ids) {
        return false;
    }
}
