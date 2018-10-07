package controller.content;

import constants.WEBConstants;
import pojo.game.Game;
import service.games.impl.GameServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static constants.SQLRequests.*;
import static constants.WEBConstants.*;

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
                    case ATTRIBUTE_TITLES:
                        games =  gameService.getAllByFeature(SELECT_GAMES_BY_TITLES,
                                Integer.parseInt(req.getParameter(PARAMETER_ID)));
                        break;
                    case ATTRIBUTE_DEVS:
                        games =  gameService.getAllByFeature(SELECT_GAMES_BY_DEVS,
                                Integer.parseInt(req.getParameter(PARAMETER_ID)));
                        break;
                    case ATTRIBUTE_PUBS:
                        games =  gameService.getAllByFeature(SELECT_GAMES_BY_PUBS,
                                Integer.parseInt(req.getParameter(PARAMETER_ID)));
                        break;
                    case ATTRIBUTE_PLATFORMS:
                        games =  gameService.getAllByFeature(SELECT_GAMES_BY_PLATFORMS,
                                Integer.parseInt(req.getParameter(PARAMETER_ID)));
                        break;
                    default:
                    case ATTRIBUTE_GENRES:
                        games =  gameService.getAllByFeature(SELECT_GAMES_BY_GENRES,
                                Integer.parseInt(req.getParameter(PARAMETER_ID)));
                        break;
                }
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Games");
        req.setAttribute(WEBConstants.ATTRIBUTE_GAMES, games);
        req.getRequestDispatcher(WEBConstants.JSP_GAMES).forward(req, resp);
    }
}