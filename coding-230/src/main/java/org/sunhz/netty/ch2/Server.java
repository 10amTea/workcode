package org.sunhz.netty.ch2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("服务端启动成功，端口:" + port);
        } catch (IOException exception) {
            System.out.println("服务端启动失败");
        }
    }

    /**
     * 端口监听放在单独的线程中
     */
    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();

        System.out.println("无法执行到我?");
    }

    /**
     * 接收客户端连接
     */
    private void doStart() {
        while (true) {
            try {
                Socket client = serverSocket.accept(); // 阻塞方法
                new ClientHandler(client).start();
            } catch (IOException e) {
                System.out.println("服务端异常");
            }
        }
    }
}
