package constants;

public class SQLRequests {

    private SQLRequests() {
    }

    public static final String SELECT_GAMES_ALL = "SELECT game.id as game_id,\n" +
            "  title.id as title_id, title.name as title_name,\n" +
            "  game.quantity as quantity,\n" +
            "  genre.id as genre_id, genre.name as genre_name,\n" +
            "  dev.id as dev_id, dev.name as dev_name,\n" +
            "  pub.id as pub_id, pub.name as pub_name,\n" +
            "  game.release_year as year,\n" +
            "  platform.id as platform_id, platform.name as platform_name,\n" +
            "  game.price\n" +
            "FROM games as game\n" +
            "  JOIN titles title on game.title_id = title.id\n" +
            "  JOIN genres genre on game.genre_id = genre.id\n" +
            "  JOIN developers dev on game.developer_id = dev.id\n" +
            "  JOIN publishers pub on game.publisher_id = pub.id\n" +
            "  JOIN platforms platform on game.platform_id = platform.id";

    public static final String SELECT_GAMES_BY_GENRES = SELECT_GAMES_ALL + " WHERE genre_id=?";

    public static final String SELECT_GAMES_BY_DEVS = SELECT_GAMES_ALL +  " WHERE developer_id=?";

}
