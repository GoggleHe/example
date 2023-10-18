package org.example.concurrent.application.dispather;

public class Main {

    public static void main(String[] args) {
        OrderDispatcher dispatcher = new OrderDispatcher();

        System.out.println("set ");
        for (int i = 0; i < 100; i++) {
            dispatcher.addOrder("0" + i);
            dispatcher.watch("0" + i);
        }



    }

}
