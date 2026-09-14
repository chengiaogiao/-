package com.chenyinjie.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class Udp01 {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        byte[] aa="hello 明天吃火锅~".getBytes();
        datagramSocket.send(new DatagramPacket(aa,aa.length, InetAddress.getLocalHost(),9999));
        byte[] aa1=new byte[1024];
//        int len=0;
        DatagramPacket datagramPacket = new DatagramPacket(aa1,aa1.length);

        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        datagramSocket.close();
    }
}
