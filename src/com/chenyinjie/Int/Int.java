package com.chenyinjie.Int;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Int {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress byAddress = InetAddress.getLocalHost();
        System.out.println(byAddress);
        InetAddress byAddress1 = InetAddress.getByName("JIN");
        System.out.println(byAddress1);
        InetAddress byAddress2 = InetAddress.getByName("www.baidu.com");
        System.out.println(byAddress2);


    }
}
