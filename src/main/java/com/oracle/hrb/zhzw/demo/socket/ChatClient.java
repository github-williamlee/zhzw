package com.oracle.hrb.zhzw.demo.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8888);
            // 接收数据
            Thread in = new Thread() {
                @Override
                public void run() {
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
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
                        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
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
