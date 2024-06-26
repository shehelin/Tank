package com.mashibing.tank.model;

import com.mashibing.tank.Frame.TankFrame;
import com.mashibing.tank.confmgr.ResourceMgr;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;

import java.awt.*;

/**
 * 子弹
 * @Author hl.she
 * @Date 2020/5/17 10:53
 */
public class Bullet {
    private static final int SPEED = 8;
    public static int WIDTH = ResourceMgr.bulletD.getWidth(), HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x, y;
    private Dir dir;
    private boolean living = true;
    private TankFrame tf ;
    private Group group ;

    public Bullet(int x, int y, Dir dir, Group group ,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.dir = dir;
        this.tf = tf;
    }


    public void paint(Graphics g){
        /**
         * 不存活
         */
        if(!living){
            tf.bullets.remove(this);
        }
        switch (dir){
            case DOWN: g.drawImage(ResourceMgr.bulletD,x,y,null); break;
            case LEFT: g.drawImage(ResourceMgr.bulletL,x,y,null); break;
            case UP:  g.drawImage(ResourceMgr.bulletU,x,y,null);  break;
            case RIGHT: g.drawImage(ResourceMgr.bulletR,x,y,null);break;
            default:break;
        }
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
                living = false;
            }
    }


    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup()) return;

        Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rectangle1.intersects(rectangle2)){
            tank.die();
            this.die();
        }
    }

    public void die() {
     this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
