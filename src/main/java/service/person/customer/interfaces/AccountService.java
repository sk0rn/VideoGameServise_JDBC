package service.person.customer.interfaces;

import pojo.orders.Order;
import pojo.orders.OrderDetails;

import javax.servlet.http.Cookie;
import java.util.List;

public interface AccountService {

    boolean createCustomer(String login, String pass);

    boolean createOrder(Integer customerId, Cookie[] cookies);

    List<Order> getOrdersByCustomerId(Integer customerId);

    List<OrderDetails> getOrderDetails(Integer orderId);
}
