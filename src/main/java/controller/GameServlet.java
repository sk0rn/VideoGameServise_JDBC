package controller;

import constants.SQLRequests;
import pojo.game.Game;
import service.games.impl.GameServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GameServlet extends HttpServlet {
    private GameServiceImpl gameService;

    @Override
    public void init() throws ServletException {
        super.init();
        gameService = new GameServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Game> games = null;
                switch(req.getParameter("type")){
                    case"devs":
                        games =  gameService.getAllByFeature(SQLRequests.SELECT_GAMES_BY_DEVS,
                                Integer.parseInt(req.getParameter("id")));
                        break;
                    default:
                    case"genres":
                        games =  gameService.getAllByFeature(SQLRequests.SELECT_GAMES_BY_GENRES,
                                Integer.parseInt(req.getParameter("id")));
                        break;
                }
        req.setAttribute("title", "Games");
        req.setAttribute("games", games);
        req.getRequestDispatcher("/games.jsp").forward(req, resp);
    }

}