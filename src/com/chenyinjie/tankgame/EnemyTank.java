package com.chenyinjie.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Zidan> enemyZidans=new Vector<>();
    public EnemyTank(int x, int y, int direct) {
         super(x, y, direct);

    }

    public void faShe(){
        synchronized(this){
            Zidan a= new Zidan(super.getX(),super.getY(),super.getDirect());
            a.setSpeed(20);
            enemyZidans.add(a);
            Thread thread = new Thread(a);
            thread.start();
        }

    }

    @Override
    public void run() {
        while (!isX){

          switch (getDirect()){
              case 0:
                  for (int i = 0; i < 30; i++) {
                      if(getY()-getSpeed()>0){
                          setY(getY()-getSpeed());
                          try {
                              Thread.sleep(50);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }else{
                          setDirect((int)(Math.random()*4));
                      }

                  }
                  break;
              case 1:
                  for (int i = 0; i < 30; i++) {
                      if(getX()+getSpeed()<1000){
                          setX(getX()+getSpeed());
                          try {
                              Thread.sleep(50);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }else{
                          setDirect((int)(Math.random()*4));
                      }

                  }
                  break;
              case 2:
                  for (int i = 0; i < 30; i++) {
                      if(getY()+getSpeed()<750){
                          setY(getY()+getSpeed());
                          try {
                              Thread.sleep(50);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }else{
                          setDirect((int)(Math.random()*4));
                      }


                  }
                  break;
              case 3:
                  for (int i = 0; i < 30; i++) {
                      if(getX()-getSpeed()<750){
                          setX(getX()-getSpeed());
                          try {
                              Thread.sleep(50);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }else{
                          setDirect((int)(Math.random()*4));
                      }


                  }
                  break;
              default:
                  break;

          }

            setDirect((int)(Math.random()*4));
            faShe();
//            try {
//                Thread.sleep(1000);
//                faShe();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
