package controller;

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
        List<Game> games;
                switch(req.getParameter("type")){
                    case"devs":
                        games =  gameService.getAllByFeature(SQLRequests.SELECT_GAMES_BY_DEVS,
                                Integer.parseInt(req.getParameter(WEBConstants.PARAMETER_ID)));
                        break;
                    default:
                    case"genres":
                        games =  gameService.getAllByFeature(SQLRequests.SELECT_GAMES_BY_GENRES,
                                Integer.parseInt(req.getParameter(WEBConstants.PARAMETER_ID)));
                        break;
                }
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Games");
        req.setAttribute(WEBConstants.ATTRIBUTE_GAMES, games);
        req.getRequestDispatcher(WEBConstants.JSP_GAMES).forward(req, resp);
    }

}