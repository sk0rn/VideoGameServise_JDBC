package controller;

import service.games.impl.DeveloperFeatureImpl;
import service.games.interfaces.GameFeatureService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DevServlet extends HttpServlet {
    private GameFeatureService devService;

    @Override
    public void init() throws ServletException {
        super.init();
        devService = new DeveloperFeatureImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("developers", devService.getAllFeatures());
        req.setAttribute("title", "Developers");
        req.getRequestDispatcher("/developers.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        devService.addFeature(name);
        this.doGet(req, resp);
    }

}