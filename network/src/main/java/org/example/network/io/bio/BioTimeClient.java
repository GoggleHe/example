package org.example.network.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioTimeClient {

    public static void main(String[] args) throws IOException, InterruptedException {

        ExecutorService pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            pool.submit(new BioTimeClientHandler());
        }

    }

}

class BioTimeClientHandler implements Runnable{

    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 8090);

            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

            pw.println("Query Time$");

            System.out.println("Client sent message !");

            String s = bf.readLine();

            System.out.println("received message : " + s);

//            Thread.sleep(100000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}