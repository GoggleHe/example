package org.example.network.io.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class BioTimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8090;

        ServerSocket server = new ServerSocket(port);

        Socket socket = null;
        while (true) {
            System.out.println("start accept");
            socket = server.accept();
            System.out.println("end accept");

            BlockingQueue<Runnable> bq = new ArrayBlockingQueue<Runnable>(1);

            ExecutorService pool = new ThreadPoolExecutor(1,1,10000, TimeUnit.MICROSECONDS,bq);
            pool.submit(new BioTimeServerHandler(socket));

        }

    }


}

class BioTimeServerHandler implements Runnable {
    private Socket socket;

    public BioTimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {

            while (true) {

                System.out.println(Thread.currentThread().getId() + "\t" + Thread.currentThread().getName() + "\tstart");
                br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                pw = new PrintWriter(this.socket.getOutputStream(), true);

                StringBuilder sb = new StringBuilder();

                int value = '$';
                while ((value = br.read()) != '$') {
                    sb.append((char) value);
                }

                System.out.println("Accept:" + sb.toString());
                String result = "Query Time".equalsIgnoreCase(sb.toString()) ? new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) : "Bad Order:" + sb.toString();
                System.out.println("result :" + result);
                pw.println(result);
                System.out.println(Thread.currentThread().getId() + "\t" + Thread.currentThread().getName() + "\tend");

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("release resource");
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}