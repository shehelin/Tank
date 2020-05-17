package com.mashibing.tank.model;

import com.mashibing.tank.Frame.TankFrame;
import com.mashibing.tank.enums.Dir;

import java.awt.*;
import java.util.ArrayList;

/**
 * @Author hl.she
 * @Date 2020/5/17 10:20
 */
public class Tank {
    private int x,y;
    private Dir dir=Dir.DOWN;
    private boolean moving = false;
    private TankFrame tf = null;

    private static int WIDTH = 50,HEIGHT = 50;
    private static final int SPEED = 10;
    private boolean live = true;




    public Tank(int x,int y,Dir dir,TankFrame tf){
        super();
        this.dir = dir;
        this.x = x;
        this.y = y;
        this.tf = tf;
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * 坦克行为
     * @param g
     */
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(c);
        //刷新点
        move();
    }

    public void move(){
        if (moving){
            switch (dir){
                case LEFT:x-=SPEED;break;
                case UP:y-=SPEED;break;
                case RIGHT:x+=SPEED;break;
                case DOWN:y+=SPEED;break;
                default:break;
            }
        }

    }

    public void fire() {
        tf.bullets.add(new Bullet(this.x+15,this.y+15, this.dir ,tf));
    }
}
