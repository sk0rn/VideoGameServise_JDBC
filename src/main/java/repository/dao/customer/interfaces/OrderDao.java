package repository.dao.customer.interfaces;

import pojo.orders.Order;

import java.util.List;

public interface OrderDao {

    boolean createOrder(Integer customerId, Integer[] gameIds);

    void changeStatus(Integer orderId, Integer status);

    List<Order> getOrdersByCustomerId(Integer customerId);
}
