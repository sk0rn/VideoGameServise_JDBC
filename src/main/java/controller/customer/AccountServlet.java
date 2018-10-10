package controller.customer;

import constants.WEBConstants;
import service.person.customer.impl.AccountServiceImpl;
import service.person.customer.interfaces.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AccountServlet extends HttpServlet {

    AccountService accountService;

    @Override
    public void init() throws ServletException {
        super.init();
        accountService = new AccountServiceImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession().getAttribute(WEBConstants.LOGIN) == null) {
            req.getRequestDispatcher("/customer/register.jsp").forward(req, resp);
        }
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Account");
        req.getRequestDispatcher("/customer/account.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String name = req.getParameter("login");
        String pass = req.getParameter("pass");
        accountService.createCustomer(name, pass);
        resp.sendRedirect("/login");
    }
}
