package org.example.designpattern.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 *
 **/
public class ConnectionPool {

    private List<Connection> pool = new ArrayList<>();

    private int size;

    public ConnectionPool(int size) {
        this.size = size;
    }

    public Connection getConnection() {
        if (pool.size() < this.size) {
            Connection connection = new Connection();
            pool.add(connection);
            connection.setAlive();
            return connection;
        } else {
            for (Connection connection : pool) {
                if (!connection.isAlive()) {
                    connection.setAlive();
                    return connection;
                }
            }
            Connection connection = new Connection();
            connection.setAlive();
            return connection;
        }
    }
}
