package repository.dao.customer.interfaces;

import pojo.orders.Order;
import pojo.orders.OrderDetails;

import java.util.List;

public interface OrderDao {

    boolean createOrder(Integer customerId, Integer[] gameIds);

    void changeStatus(Integer orderId, Integer status);

    List<Order> getOrdersByCustomerId(Integer customerId);

    List<OrderDetails> getOrderDetails(Integer orderId);
}
