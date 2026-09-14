package com.chenyinjie.Int2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server01 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8888);
        Socket accept = socket.accept();
        String srcL="src\\explosion1.png";
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(srcL);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        byte[] aa=new byte[1024];
        int len=0;
        while ((len=inputStream.read(aa))!=-1){
            fileOutputStream.write(aa);
        }
        bufferedWriter.write("收到图片");
        System.out.println("111");
        bufferedWriter.newLine();
        System.out.println("222");
        bufferedWriter.flush();
        System.out.println("333");

//        accept.shutdownOutput();
        bufferedWriter.close();
        inputStream.close();
        socket.close();

    }
}
