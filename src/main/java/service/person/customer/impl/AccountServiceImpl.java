package service.person.customer.impl;

import org.apache.log4j.Logger;
import pojo.orders.Order;
import pojo.orders.OrderDetails;
import pojo.person.Person;
import pojo.person.Role;
import repository.dao.customer.impl.OrderDaoImpl;
import repository.dao.customer.interfaces.OrderDao;
import repository.dao.person.impl.PersonDaoImpl;
import repository.dao.person.interfaces.PersonDao;
import service.person.customer.interfaces.AccountService;
import utils.UtilMD5;

import javax.servlet.http.Cookie;

import java.util.List;

import static utils.CookieHandler.handleForGameIds;

public class AccountServiceImpl implements AccountService {
    private OrderDao orderDao;
    private PersonDao personDao;

    public AccountServiceImpl() {
        orderDao = new OrderDaoImpl();
        personDao = new PersonDaoImpl();
    }

    public AccountServiceImpl(OrderDao orderDao, PersonDao personDao) {
        this.orderDao = orderDao;
        this.personDao = personDao;
    }

    @Override
    public boolean createCustomer(String login, String pass) {
        String encrypted = UtilMD5.md5Custom(pass);
        return personDao.createPerson(new Person(null, null, null,
                null, new Role(8, null), login, encrypted));
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
