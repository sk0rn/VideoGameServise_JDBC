package service.person.customer.interfaces;

import pojo.orders.Order;

import javax.servlet.http.Cookie;
import java.util.List;

public interface AccountService {

    boolean createOrder(Integer customerId, Cookie[] cookies);

    List<Order> getOrdersByCustomerId(Integer customerId);
}