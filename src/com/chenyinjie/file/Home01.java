package com.chenyinjie.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Home01 {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\mytemp");
        boolean exists = file.exists();
        if(!exists){
            file.mkdir();
        }
        File file1 = new File("D:\\mytemp\\hello.txt");
        boolean exists1 = file1.exists();
        if(exists1){
//           System.out.println("文件有了");
            file.delete();
        }
        file1.createNewFile();

        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        fileOutputStream.write("你好".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.write("你好2".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();
    }
}
