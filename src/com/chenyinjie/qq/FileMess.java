package com.chenyinjie.qq;

import com.chenyinjie.com.Message;
import com.chenyinjie.com.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileMess {
    public static void setFME(String src,String dest,String g,String s) throws IOException {
        Message message = new Message();
        message.setSender(s);
        message.setGetter(g);
        message.setSrc(src);
        message.setDest(dest);
        message.setMesType(MessageType.MESSAGE_FILE_MES);

        byte[] af=new byte[(int)new File(src).length()];

        FileInputStream fileInputStream = new FileInputStream(src);
        fileInputStream.read(af);
        message.setBts(af);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Mxiancheng.getXiancheng(s).getSocket().getOutputStream());
        objectOutputStream.writeObject(message);

    }
}
