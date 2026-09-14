package com.chenyinjie.qqServer;

import com.chenyinjie.com.Message;
import com.chenyinjie.com.MessageType;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Xiancheng extends  Thread{
   private Socket socket=null;
   private String userId;
   private boolean loop=true;
    public Xiancheng(Socket socket,String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public void run() {
         super.run();
         while (loop){


             try {
                 ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                 Message aa = (Message) objectInputStream.readObject();

                 if(aa.getMesType().equals(MessageType.MESSAGE_GET_ONLIN)){
                     ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                     String cen=Mxiancheng.getOn();
                     Message message = new Message();
                     message.setMesType(MessageType.MESSAGE_RET_ONLIN);
                     System.out.println(cen);
                     message.setContent(cen);
                     message.setGetter(aa.getSender());
                     objectOutputStream.writeObject(message);
                 }
                 if(aa.getMesType().equals(MessageType.MESSAGE_C_END)){
                     System.out.println("退出");
                    String id= aa.getSender();
                     Mxiancheng.reXiancheng(id);
                     loop=false;
                 }

                 System.out.println(aa);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }
    }

    public Socket getSocket() {
        return socket;
    }


}
