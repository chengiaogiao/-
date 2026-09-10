package com.chenyinjie;

public class MaiPiao {
    public static void main(String[] args) {
        ChuangKou chuangKou = new ChuangKou();
        new Thread(chuangKou).start();
        new Thread(chuangKou).start();
        new Thread(chuangKou).start();
    }
}

class ChuangKou implements Runnable{
    private  int num=100;

    @Override
    public void run() {

        while (true){
            synchronized (this){
                if(num<=0){
                    System.out.println("没票了。。。");
                    break;
                }
                try {
                    Thread.sleep(50);
                    System.out.println("窗口"+Thread.currentThread().getName()+"售出了一张票还剩"+(--num)+"张票");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
}