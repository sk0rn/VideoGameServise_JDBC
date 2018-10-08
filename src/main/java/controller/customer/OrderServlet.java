package controller.customer;

import constants.WEBConstants;
import pojo.person.Person;
import service.person.LoginService;
import service.person.LoginServiceImpl;
import service.person.customer.impl.AccountServiceImpl;
import service.person.customer.interfaces.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.WEBConstants.*;

public class OrderServlet extends HttpServlet {
    private AccountService accountService;
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        accountService = new AccountServiceImpl();
        loginService = new LoginServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute(ATTRIBUTE_TITLE, "Orders");
        String login = (String) req.getSession().getAttribute(WEBConstants.LOGIN);
        Person customer = loginService.getCustomerByLogin(login);
        if (customer != null) {
            req.setAttribute(ATTRIBUTE_ORDERS, accountService.getOrdersByCustomerId(customer.getId()));
        }
        req.getRequestDispatcher("/customer/orders.jsp").forward(req,resp);
    }
}
