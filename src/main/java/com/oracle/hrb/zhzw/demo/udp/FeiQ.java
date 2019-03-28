package com.oracle.hrb.zhzw.demo.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class FeiQ {
	public static void main(String[] args) throws Exception {
		// 飞Q定义的数据格式
		String str = "1:100:李老师:msi:32:hello 你好啊";
		byte[] array = str.getBytes("gbk");
		//
		DatagramSocket ds = new DatagramSocket();
		for (int i = 1; i <= 255; i++) {
			DatagramPacket dp = new DatagramPacket(array, array.length, InetAddress.getByName("192.168.10." + i), 2425);
			ds.send(dp);
			dp = new DatagramPacket(array, array.length, InetAddress.getByName("192.168.11." + i), 2425);
			ds.send(dp);
		}
	}
}
