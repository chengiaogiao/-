package com.chenyinjie.Int2;


import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cline {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8888);
        String srcL="D:\\explosion1.png";

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        FileInputStream fileInputStream = new FileInputStream(srcL);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        byte[] aa=new byte[1024];
         int len=0;
         while ((len=fileInputStream.read(aa))!=-1){
             outputStream.write(aa);
//             System.out.println(new String(aa,0,len));
         }
        socket.shutdownOutput();

        System.out.println("111");
        System.out.println(bufferedReader.readLine());

//        byte[] aa1=new byte[1024];
//        int len1=0;
//        while ((len1=inputStream.read(aa1))!=-1){
//             System.out.println(new String(aa1,0,len1));
//        }

        outputStream.close();
        bufferedReader.close();
        fileInputStream.close();
        socket.close() ;
    }
}
