package org.example.concurrent.interrupt;

public class CustomThread extends Thread {

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
//                Thread.sleep(3000);
                System.out.println("not interrupted");
            }
            System.out.println("end");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}