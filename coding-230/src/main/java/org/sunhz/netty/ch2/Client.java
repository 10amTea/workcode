package org.sunhz.netty.ch2;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author 闪电侠
 */
public class Client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;
    private static final int SLEEP_TIME = 1000;

    public static void main(String[] args) throws IOException {
        final Socket socket = new Socket(HOST, PORT);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("客户端启动成功!");
                while (true) {
                    try {
                        String message = "hello world";
                        System.out.println("客户端发送数据: " + message);
                        socket.getOutputStream().write(message.getBytes());
//                        byte[] data = new byte[2048];
//                        InputStream inputStream = socket.getInputStream();
//                        int len;
//                        while ((len = inputStream.read(data)) != -1) {
//                            String backMessage = new String(data, 0, len);
//                            System.out.println("server回传消息: " + backMessage);
//                        }
//                        socket.getOutputStream().write(data);
                        System.out.println("循环");
                    } catch (Exception e) {
                        System.out.println("写数据出错!");
                    }
                    sleep();
                }


            }
        }).start();

    }

    private static void sleep() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
