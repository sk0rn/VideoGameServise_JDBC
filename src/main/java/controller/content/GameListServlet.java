package controller.content;

import constants.SQLRequests;
import constants.WEBConstants;
import pojo.game.Game;
import service.games.impl.GameServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GameListServlet extends HttpServlet {

    private GameServiceImpl gameService;

    @Override
    public void init() throws ServletException {
        super.init();
        gameService = new GameServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Game> games = gameService.getAllGames(SQLRequests.SELECT_GAMES_ALL);
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "All Games");
        req.setAttribute(WEBConstants.ATTRIBUTE_GAMES, games);
        req.getRequestDispatcher(WEBConstants.JSP_GAMES).forward(req, resp);
    }
}
