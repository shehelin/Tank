package com.mashibing.tank.model;

import com.mashibing.tank.Frame.TankFrame;
import com.mashibing.tank.confmgr.ResourceMgr;
import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.enums.Group;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @Author hl.she
 * @Date 2020/5/17 10:20
 */
public class Tank {
    //坐标
    private int x, y;
    //方向
    private Dir dir;
    //是否移动
    private boolean moving = true;
    //坦克容器
    private TankFrame tf;
    //坦克宽高
    public static int WIDTH = ResourceMgr.tankD.getWidth(), HEIGHT = ResourceMgr.tankD.getHeight();
    //移动速度
    private static final int SPEED = 5;
    //坦克存活
    private boolean living = true;

    private Random random = new Random();

    public Random getRandom() {
        return random;
    }

    private Group group = Group.BAD;

    public Tank(int x, int y, Dir dir , Group group ,TankFrame tf) {
        super();
        this.dir = dir;
        this.group = group;
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

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * 画柄
     *
     * @param g
     */
    public void paint(Graphics g) {
        if (checkBoundary()){
            setMoving(false);
        }
        if(!living){
            tf.badTanks.remove(this);
        }
        switch (dir){
            case DOWN: g.drawImage(ResourceMgr.tankD,x,y,null); break;
            case LEFT: g.drawImage(ResourceMgr.tankL,x,y,null); break;
            case UP:  g.drawImage(ResourceMgr.tankU,x,y,null);  break;
            case RIGHT: g.drawImage(ResourceMgr.tankR,x,y,null);break;
            default:break;
        }

        move();
    }

    /**
     * 坦克移动
     */
    public void move() {
        if (moving) {
            switch (dir) {
                case LEFT:
                    x -= SPEED;
                    break;
                case UP:
                    y -= SPEED;
                    break;
                case RIGHT:
                    x += SPEED;
                    break;
                case DOWN:
                    y += SPEED;
                    break;
                default:
                    break;
            }
            //随机开火
            if( group == Group.BAD  && random.nextInt(10) > 8){
                this.fire();
            }
        }
    }

    /**
     * 坦克开火
     */
    public void fire() {
        int bX = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int bY= this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bX,bY, this.dir, this.group,tf));
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void die() {
        living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    /**
     * 校验边界值
     * @return
     */
    public boolean checkBoundary() {
        int offsetX = ResourceMgr.tankD.getWidth()/2;
        int offsetY = ResourceMgr.tankU.getHeight()/2;
        if ((this.getX() < offsetX && Dir.LEFT == dir)
                || (this.getY() < offsetY && Dir.UP == dir)
                || (this.getX() > TankFrame.GAME_WIDTH - offsetX && Dir.RIGHT == dir)
                || this.getY() > TankFrame.GAME_HEIGHT - offsetY && Dir.DOWN == dir)
            return true;
        return false;
    }
}
