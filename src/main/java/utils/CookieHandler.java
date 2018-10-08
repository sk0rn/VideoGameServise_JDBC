package utils;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;

public class CookieHandler {
    private static final Logger LOGGER = Logger.getLogger(CookieHandler.class);

    private CookieHandler(){ }

    public static Integer[] handleForGameIds(Cookie[] cookies) {
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
