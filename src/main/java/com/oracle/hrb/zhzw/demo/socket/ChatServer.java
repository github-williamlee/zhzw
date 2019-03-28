package com.oracle.hrb.zhzw.demo.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
/*
    TCP协议发送数据
 */
public class ChatServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("服务器已经启动.. ..");
            // 调用accept方法时会产生中断，直到获取到请求的连接才会结束中断
            Socket s = serverSocket.accept();
            System.out.println("获得请求###");
            // 接收数据
            Thread in = new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream(), "utf-8"));
                        while (true) {
                            String msg = reader.readLine();
                            System.out.println(msg);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            // 发送数据
            Thread out = new Thread() {
                @Override
                public void run() {
                    try {
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(s.getOutputStream(),"utf-8"));
                        Scanner scanner = new Scanner(System.in);
                        while (true) {
                            String msg = scanner.nextLine();
                            writer.println(msg);
                            writer.flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            in.start();
            out.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
