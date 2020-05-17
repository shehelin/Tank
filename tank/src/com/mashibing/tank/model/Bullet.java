package com.mashibing.tank.model;

import com.mashibing.tank.Frame.TankFrame;
import com.mashibing.tank.enums.Dir;

import java.awt.*;

/**
 * @Author hl.she
 * @Date 2020/5/17 10:53
 */
public class Bullet {
    private static final int SPEED = 15;
    private static int WIDTH = 15,HEIGHT = 15;
    private int x, y;
    private Dir dir;
    private boolean live = true;
    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g){
        /**
         * 不存活
         */
        if(!live){
            tf.bullets.remove(this);
        }
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

            //子弹飞出游戏画面
            if( x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT){
                live = false;
            }
    }



}
