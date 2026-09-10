package com.chenyinjie.draw;

import javafx.scene.layout.Pane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawCircle extends JFrame {
    private MyPanel a=null;
    public static void main(String[] args) {
       new DrawCircle();
    }

   public DrawCircle(){
       a = new MyPanel();
       this.add(a);
       this.setSize(300,400);
       this.addKeyListener(a);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setVisible(true);
   }
}

class MyPanel extends JPanel implements KeyListener {
    private int x=10;
    private int y=10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x,y,10,10);
//        g.drawOval(100,200,100,100);
//        g.drawLine(10,20,20,30);
//        g.drawRect(10,10,20,20);
//
//        g.setColor(Color.BLACK);
//        g.fillRect(20,20,30,30);
//
//        g.setColor(Color.BLACK);
//        g.fillOval(30,30,40,40);

//        Image image=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.jpg"));
//        g.drawImage(image,10,20,100,100,this);
//
//
//        g.setColor(Color.black);
//
//        g.setFont(new Font("草书",Font.BOLD,50));
//
//        g.drawString("陈英杰",200,100);
//        g.setColor(Color.blue);
//        g.fillRect(30,50,10,50);
//        g.setColor(Color.blue);
//        g.fillRect(60,50,10,50);
//        g.setColor(Color.blue);
//        g.fillRect(40,60,30,30);
//        g.setColor(Color.red);
//        g.fillOval(42,67,15,15);
//        g.setColor(Color.green);
//        g.fillRect(47,47,5,30);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.printf("keyTyped");
    }

    @Override
    public void keyPressed(KeyEvent e) {


        switch (e.getKeyCode()){
            case KeyEvent.VK_DOWN:
                y++;
                if(y>=400){
                    y=400;
                }
                break;
            case KeyEvent.VK_LEFT:
                x--;
                if(x<=0){
                    x=0;
                }
                break;
            case KeyEvent.VK_RIGHT:
                x++;
                if(x>=300){
                    x=300;
                }
                break;
            case KeyEvent.VK_UP:
                y--;
                if(y<=0){
                    y=0;
                }
                break;
            default:
                break;

        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.printf("keyReleased");
    }
}