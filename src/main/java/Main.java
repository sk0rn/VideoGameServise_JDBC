import net.spy.memcached.util.StringUtils;
import pojo.game.Game;
import repository.dao.customer.impl.BasketDaoImpl;
import service.customer.impl.BasketServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {


        String[] cookies = {"g_uid21=Until Dawn", "g_uid3=4Bla bla",
                "g_uid39=Doom3", "g_uid51=Unreal6"};
        Integer[] ids = new Integer[cookies.length];

        Arrays.toString(cookies);
        String rawCookies = Arrays.toString(cookies);
        Pattern p = Pattern.compile("g_uid(\\d+)=");
        Matcher m = p.matcher(rawCookies);
        for (int i = 0; m.find(); i++) {
            ids[i] = Integer.valueOf(m.group(1));
        }
        System.out.println(Arrays.toString(ids));




    }
}
