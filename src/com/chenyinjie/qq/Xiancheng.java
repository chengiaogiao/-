package com.chenyinjie.qq;

import com.chenyinjie.com.Message;
import com.chenyinjie.com.MessageType;
import com.chenyinjie.qqServer.QQServer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Xiancheng extends  Thread{
   private Socket socket=null;
    private boolean loop=true;
    public Xiancheng(Socket socket) {
        this.socket = socket;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
         super.run();
         while (loop){


             try {
                 if(socket==null){break;}
                 ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                 Message aa = (Message) objectInputStream.readObject();
                 if(aa.getMesType().equals(MessageType.MESSAGE_RET_ONLIN)){
                    System.out.println("===list====");

                     for (Object o :aa.getContent().split(" ")) {
                         System.out.println("用户:"+o);
                     }

                 }else if(aa.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                     System.out.println("===list====");
                     System.out.println(aa.getSender()+"发送消息给"+aa.getGetter()+"说："+aa.getContent());

                 }else if(aa.getMesType().equals(MessageType.MESSAGE_ALL_MES)){
                     System.out.println("===list====");
                     System.out.println(aa.getSender()+"发送消息给大家说："+aa.getContent());

                 }else if(aa.getMesType().equals(MessageType.MESSAGE_FILE_MES)){
                     System.out.println("===list====");
                     System.out.println(aa.getSender()+"发文件");
                     FileOutputStream fileOutputStream = new FileOutputStream(aa.getDest());
                     fileOutputStream.write(aa.getBts());
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
