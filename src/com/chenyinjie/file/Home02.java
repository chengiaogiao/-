package com.chenyinjie.file;

import java.io.*;

public class Home02 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\mytemp\\hello.txt"));
        String i;
        int i1=1;

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(new FileInputStream("D:\\mytemp\\hello.txt"),"gbk"));
        while ((i=bufferedReader.readLine())!=null){
             System.out.println("第"+i1+"行："+i);
        }
        bufferedReader.close();
    }
}
