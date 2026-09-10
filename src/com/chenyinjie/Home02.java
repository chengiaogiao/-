package com.chenyinjie;

public class Home02 {
    public static void main(String[] args) {
        Back back = new Back();
        Thread T1= new Thread(back);
        T1.setName("T1");
        Thread T2= new Thread(back);
        T2.setName("T2");
        T1.start();
        T2.start();

    }
}

class Back implements Runnable{
    private int num=10000;

    @Override
    public void run() {
      while (true){
          synchronized (this){
              if(num<=0){
                  break;
              }
              num-=1000;
          }

              try {
                  Thread.sleep(10);
                  System.out.println(Thread.currentThread().getName()+"取款1000还剩"+num);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }

      }
    }
}
