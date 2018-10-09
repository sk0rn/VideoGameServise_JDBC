package controller.customer;

import constants.WEBConstants;
import pojo.orders.OrderDetails;
import service.person.customer.impl.AccountServiceImpl;
import service.person.customer.interfaces.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderDetailsServlet extends HttpServlet {
    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        super.init();
        accountService = new AccountServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<OrderDetails> orderDetails = accountService.getOrderDetails(
                Integer.parseInt(req.getParameter("order_id")));
        req.setAttribute(WEBConstants.ATTRIBUTE_TITLE, "Order details");
        req.setAttribute("order_details", orderDetails);
        req.getRequestDispatcher("/customer/order_details.jsp").forward(req, resp);
    }
}
