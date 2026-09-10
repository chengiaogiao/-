package com.chenyinjie.tankgame;

import java.util.Vector;
import java.util.function.Function;

public class Hero extends Tank {
    Vector<Zidan> heroZidans=new Vector<>();
    ZidanCallback fn;
    public Hero(int x, int y,int direct,ZidanCallback fn) {
        super(x, y,direct);
        this.fn=fn;
    }

    public void faShe(){
        Zidan a= new Zidan(super.getX(),super.getY(),super.getDirect(),new ZidanCallback() {
            @Override
            public void en(){
                fn.en();
            }
        });
        a.setSpeed(20);
        heroZidans.removeIf(o->o.isX);
        heroZidans.add(a);
        Thread thread = new Thread(a);
        thread.start();
    }
}
