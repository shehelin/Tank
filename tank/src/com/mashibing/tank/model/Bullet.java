package com.mashibing.tank.model;

import com.mashibing.tank.enums.Dir;

import java.awt.*;

/**
 * @Author hl.she
 * @Date 2020/5/17 10:53
 */
public class Bullet {
    private static final int SPEED = 2;
    private static int WIDTH = 15,HEIGHT = 15;
    private int x, y;
    private Dir dir;
    private boolean moving = false;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }


    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);
        move();
    }
    public void move(){

            switch (dir){
                case LEFT:x-=SPEED;break;
                case UP:y-=SPEED;break;
                case RIGHT:x+=SPEED;break;
                case DOWN:y+=SPEED;break;
                default:break;
            }


    }

}
