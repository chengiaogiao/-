package com.chenyinjie.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    //定义坦克
    Hero hero=null;
    Vector<EnemyTank> enemyTanks=new Vector<>();

    int enemyTankSize=3;
    public MyPanel() {
        hero = new Hero(100,100,0,new ZidanCallback() {
            @Override
            public void en(){
                repaint();
            }
        });
        hero.setSpeed(5);

        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank =new EnemyTank(200+(i*100),0,2,new ZidanCallback() {
                @Override
                public void en(){
                    repaint();
                }
            });
            enemyTanks.add(enemyTank);
            Thread thread = new Thread(enemyTank);
            thread.start();
        }

    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.fillRect(0,0,1000,750);
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);
        synchronized(this){
            for (EnemyTank o :enemyTanks) {
                drawTank(o.getX(),o.getY(),g,o.getDirect(),1);
                for (Zidan c :o.enemyZidans) {
                    if(!c.isX){
                        drawZidan(c.getX(),c.getY(),g,c.getDirect(),0);
                    }

                }

            }

        }
        synchronized(this){
            for (Zidan o :hero.heroZidans) {
                if(!o.isX){
                    drawZidan(o.getX(),o.getY(),g,o.getDirect(),0);
                }

            }
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

//                if(y>=750){
//                    hero.setY(750);
//                }
                break;
            case KeyEvent.VK_LEFT:
                hero.setDirect(3);
                hero.moveLeft();
//                if(x<=0){
//                    hero.setX(0);;
//                }
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
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
