package com.mikedepinto.robotgame;

import android.graphics.Rect;


public class MainAttack extends Robot {

    private int x, y, speedX;
    private boolean visible;
    int al;

    private Rect r;

    public MainAttack(int startX, int startY){
        x = startX;
        y = startY;
        speedX = 7;
        visible = true;
        al = 0;
        r = new Rect(0, 0, 0, 0);
    }

    public int getAl() {
        return al;
    }

    public void update(){
        //x += speedX;
        al += speedX;
        r.set(x+75, y, x+50, y+100);

        if (al > 50){
            visible = false;
            r = null;

        }
        if (visible){
            checkCollision();
        }

    }

    private void checkCollision() {

        if (Rect.intersects(r, GameScreen.hb.r)){
           visible = false;

            if (GameScreen.hb.health > 0) {
                GameScreen.hb.health -= 1;
            }
            if (GameScreen.hb.health == 0) {
                GameScreen.hb.setCenterX(-100);
                GameScreen.getRobot().robotXP += GameScreen.hb.xpValue;
                GameScreen.getRobot().levelUp();


            }

        }
        if (Rect.intersects(r, GameScreen.hb2.r)){
            visible = false;

            if (GameScreen.hb2.health > 0) {
                GameScreen.hb2.health -= 1;
            }
            if (GameScreen.hb2.health == 0) {
                GameScreen.hb2.setCenterX(-100);
                GameScreen.getRobot().robotXP += GameScreen.hb.xpValue;
                GameScreen.getRobot().levelUp();


            }

        }
        if (Rect.intersects(r, GameScreen.hb3.r)){
            visible = false;

            if (GameScreen.hb3.health > 0) {
                GameScreen.hb3.health -= 1;
            }
            if (GameScreen.hb3.health == 0) {
                GameScreen.hb3.setCenterX(-100);
                GameScreen.getRobot().robotXP += GameScreen.hb.xpValue;
                GameScreen.getRobot().levelUp();


            }

        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSpeedX() {
        return speedX;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }


}
