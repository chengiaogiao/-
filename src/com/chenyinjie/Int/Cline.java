package com.chenyinjie.Int;


import com.sun.xml.internal.ws.util.StreamUtils;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cline {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),9999);
        Scanner scanner = new Scanner(System.in);
//        outputStream.write("eeee".getBytes(StandardCharsets.UTF_8));
//        outputStream.write("eeee232".getBytes(StandardCharsets.UTF_8));

        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        while (true){
            System.out.println("请输入");
            String next = scanner.next();
            bufferedWriter.write(next);
            bufferedWriter.newLine();
            bufferedWriter.flush();


//            outputStream.write(next.getBytes(StandardCharsets.UTF_8));
//            socket.shutdownOutput();
//            byte[] aa=new byte[1024];
//            int rea=0;
//            while ((rea=inputStream.read(aa))!=-1){
//                System.out.println(new String(aa,0,rea));
//            }
            String aa= bufferedReader.readLine();
            System.out.println(aa);
            if(aa==null)break;
//        inputStream.close();
//        outputStream.close();
        }
//        inputStream.close();
//        outputStream.close();
        socket.close();
    }
}
