package controller;

import pojo.game.Game;
import service.GameService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class GameListServlet extends HttpServlet {

    private GameService gameService;

    @Override
    public void init() throws ServletException {
        super.init();
        gameService = new GameService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Game> games = gameService.getAllGames();
        req.setAttribute("games", games);
        req.getRequestDispatcher("/games.jsp").forward(req, resp);
    }
}
