package com.chenyinjie.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Zidan> enemyZidans=new Vector<>();
    ZidanCallback fn;
    public EnemyTank(int x, int y, int direct,ZidanCallback fn) {
         super(x, y, direct);

         this.fn=fn;
    }

    public void faShe(){
        synchronized(this){
            Zidan a= new Zidan(super.getX(),super.getY(),super.getDirect(),new ZidanCallback() {
                @Override
                public void en(){
                    fn.en();
                }
            });
            a.setSpeed(20);
            enemyZidans.removeIf(aa->aa.isX);
            enemyZidans.add(a);
            Thread thread = new Thread(a);
            thread.start();
        }

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println("测试实施");
                faShe();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
