package com.chenyinjie.qqServer;

import com.chenyinjie.com.Message;
import com.chenyinjie.com.MessageType;
import com.chenyinjie.com.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class QQServer {

    private ServerSocket ss=null;
  private   static   HashMap<String,User> list=new HashMap<>();

    public static HashMap<String, User> getList() {
        return list;
    }

    static {
        list.put("100",new User("100","123456"));
        list.put("101",new User("101","123456"));
        list.put("102",new User("102","123456"));
    }

    public static boolean chek(String userId,String password){
        if(list.get(userId)==null){
            return  false;
        }
        if(!list.get(userId).getPassword().equals(password)){
            return  false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        QQServer qqServer = new QQServer();
    }
    public QQServer() throws IOException, ClassNotFoundException {
       ss=new ServerSocket(9999);
       while (true){
           Socket accept = ss.accept();
           ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
           ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
           User u=(User) objectInputStream.readObject();
           System.out.println(u);
           Message m=new Message();
           if(chek(u.getUserId(),u.getPassword())){
               m.setMesType(MessageType.MESSAGE_LOGIN_SUCCESS);
               objectOutputStream.writeObject(m);
               Xiancheng xiancheng = new Xiancheng(accept,u.getUserId());
               xiancheng.start();
               Mxiancheng.addxiancheng(u.getUserId(),xiancheng);
           }else{
               m.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
               objectOutputStream.writeObject(m);
               accept.close();
           }
       }
    }
}
