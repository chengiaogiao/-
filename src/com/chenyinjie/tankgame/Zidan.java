package com.chenyinjie.tankgame;
interface ZidanCallback {
    void en();
}
public class Zidan implements Runnable {
        private int x;
        private int y;
        private int direct;
        private int speed=1;
        public boolean isX=false;
        private ZidanCallback callback;
        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void moveUp(){
            y-=speed;
        }
        public void moveRight(){
            x+=speed;
        }
        public void moveDown(){
            y+=speed;
        }
        public void moveLeft(){
            x-=speed;
        }

        public int getDirect() {
            return direct;
        }

        public void setDirect(int direct) {
            this.direct = direct;
        }

        public Zidan(int x, int y,int direct, ZidanCallback callback) {
            this.x = x;
            this.y = y;
            this.direct = direct;
            this.callback = callback;
        }

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

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (direct){
                case 0:
                    moveUp();
                    break;
                case 1:
                    moveRight();
                    break;
                case 2:
                    moveDown();

                    break;
                case 3:
                    moveLeft();
                default:
                    break;
            }
            if(x>=1000||x<0||y>=750||y<0){
                isX=true;
                callback.en();

                break;
            }
            callback.en();

        }
    }
}
