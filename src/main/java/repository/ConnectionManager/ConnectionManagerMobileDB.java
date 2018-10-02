package repository.ConnectionManager;

import org.apache.log4j.Logger;
import repository.dao.game.impl.PublisherDaoImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerMobileDB implements ConnectionManager {
    private static final Logger LOGGER = Logger.getLogger(PublisherDaoImpl.class);
    private static ConnectionManager connectionManager;
    private static final String CONFIG =
            "D:\\dev_edu\\STC13_HT\\Prjct01_VGS_JDBC\\src\\main\\resources\\conf\\settings.cfg";

    // приватный контсруктор, что бы нельзя было создавать объекты менеджера
    private ConnectionManagerMobileDB() {
    }

    public static ConnectionManager getInstance() {
        // если объект не создан, то создается
        if (connectionManager == null) {
            connectionManager = new ConnectionManagerMobileDB();
        }
        // возвращаем объект, если он был создан, то вернется уже имеющийся
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;

        String password = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CONFIG))) {
            password = bufferedReader.readLine();
        } catch (IOException e) {
            LOGGER.error(e);
        }

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/vgsdb",
                    "postgres",
                    password);
        } catch (ClassNotFoundException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return connection;
    }
}
