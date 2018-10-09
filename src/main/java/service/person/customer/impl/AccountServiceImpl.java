package service.person.customer.impl;

import org.apache.log4j.Logger;
import pojo.orders.Order;
import pojo.orders.OrderDetails;
import repository.dao.customer.impl.OrderDaoImpl;
import repository.dao.customer.interfaces.OrderDao;
import service.person.customer.interfaces.AccountService;

import javax.servlet.http.Cookie;

import java.util.List;

import static utils.CookieHandler.handleForGameIds;

public class AccountServiceImpl implements AccountService {
    private OrderDao orderDao;

    public AccountServiceImpl() {
        orderDao = new OrderDaoImpl();
    }

    public AccountServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public boolean createOrder(Integer customerId, Cookie[] cookies) {
        Integer[] ids = handleForGameIds(cookies);
        return (ids.length != 0) && orderDao.createOrder(customerId, ids);
    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer customerId) {
        return orderDao.getOrdersByCustomerId(customerId);
    }

    @Override
    public List<OrderDetails> getOrderDetails(Integer orderId) {
        return orderDao.getOrderDetails(orderId);
    }
}
