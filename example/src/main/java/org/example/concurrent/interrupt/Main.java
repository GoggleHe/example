package org.example.concurrent.interrupt;

public class Main {
    public static void main(String[] args) {
        CustomThread thread = new CustomThread();
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
