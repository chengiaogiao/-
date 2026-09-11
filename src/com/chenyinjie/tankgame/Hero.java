package com.chenyinjie.tankgame;

import java.util.Vector;
import java.util.function.Function;

public class Hero extends Tank {
    Vector<Zidan> heroZidans=new Vector<>();
    public Hero(int x, int y,int direct) {
        super(x, y,direct);
    }

    public void faShe(){
        System.out.println(super.getX());
        Zidan a= new Zidan(super.getX(),super.getY(),super.getDirect());
        a.setSpeed(20);
        heroZidans.add(a);
        Thread thread = new Thread(a);
        thread.start();
    }
}
