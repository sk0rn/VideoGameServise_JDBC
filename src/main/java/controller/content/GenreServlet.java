package controller.content;

import service.games.impl.GenreFeatureImpl;
import service.games.interfaces.GameFeatureService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.WEBConstants.*;

public class GenreServlet extends HttpServlet {
    private GameFeatureService genreService;

    @Override
    public void init() throws ServletException {
        super.init();
        genreService = new GenreFeatureImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(ATTRIBUTE_TITLE, "Genres");
        req.setAttribute(ATTRIBUTE_GENRES, genreService.getAllFeatures());
        req.getRequestDispatcher("/game_content/genres.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(PARAMETER_NAME);
        genreService.addFeature(name);
        this.doGet(req, resp);
    }
}