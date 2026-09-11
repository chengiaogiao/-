package com.chenyinjie.tankgame;

public class Bome {
    private int x;
    private int y;
    public int live=15;
    public boolean isX=false;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bome(int x, int y) {
        this.y = y;
        this.x = x;
    }

    public void mulLive(){
        if(live>0){
            live--;
        }else{
            isX=true;
        }
    }
}
