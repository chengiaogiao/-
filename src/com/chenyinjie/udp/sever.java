package com.chenyinjie.udp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class sever {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        byte[] aa=new byte[1024];
//        int len=0;
        DatagramPacket datagramPacket = new DatagramPacket(aa,aa.length);

        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        byte[] aa1="好的明天见".getBytes();
        datagramSocket.send(new DatagramPacket(aa1,aa1.length, InetAddress.getLocalHost(),9998));
        datagramSocket.close();
    }
}
