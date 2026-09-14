package com.chenyinjie.qq;

import com.chenyinjie.com.Message;
import com.chenyinjie.com.MessageType;
import com.chenyinjie.com.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;


public class UserClientService {
    private User user=new User();
    private Socket socket;

    public void setList() throws IOException {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLIN);
        message.setSender(user.getUserId());
        Xiancheng x=Mxiancheng.getXiancheng(user.getUserId());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(x.getSocket().getOutputStream());
        objectOutputStream.writeObject(message);
    }


    public void tui() throws IOException {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_C_END);
        message.setSender(user.getUserId());
        Xiancheng x=Mxiancheng.getXiancheng(user.getUserId());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(x.getSocket().getOutputStream());
        objectOutputStream.writeObject(message);
//        objectOutputStream.close();
//        socket.close();
        x.setLoop(false);
//        socket.close();
        System.exit(0);

    }


    public boolean checkUser(String userId,String password) throws IOException, ClassNotFoundException {
        user.setUserId(userId);
        user.setPassword(password);

        socket = new Socket(InetAddress.getLocalHost(), 9999);

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(user);


        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

        Message aa = (Message) objectInputStream.readObject();

        if (aa.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCESS)) {
            Xiancheng xiancheng = new Xiancheng(socket);
            xiancheng.start();

            Mxiancheng.addxiancheng(userId,xiancheng);
            return true;
        } else {
            socket.close();
            return false;
        }
    }
}
