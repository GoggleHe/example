package org.example.network.io.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.Set;

public class Test {

    public static void main(String[] args) throws Exception {
        try {
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(new InetSocketAddress(InetAddress.getByName("localhost"), 8090));
            serverChannel.configureBlocking(false);

            Selector selector = Selector.open();
            new Thread(new ReactorTask(serverChannel, selector)).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class ReactorTask implements Runnable {
    private final ServerSocketChannel serverChannel;
    private final Selector selector;

    public ReactorTask(ServerSocketChannel serverChannel, Selector selector) {
        this.serverChannel = serverChannel;
        this.selector = selector;
    }

    public void run() {
        try {
            serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);

            while (true) {
                int num = selector.select();

                if (num == 0) {
                    continue;
                }

                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeys) {
                    Object attachment = selectionKey.channel();


                    SocketChannel accept = serverChannel.accept();
                }
            }

        } catch (ClosedChannelException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}