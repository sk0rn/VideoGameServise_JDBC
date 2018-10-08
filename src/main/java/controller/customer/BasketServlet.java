package controller.customer;

import constants.WEBConstants;
import pojo.person.Person;
import service.person.LoginService;
import service.person.LoginServiceImpl;
import service.person.customer.impl.AccountServiceImpl;
import service.person.customer.impl.BasketServiceImpl;
import service.person.customer.interfaces.AccountService;
import service.person.customer.interfaces.BasketService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.WEBConstants.*;

public class BasketServlet extends HttpServlet {
    private BasketService basketService;
    private AccountService accountService;
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        basketService = new BasketServiceImpl();
        accountService = new AccountServiceImpl();
        loginService = new LoginServiceImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Basket");
        req.setAttribute("basket", basketService.showAddedGames(req.getCookies()));
        req.getRequestDispatcher("/customer/basket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (basketService.checkout(req.getCookies())) {
            String login = (String) req.getSession().getAttribute(WEBConstants.LOGIN);
            Person customer = loginService.getCustomerByLogin(login);
            if (customer != null) {
                accountService.createOrder(customer.getId(), req.getCookies());
                eraseCookie(req, resp);
                req.setAttribute("checkout", true);
            }
        } else {
            req.setAttribute("checkout", false);
        }
        req.getRequestDispatcher("/customer/basket.jsp").forward(req, resp);

    }

    private void eraseCookie(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies) {
                if (cookie.getName().indexOf("g_uid") == 0) {
                    cookie.setValue("");
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    resp.addCookie(cookie);
                }
            }
    }
}
