package com.chenyinjie.Int;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Server01 {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(9999);
        Socket accept = socket.accept();
        Scanner scanner = new Scanner(System.in);
        OutputStream outputStream = accept.getOutputStream();
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        while (true){
//            byte[] aa=new byte[1024];
//            int rea=0;
//            while ((rea=inputStream.read(aa))!=-1){
//                System.out.println(new String(aa,0,rea));
//            }

           String aa= bufferedReader.readLine();
            System.out.println(aa);
            if(aa==null)break;

//            outputStream.write(next.getBytes(StandardCharsets.UTF_8));
//            accept.shutdownOutput();
            System.out.println("请输入");
            String next = scanner.next();
            bufferedWriter.write(next);
            bufferedWriter.newLine();
            bufferedWriter.flush();


//            inputStream.close();
//        outputStream.close();
        }
//        OutputStream outputStream = accept.getOutputStream();
//        outputStream.write("eeee".getBytes(StandardCharsets.UTF_8));
//        outputStream.write("eeee232".getBytes(StandardCharsets.UTF_8));
//        accept.shutdownOutput();
//        inputStream.close();
//        outputStream.close();
        socket.close();

    }
}
