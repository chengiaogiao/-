package com.chenyinjie.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class File01 {
    public static void main(String[] args) throws IOException, InterruptedException {
     File f=   new File("d:\\text.txt");
     f.createNewFile();
        FileInputStream fileInputStream = new FileInputStream(f);
        FileOutputStream fileOutputStream = new FileOutputStream(f,true);
        byte[] B=new byte[8];
        int len=0;
        while ((len=(int)fileInputStream.read(B))!=-1){
            System.out.print(new String(B,0,len));
        }
        fileOutputStream.write(B);
        fileInputStream.close();
        fileOutputStream.close();

    }
}
