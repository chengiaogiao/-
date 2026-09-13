package com.chenyinjie.tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable {
    Vector<Zidan> enemyZidans=new Vector<>();
    private Vector<EnemyTank> enemyTankss=new Vector<>();
    public EnemyTank(int x, int y, int direct) {
         super(x, y, direct);

    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTankss = enemyTanks;
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

                  for (int i = 0; i < 100; i++) {

                      if(getY()-getSpeed()>0&&!pengZhuang1()){

                          setY(getY()-getSpeed());
                          try {
                              Thread.sleep(50);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }else{
//                          setDirect((int)(Math.random()*4));
                      }

                  }
                  break;
              case 1:
                  for (int i = 0; i < 100; i++) {

                      if(getX()+getSpeed()<1000&&!pengZhuang1()){
                          setX(getX()+getSpeed());
                          try {
                              Thread.sleep(50);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }else{
//                          setDirect((int)(Math.random()*4));
                      }

                  }
                  break;
              case 2:
                  for (int i = 0; i < 100; i++) {

                      if(getY()+getSpeed()<750&&!pengZhuang1()){
                          setY(getY()+getSpeed());
                          try {
                              Thread.sleep(50);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }else{
//                          setDirect((int)(Math.random()*4));
                      }


                  }
                  break;
              case 3:
                  for (int i = 0; i < 100; i++) {

                      if(getX()-getSpeed()>0&&!pengZhuang1()){
                          setX(getX()-getSpeed());
                          try {
                              Thread.sleep(50);
                          } catch (InterruptedException e) {
                              throw new RuntimeException(e);
                          }
                      }else{
//                          setDirect((int)(Math.random()*4));
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
    public boolean pengZhuang1(){
        for (int i = 0; i < enemyTankss.size(); i++) {
            EnemyTank enemyTank2=enemyTankss.get(i);
            EnemyTank enemyTank1=this;
          if(enemyTank1!=enemyTank2){

              switch (enemyTank1.getDirect()){
                  case 0:
                      switch (enemyTank2.getDirect()){
                          case 0:
                          case 2:
                              if(

                                      enemyTank1.getX()>=enemyTank2.getX()&&
                                              enemyTank1.getX()<=enemyTank2.getX()+40&&
                                              enemyTank1.getY()>=enemyTank2.getY()&&
                                              enemyTank1.getY()<=enemyTank2.getY()+60
                              ){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                return true;
                              }
                              if(enemyTank1.getX()+40>=enemyTank2.getX()&&
                                      enemyTank1.getX()+40<=enemyTank2.getX()+40&&

                                      enemyTank1.getY()>=enemyTank2.getY()&&
                                      enemyTank1.getY()<=enemyTank2.getY()+60
                              ){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }

                              break;
                          case 1:
                          case 3:
                              if(enemyTank1.getX()+40>=enemyTank2.getX()&&
                                      enemyTank1.getX()+40<=enemyTank2.getX()+60&&
                                      enemyTank1.getY()>=enemyTank2.getY()&&
                                      enemyTank1.getY()<=enemyTank2.getY()+40
                              ){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              if(
                                      enemyTank1.getX()>=enemyTank2.getX()&&
                                              enemyTank1.getX()<=enemyTank2.getX()+60&&
                                              enemyTank1.getY()>=enemyTank2.getY()&&
                                              enemyTank1.getY()<=enemyTank2.getY()+40
                              ){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              break;
                      }
                    break;
                  case 2:
                      switch (enemyTank2.getDirect()){
                          case 0:
                          case 2:
                              if(enemyTank1.getX()+40>=enemyTank2.getX()&&
                                      enemyTank1.getX()+40<=enemyTank2.getX()+40&&
                                      enemyTank1.getY()+60>=enemyTank2.getY()&&
                                      enemyTank1.getY()+60<=enemyTank2.getY()+60){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              if(
                                      enemyTank1.getX()>=enemyTank2.getX()&&
                                              enemyTank1.getX()<=enemyTank2.getX()+40&&
                                              enemyTank1.getY()+60>=enemyTank2.getY()&&
                                              enemyTank1.getY()+60<=enemyTank2.getY()+60){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              break;
                          case 1:
                          case 3:
                              if(enemyTank1.getX()+40>=enemyTank2.getX()&&
                                      enemyTank1.getX()+40<=enemyTank2.getX()+60&&
                                      enemyTank1.getY()+60>=enemyTank2.getY()&&
                                      enemyTank1.getY()+60<=enemyTank2.getY()+40){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              if(
                                      enemyTank1.getX()>=enemyTank2.getX()&&
                                              enemyTank1.getX()<=enemyTank2.getX()+60&&
                                              enemyTank1.getY()+60>=enemyTank2.getY()&&
                                              enemyTank1.getY()+60<=enemyTank2.getY()+40){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              break;
                      }

                      break;
                  case 1:
                      switch (enemyTank2.getDirect()){
                          case 0:
                          case 2:
                              if(enemyTank1.getX()+60>=enemyTank2.getX()&&
                                      enemyTank1.getX()+60<=enemyTank2.getX()+40&&

                                      enemyTank1.getY()+40>=enemyTank2.getY()&&
                                      enemyTank1.getY()+40<=enemyTank2.getY()+60){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              if(enemyTank1.getX()+60>=enemyTank2.getX()&&
                                      enemyTank1.getX()+60<=enemyTank2.getX()+40&&

                                      enemyTank1.getY()>=enemyTank2.getY()&&
                                      enemyTank1.getY()<=enemyTank2.getY()+60
                              ){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              break;
                          case 1:
                          case 3:
                              if(enemyTank1.getX()+60>=enemyTank2.getX()&&
                                      enemyTank1.getX()+60<=enemyTank2.getX()+60&&
                                      enemyTank1.getY()+40>=enemyTank2.getY()&&
                                      enemyTank1.getY()+40<=enemyTank2.getY()+40){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              if(enemyTank1.getX()+60>=enemyTank2.getX()&&
                                      enemyTank1.getX()+60<=enemyTank2.getX()+60&&
                                      enemyTank1.getY()>=enemyTank2.getY()&&
                                      enemyTank1.getY()<=enemyTank2.getY()+40
                              ){
                                  System.out.println(enemyTank1+"-"+enemyTank2);
                                  return true;
                              }
                              break;
                      }
                      break;
                  case 3:

                      switch (enemyTank2.getDirect()){
                          case 0:
                          case 2:
                              if(
                                      enemyTank1.getX()>=enemyTank2.getX()&&
                                              enemyTank1.getX()<=enemyTank2.getX()+40&&
                                              enemyTank1.getY()+40>=enemyTank2.getY()&&
                                              enemyTank1.getY()+40<=enemyTank2.getY()+60){
                                  System.out.println(enemyTank1+"-"+enemyTank2);
                                  return true;
                              }
                              if(
                                      enemyTank1.getX()>=enemyTank2.getX()&&
                                              enemyTank1.getX()<=enemyTank2.getX()+40&&
                                              enemyTank1.getY()>=enemyTank2.getY()&&
                                              enemyTank1.getY()<=enemyTank2.getY()+60
                              ){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              break;
                          case 1:
                          case 3:
                              if(
                                      enemyTank1.getX()>=enemyTank2.getX()&&
                                              enemyTank1.getX()<=enemyTank2.getX()+60&&
                                              enemyTank1.getY()+40>=enemyTank2.getY()&&
                                              enemyTank1.getY()+40<=enemyTank2.getY()+40){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              if(
                                      enemyTank1.getX()>=enemyTank2.getX()&&
                                              enemyTank1.getX()<=enemyTank2.getX()+60&&
                                              enemyTank1.getY()>=enemyTank2.getY()&&
                                              enemyTank1.getY()<=enemyTank2.getY()+40
                              ){
                                  System.out.println(enemyTank1+"-"+enemyTank2);

                                  return true;
                              }
                              break;
                      }

                      break;

              }
          }else{
          }
        }
        return  false;
    }
}
