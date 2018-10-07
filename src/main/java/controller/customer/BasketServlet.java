package controller.customer;

import constants.WEBConstants;
import service.customer.impl.BasketServiceImpl;
import service.customer.interfaces.BasketService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class BasketServlet extends HttpServlet {
    BasketService basketService;

    @Override
    public void init() throws ServletException {
        super.init();
        basketService = new BasketServiceImpl();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Basket");
        req.setAttribute("basket", basketService.showAddedGames(req.getCookies()));
        req.getRequestDispatcher("/customer/basket.jsp").forward(req,resp);
    }


}
