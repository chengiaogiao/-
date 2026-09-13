package com.chenyinjie.tankgame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    //定义坦克
    Hero hero=null;
    Vector<EnemyTank> enemyTanks=new Vector<>();
    Vector<Bome> bomes=new Vector<>();

    Object obj1=new Object();
    Object obj2=new Object();

    Image a=null;
    Image a1=null;
    Image a2=null;
    Image a3=null;
    Image a4=null;

    String aa2= new String();

    int enemyTankSize=3;
    public MyPanel() {
        hero = new Hero(100,100,0);
        hero.setSpeed(5);

        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank =new EnemyTank(200+(i*100),0,2);
            enemyTanks.add(enemyTank);
            enemyTank.setEnemyTanks(enemyTanks);

            Thread thread = new Thread(enemyTank);
            thread.start();
        }
        try {
            a = ImageIO.read(getClass().getResource("/explosion1.png"));
            a1 = ImageIO.read(getClass().getResource("/explosion2.png"));
            a2 = ImageIO.read(getClass().getResource("/explosion3.png"));
            a3 = ImageIO.read(getClass().getResource("/explosion4.png"));
            a4 = ImageIO.read(getClass().getResource("/explosion5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.fillRect(0,0,1000,750);
        if(hero!=null){
            drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);

            if(hero.isX){
                hero=null;
            }

        }


//        synchronized(obj1){
            for (EnemyTank o :enemyTanks) {
                drawTank(o.getX(),o.getY(),g,o.getDirect(),1);
                for (Zidan c :o.enemyZidans) {
                    if(!c.isX){
                        drawZidan(c.getX(),c.getY(),g,c.getDirect(),0);
                    }

                }
                o.enemyZidans.removeIf(aa->aa.isX);
            }


            enemyTanks.removeIf(aa->aa.isX);

//        }


//        synchronized(obj1){
        if(hero!=null){
            for (Zidan o :hero.heroZidans) {

                if(!o.isX){
                    drawZidan(o.getX(),o.getY(),g,o.getDirect(),0);
                }
            }
            hero.heroZidans.removeIf(o->o.isX);
        }

//        }
//        synchronized(obj1){
            for (int i = 0; i < bomes.size(); i++) {
                Bome o = bomes.get(i);
                if (o.live > 12) {
                    g.drawImage(a, o.getX(), o.getY(), 60, 60, this);
                } else if (o.live > 9) {
                    g.drawImage(a1, o.getX(), o.getY(), 60, 60, this);

                } else if (o.live > 6) {
                    g.drawImage(a2, o.getX(), o.getY(), 60, 60, this);

                } else if (o.live > 3) {
                    g.drawImage(a3, o.getX(), o.getY(), 60, 60, this);
                } else {
                    g.drawImage(a4, o.getX(), o.getY(), 60, 60, this);

                }
                o.mulLive();

            }
            bomes.removeIf(aa->aa.isX);

//        }

    }

    public void pengZhuang(Zidan zidan,Tank enemyTank){

        if (zidan.isX || enemyTank.isX) return;
        switch (enemyTank.getDirect()){
            case 0:
            case 2:
                if((zidan.getX()+17)>=enemyTank.getX()&&(zidan.getX()+17)<=enemyTank.getX()+40&&zidan.getY()>=enemyTank.getY()&&zidan.getY()<=enemyTank.getY()+60){
                    Bome b= new Bome(enemyTank.getX(),enemyTank.getY());
                    bomes.add(b);
                    zidan.isX=true;
                    enemyTank.isX=true;

                }
                break;
            case 1:
            case 3:
                if(zidan.getX()>=enemyTank.getX()&&zidan.getX()<=enemyTank.getX()+60&&(zidan.getY()+17)>=enemyTank.getY()&&(zidan.getY()+17)<=enemyTank.getY()+40){
                    Bome b= new Bome(enemyTank.getX(),enemyTank.getY());
                    bomes.add(b);
                    zidan.isX=true;
                    enemyTank.isX=true;

                }
                break;
        }
    }

    public void drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type){
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1://敌人的坦克
                g.setColor(Color.yellow);
                break;
            default:
                break;
        }
        switch (direct){
            case 0://向上
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y);
                break;
            case 1://向右
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
            case 2://向下
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3://向右
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x,y+20);
                break;
            default:
                break;
        }

    }
    public void drawZidan(int x,int y,Graphics g,int direct,int type){
        switch (type){
            case 0://我们的子弹
                g.setColor(Color.cyan);
                break;
            case 1://敌人的子弹
                g.setColor(Color.yellow);
                break;
            default:
                break;
        }
        switch (direct){
            case 0://向上
                g.fillOval(x+17,y,6,6);
                break;
            case 1://向右
                g.fillOval(x+60,y+17,5,5);
                break;
            case 2://向下
                g.fillOval(x+17,y+60,5,5);
                break;
            case 3://向右
                g.fillOval(x,y+17,5,5);
                break;
            default:
                break;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int y=hero.getY();
        int x=hero.getX();
        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                hero.setDirect(2);
                hero.moveDown();

                if(y>=750){
                    hero.setY(750);
                }
                break;
            case KeyEvent.VK_LEFT:
                hero.setDirect(3);
                hero.moveLeft();
                if(x<=0){
                    hero.setX(0);;
                }
                break;
            case KeyEvent.VK_RIGHT:
                hero.setDirect(1);
                hero.moveRight();
                if(x>=1000){
                    hero.setX(1000);;
                }
                break;
            case KeyEvent.VK_UP:
                hero.setDirect(0);
                hero.moveUp();
                if(y<=0){
                    hero.setY(0);
                }
                break;
            case KeyEvent.VK_J:
                hero.faShe();
                break;
            default:
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);   // 20 FPS

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
                this.repaint();
            if(hero!=null){
                for (Zidan o :hero.heroZidans) {
                    for (EnemyTank aa :enemyTanks) {
                        aa.faShe();
                        pengZhuang(o,aa);
                    }

                }
                for (EnemyTank o :enemyTanks) {
                    for (Zidan aa :o.enemyZidans) {
                        pengZhuang(aa,hero);
                    }

                }
            }


        }
    }
}
