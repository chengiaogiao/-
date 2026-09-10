package com.chenyinjie;

import javax.swing.*;

import java.util.Scanner;

public class Home01 {
    public static void main(String[] args) {
        Shu shu = new Shu();
        shu.start();
        Shu2 shu2 = new Shu2(shu);

        shu2.start();
    }

}

class Shu extends Thread{
    private boolean lock=true;

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (lock){
            System.out.println((int)(Math.random()*100));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Shu2 extends Thread{
    private Shu s;
    private Scanner scanner= new Scanner(System.in);

    public Shu2(Shu s) {
        System.out.println("请输入"+s);
        this.s = s;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("请输入");
           char key= scanner.next().toUpperCase().charAt(0);
            System.out.println("请输入33"+key);
           if(key=='Q'){
               System.out.println("请输入22");
               s.setLock(false);
               break;
           }
        }
    }
}