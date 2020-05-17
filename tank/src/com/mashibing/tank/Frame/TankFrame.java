package com.mashibing.tank.Frame;

import com.mashibing.tank.enums.Dir;
import com.mashibing.tank.model.Bullet;
import com.mashibing.tank.model.Tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hl.she
 * @Date 2020/5/16 19:59
 */
public class TankFrame extends Frame {

   Tank myTank = new Tank(25,25,Dir.DOWN,this);
   public List<Bullet> bullets = new ArrayList<Bullet>();
   public final static int GAME_WIDTH= 800 , GAME_HEIGHT = 600;

    public TankFrame() {

        setSize(GAME_WIDTH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new MyKeyListener());



    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if(offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH,GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        print(gOffScreen);
        g.drawImage(offScreenImage,0,0,null);

    }

    /**
     * 画柄
     * @param g
     */
    @Override
    public void paint(Graphics g){

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(),10,60);
        g.setColor(c);

        myTank.paint(g);
        for (int i = 0 ; i<bullets.size();i++){
            bullets.get(i).paint(g);
        }
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {
//            System.out.println("keyTyped");
        }

        Boolean bL = false;
        Boolean bR = false;
        Boolean bU = false;
        Boolean bD = false;

        /**
         * 按键按住
         * @param e
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            /**
             * VK_LEFT - 键盘 左键
             */
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }

        /**
         * 按键松开
         * @param e
         */
        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_CONTROL:
                    break;
                default:
                    break;
            }
            setMainTankDir();

        }

        private void setMainTankDir() {
            if(!bL && !bU && !bR && !bD){
                myTank.setMoving(false);
            }
           else{
                myTank.setMoving(true);
                if (bL) { myTank.setDir(Dir.LEFT);}
                if (bR) { myTank.setDir(Dir.RIGHT);}
                if (bU) { myTank.setDir(Dir.UP);}
                if (bD) { myTank.setDir(Dir.DOWN);}
            }

        }

    }

}
