package controller.content;

import constants.WEBConstants;
import service.games.impl.PlatformFeatureImpl;
import service.games.impl.TitleFeatureImpl;
import service.games.interfaces.GameFeatureService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.WEBConstants.ATTRIBUTE_PLATFORMS;
import static constants.WEBConstants.PARAMETER_NAME;

public class PlatformServlet extends HttpServlet {

    private GameFeatureService platformService;

    @Override
    public void init() throws ServletException {
        super.init();
        platformService = new PlatformFeatureImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(ATTRIBUTE_PLATFORMS, platformService.getAllFeatures());
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Platforms");
        req.getRequestDispatcher("/game_content/platforms.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(PARAMETER_NAME);
        platformService.addFeature(name);
        this.doGet(req, resp);
    }
}
