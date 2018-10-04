package controller.content;

import constants.SQLRequests;
import constants.WEBConstants;
import org.apache.log4j.Logger;
import pojo.game.Game;
import repository.dao.game.impl.GameDaoImpl;
import service.games.impl.*;
import service.games.interfaces.GameFeatureService;
import service.games.interfaces.GameService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddGameServlet extends HttpServlet {

    private GameFeatureService titleService;
    private GameFeatureService genreService;
    private GameFeatureService devService;
    private GameFeatureService pubService;
    private GameFeatureService platformService;
    private GameService gameService;
    private static final Logger LOGGER = Logger.getLogger(AddGameServlet.class);

    @Override
    public void init() throws ServletException {
        super.init();
        gameService = new GameServiceImpl();
        titleService = new TitleFeatureImpl();
        genreService = new GenreFeatureImpl();
        devService = new DeveloperFeatureImpl();
        pubService = new PublisherFeatureImpl();
        platformService = new PlatformFeatureImpl();
        genreService = new GenreFeatureImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("titles", titleService.getAllFeatures());
        req.setAttribute("genres", genreService.getAllFeatures());
        req.setAttribute("developers", devService.getAllFeatures());
        req.setAttribute("publishers", pubService.getAllFeatures());
        req.setAttribute("platforms", platformService.getAllFeatures());

        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Add game");
        req.getRequestDispatcher("/add_content/add_game.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("new game id",
                    gameService.addGame(Integer.parseInt(req.getParameter("title")),
                            Integer.parseInt(req.getParameter("quantity")),
                            Integer.parseInt(req.getParameter("genre")),
                            Integer.parseInt(req.getParameter("developer")),
                            Integer.parseInt(req.getParameter("publisher")),
                            Integer.parseInt(req.getParameter("year")),
                            Integer.parseInt(req.getParameter("platform")),
                            Integer.parseInt(req.getParameter("price")))
            );
        } catch (NumberFormatException e) {
            LOGGER.error(e);
        }
        List<Game> games = gameService.getAllGames(SQLRequests.SELECT_GAMES_ALL);
        req.setAttribute(WEBConstants.ATTRIBUTE_GAMES, games);
        req.getRequestDispatcher("/game_content/games.jsp").forward(req, resp);



    }
}
