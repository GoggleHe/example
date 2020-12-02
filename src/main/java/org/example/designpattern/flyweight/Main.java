package org.example.designpattern.flyweight;

/**
 *
 **/
public class Main {

    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(100);
        for (int i = 0; i < 300; i++) {
            Connection connect = pool.getConnection();
            connect.disconnect();
            System.out.println(connect);
        }

    }

}
