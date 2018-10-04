package controller.content;

import constants.WEBConstants;
import service.games.impl.DeveloperFeatureImpl;
import service.games.impl.TitleFeatureImpl;
import service.games.interfaces.GameFeatureService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TitleServlet extends HttpServlet {

    private GameFeatureService titleService;

    @Override
    public void init() throws ServletException {
        super.init();
        titleService = new TitleFeatureImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("titles", titleService.getAllFeatures());
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Titles");
        req.getRequestDispatcher("/game_content/titles.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        titleService.addFeature(name);
        this.doGet(req, resp);
    }
}
