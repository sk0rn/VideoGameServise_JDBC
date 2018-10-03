package controller;

import constants.WEBConstants;
import service.person.LoginService;
import service.person.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if ("logout".equals(req.getParameter("action"))) {
            req.getSession().invalidate();
        }
        if (req.getSession().getAttribute(WEBConstants.LOGIN) != null) {
            resp.sendRedirect("/inner/dashboard");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter(WEBConstants.LOGIN);
        String password = req.getParameter(WEBConstants.PASS);
        if (loginService.checkAuth(login, password)) {
            int role = loginService.getRole(login);
            req.getSession().setAttribute(WEBConstants.LOGIN, login);
            req.getSession().setAttribute(WEBConstants.ROLE, role);
            resp.sendRedirect("/inner/dashboard");
        } else {
            resp.sendRedirect(WEBConstants.ERROR_CODE_LOGIN+WEBConstants.WRONG_LOGIN);
        }
    }
}
