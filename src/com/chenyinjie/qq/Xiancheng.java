package com.chenyinjie.qq;

import com.chenyinjie.com.Message;
import com.chenyinjie.com.MessageType;
import com.chenyinjie.qqServer.QQServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Xiancheng extends  Thread{
   private Socket socket=null;

    public Xiancheng(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
         super.run();
         while (true){


             try {
                 if(socket==null){break;}
                 System.out.println(socket);
                 ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                 Message aa = (Message) objectInputStream.readObject();
                 if(aa.getMesType().equals(MessageType.MESSAGE_RET_ONLIN)){
                    System.out.println("===list====");

                     for (Object o :aa.getContent().split(" ")) {
                         System.out.println("用户:"+o);
                     }

                 }

             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
    }

    public Socket getSocket() {
        return socket;
    }
}
