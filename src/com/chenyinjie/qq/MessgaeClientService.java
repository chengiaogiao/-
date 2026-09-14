package com.chenyinjie.qq;

import com.chenyinjie.com.Message;
import com.chenyinjie.com.MessageType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MessgaeClientService {
    public static void setME(String userId,String con,String get) throws IOException {
        Message message = new Message();
        message.setContent(con);
        message.setGetter(userId);
        message.setSender(get);
        message.setMesType(MessageType.MESSAGE_COMM_MES);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Mxiancheng.getXiancheng(get).getSocket().getOutputStream());
        objectOutputStream.writeObject(message);

    }
    public static void setAME(String con,String get) throws IOException {
        Message message = new Message();
        message.setContent(con);
        message.setSender(get);
        message.setMesType(MessageType.MESSAGE_ALL_MES);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Mxiancheng.getXiancheng(get).getSocket().getOutputStream());
        objectOutputStream.writeObject(message);

    }
}
