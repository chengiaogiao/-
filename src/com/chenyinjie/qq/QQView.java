package com.chenyinjie.qq;

import java.io.IOException;

public class QQView {
    private boolean loop=true;
    private String key="";
    private  UserClientService userClientService=new UserClientService();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new QQView().mainMenu();
    }

    private void mainMenu() throws IOException, ClassNotFoundException {
       while (loop){
           System.out.println("========欢迎登录网络通信系统========");
           System.out.println("\t\t 1登录系统");
           System.out.println("\t\t 9退出系统");
           key= Utility.readString(1);
            switch (key){
                case "1":
                    System.out.println("输入用户名：");
                    String key1= Utility.readString(50);
                    System.out.println("输入密码：");
                    String key2= Utility.readString(50);

                    if(userClientService.checkUser(key1,key2)){
                        System.out.println("欢迎"+key1);
                        while (loop){
                            System.out.println("========网络通信二级系统========"+key1);
                            System.out.println("\t\t 1显示在线用户列表");
                            System.out.println("\t\t 2群发消息");
                            System.out.println("\t\t 3私聊消息");
                            System.out.println("\t\t 4发送文件");
                            System.out.println("\t\t 9退出系统");
                            String key3= Utility.readString(1);
switch (key3){
    case "1":
        userClientService.setList();
        System.out.println("显示在线用户列表");
        break;
    case "2":
        System.out.println("群发消息");
        break;
    case "3":
        System.out.println("私聊消息");
        break;
    case "4":
        System.out.println("发送文件");
        break;
    case "9":
        System.out.println("退出系统");
        userClientService.tui();
        System.exit(0);
        loop=false;

        break;
}
                        }
                    }else{
                        System.out.println("登录失败");
                        break;
                }
                    break;
                case "9":
                    System.out.println("退出系统");

                    loop=false;

                    break;
            }
       }
    }
}
