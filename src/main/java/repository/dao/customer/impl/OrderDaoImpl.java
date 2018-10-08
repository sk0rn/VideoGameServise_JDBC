package repository.dao.customer.impl;

import org.apache.log4j.Logger;
import pojo.orders.Order;
import repository.ConnectionManager.ConnectionManager;
import repository.ConnectionManager.ConnectionManagerMobileDB;
import repository.dao.customer.interfaces.OrderDao;
import repository.dao.game.impl.GenreDaoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static constants.PojoConstants.*;

public class OrderDaoImpl implements OrderDao {
    private static final Logger LOGGER = Logger.getLogger(GenreDaoImpl.class);
    private static ConnectionManager connectionManager =
            ConnectionManagerMobileDB.getInstance();

    @Override
    public boolean createOrder(Integer customerId, Integer[] gameIds) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement orderStatement = connection.prepareStatement(
                     "INSERT INTO orders values (DEFAULT, " +
                             "?, ?, ?, ?) RETURNING id ");
             PreparedStatement detailsStatement = connection.prepareStatement(
                     "INSERT INTO order_details values (?, ?, ?) ")) {
            connection.setAutoCommit(false);
            orderStatement.setInt(1, customerId);
            orderStatement.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
            orderStatement.setDate(3, new java.sql.Date(new java.util.Date().getTime() +
                    TimeUnit.DAYS.toMillis(7)));
            orderStatement.setInt(4, ORDER_STATUS_CREATED);
            try (ResultSet resultSet = orderStatement.executeQuery()) {
                Integer id;
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                    LOGGER.info("The new object Order in DB was assigned the id: "
                            + id);

                    for (Integer i : gameIds) {
                        if (i != null) {
                            detailsStatement.setInt(1, id);
                            detailsStatement.setInt(2, i);
                            detailsStatement.setInt(3, 1);
                            detailsStatement.execute();
                        }
                    }
                }
                connection.commit();
                return true;
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return false;
    }

    @Override
    public void changeStatus(Integer orderId, Integer status) {

    }

    @Override
    public List<Order> getOrdersByCustomerId(Integer customerId) {
        List<Order> orders = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM orders WHERE customer_id=?")) {
            preparedStatement.setInt(1, customerId);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                orders = new ArrayList<>();
                while (resultSet.next()) {
                    orders.add(new Order(
                            resultSet.getInt("id"),
                            resultSet.getInt("customer_id"),
                            resultSet.getDate("date_order"),
                            resultSet.getDate("date_return"),
                            resultSet.getInt("status")));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return orders;
    }
}
